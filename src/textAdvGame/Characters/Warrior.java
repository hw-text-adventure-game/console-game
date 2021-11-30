package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Warrior extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage;
    boolean alive = true;

    public Warrior(String name,  String profession){
        super(name, profession);
        this.playerHealth = 120;
        this.attackDamage = random.nextInt(6) + 20; //random.nextInt(MAX-MIN) + MIN; //or from 0 to 5 shifted + 20
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    //Rhi notes:
    //The code works, it's just how to get it like to original console game's functionality.
    //Mary would have a better idea of how to refactor this since she made the first version of the
    // console game.

    public int getAttackDamage() {
        return attackDamage;
    }

    public boolean getStatus() {
        return alive;
    }

    public void showInventory(ArrayList<String> characterInventory) {

        if(!characterInventory.isEmpty()) {
            for(String item : characterInventory) {
                System.out.println("- " + item); //Counter was just printing 1 for every item,
                                                 // so I had to change it until a solution is found :(
            }
        }
    }

    public String personalMessage1() {
        return "You wonder if this is what the citizens are afraid of; it would be wise to investigate the castle.\n";
    }

    public String oldManResponse1() {

        return "Hangman Man: So you're " + this.getName() + " the " + this.getProfession() + " eh? You're a brave soul for coming all the way out here.\n" +
                "I bet people rely on you a lot where you come from, huh? It must be nice, having people depend on you. Well, I hope you put\n" +
                "a stop to The Witch once and for all, for your people's sake.\n";
    }

    private int bravery = 25;

    public void attackMenu(Enemy evilEnemy, ArrayList<String> characterInventory) { //Takes in enemy to kill + inventory
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        ArrayList<String> inventory = characterInventory; //The inventory

        if(previousHealth < 120){ //keeps track of your health from last fight
            previousHealth = playerHealth;
        } else {
            int playerHealth = this.getPlayerHealth();
        }

        int enemyHealth = evilEnemy.getEnemyHealth(); //Enemy Health


        boolean running = true;

        OUTER:
        while(running) {

            INNER:
            while (enemyHealth > 0) {
                System.out.println("---------------");
                System.out.println("ATTACK MENU\n");

                System.out.println("WARRIOR Options:\n" +
                        "[1] Attack\n" +
                        "[2] Trait\n" +
                        "[3] Inventory\n" +
                        "[4] Surrender\n");

                System.out.println("YOUR HEALTH: " + playerHealth + "\n"); //Player Health
                System.out.println("---------------");

                userChoice = scanner.nextLine();

                if (userChoice.equals("1")) {

                    this.attackDamage = random.nextInt(6) + 20; //Player Attack Damage

                    int enemyDamage = evilEnemy.getEnemyAttackDamage();

                    if(evilEnemy.getType().equals("Rock")) {
                        int reducedDamage = this.attackDamage = random.nextInt(6) + 20 / 2;
                        System.out.println("You swing your sword and do " + reducedDamage + " damage!"); //Attack if monster type is rock
                    } else if (evilEnemy.getType().equals("Plant")) {
                        int plantDamage = this.attackDamage = random.nextInt(6) + 20 + 5;
                        System.out.println("CRITICAL HIT! You swing your sword and do " + plantDamage + " damage!");
                    }
                    else {
                        System.out.println("You swing your sword and do " + this.attackDamage + " damage!"); //Attack
                    }


                    enemyHealth -= attackDamage;

                    if (random.nextInt(100) < bravery) { //Check if you can use trait

                        enemyHealth -= attackDamage;

                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("You showed BRAVERY! You swing your sword valiantly, doing double damage!");
                        System.out.println("------------------------------------------------------------------------");

                        if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negative, schecks after double damagek
                            System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                            break;
                        } else {
                            System.out.println("*** The " + evilEnemy.getName() + "'s health after using your TRAIT is now " + enemyHealth + " ***");
                        }
                    }
                    else if (random.nextInt(100) > bravery){
                        if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negative, schecks after double damagek
                            System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                            break;
                        } else {
                            System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                        }

                    } else {
                        System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                    }

                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                        break;
                    }

                        if(evilEnemy.getSpecialAttackChance() != 0) {  //checking if enemy has special attack

                            if (random.nextInt(100) < evilEnemy.getSpecialAttackChance()) {  //if the enemy does have special attack, activate enemy special attack
                                int enemySpecialDamage = evilEnemy.getSpecialAttackDamage();

                                playerHealth -= enemySpecialDamage;

                                System.out.println(evilEnemy.specialMessage() + "!!-- It does " + enemySpecialDamage + " damage! --!!");
                            }
                            else {     //if the enemy does have a special attack, but the chance wasn't high enough, then do the following

                                playerHealth -= enemyDamage;

                                System.out.println("!!-- You receive " + enemyDamage + " damage. --!!");
                            }
                        } else {   //if enemy has no special attack (like the goblin) do the following

                            playerHealth -= enemyDamage;

                            System.out.println("!!-- You receive " + enemyDamage + " damage. --!!"); //this needs to be printed here, after you subtract the damage
                        }


                    attackMenu();
                } else if (userChoice.equals("2")) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Your trait is BRAVERY. You have a 25% chance to do double the set damage.\n" +
                            "This is a trait that is always active.");
                    System.out.println("----------------------------------------------------------------------------------------");
                    attackMenu();
                } else if (userChoice.equals("3")) {

                    showInventory(inventory);
                    boolean viewInventory = true;
                    while(viewInventory) {
                        if (inventory.isEmpty()) {
                            System.out.println("You have nothing in your inventory.");
                            viewInventory = false;
                        } else {
                            System.out.println("Which item do you want to use? Type out the name of the item, or type exit to go back to the menu.");
                            String userItem = scanner.nextLine();

                            if (userItem.equalsIgnoreCase("BEWITCHED BELL") && inventory.contains("BEWITCHED BELL")) {
                                System.out.println("You use the BEWITCHED BELL, the " + evilEnemy.getName() + " cowers in fear and runs away! After the monster is out of your sight, the\n" +
                                        "bell shatters, its broken remains falling to the floor.");
                                inventory.remove("BEWITCHED BELL");
                                alive = true;
                                break INNER;
                            }
                            else if (userItem.equalsIgnoreCase("DIVINE BLADE") && inventory.contains("DIVINE BLADE")) {
                                System.out.println("You wield the DIVINE BLADE and attack your enemy! The " + evilEnemy.getName() + " bursts\n" +
                                        "into a magical light, the soul being freed from the monster's curse! The DIVINE BLADE slowly fades\n" +
                                        "into magical light as well, rendering the weapon unusable.\n");
                                inventory.remove("DIVINE BLADE");
                                alive = true;
                                break INNER;
                            }
                            else if (userItem.equalsIgnoreCase("HEALING POTION") && inventory.contains("HEALING POTION")) {
                                System.out.println("You drink the entire HEALING POTION and regain your full health.");
                                playerHealth = 120;
                                inventory.remove("HEALING POTION");
                                viewInventory = false;
                            } else if (userItem.equalsIgnoreCase("HEALING POTION 2") && inventory.contains("HEALING POTION 2")) {
                                System.out.println("You drink the entire HEALING POTION and regain your full health.");
                                playerHealth = 120;
                                inventory.remove("HEALING POTION 2");
                                viewInventory = false;
                            }
                            else if (userItem.equalsIgnoreCase("RED MUSHROOM") && inventory.contains("RED MUSHROOM")) {
                                System.out.println("What do you think you're going to do with that mushroom?");
                                attackMenu();
                            } else if (userItem.equalsIgnoreCase("LANTERN") && inventory.contains("LANTERN")) {
                                if(evilEnemy.getType().equals("Shadow")) {
                                    System.out.println("You pull out the LANTERN! The monster cowers in fear and runs away from the bright light!");
                                    alive = true;
                                    break INNER;
                                } else {
                                    System.out.println("You pull out the LANTERN, but nothing happens. (Use this on shadow type monsters!)");
                                    attackMenu();
                                }
                            }
                            else if (userItem.equalsIgnoreCase("exit")) {
                                viewInventory = false;
                            } else {
                                System.out.println("You don't have that item in your inventory!");
                                showInventory(inventory);
                            }
                        }

                    }


                } else if (userChoice.equals("4")) {
                    System.out.println("Surrendering the fight will cause the game to end. Are you SURE you want to surrender? [Y/N]");
                    //need to add something here, if user enters yes....
                    String reply = scanner.nextLine();
                    if (reply.equalsIgnoreCase("Y")) {
                        alive = false;
                        break OUTER;
                    }
                } else {
                    System.err.println("Pick a valid number.");
                    attackMenu();
                }
                if (playerHealth < 1) {
                    System.out.println("*** You died............. *** ");
                    alive = false;
                    break;
                }


            }
            //outside of the inner while loop,
            running = false; //if you remove this line, it will cause an infinite loop that says the enemy was defeated...

            if(alive == true) { //Will only print this if you're alive, removing the problem that this
                //message would pop up whether or not you won or lost
                System.out.println("*******************************");
                System.out.println("*** The enemy was defeated! ***");
                System.out.println("*******************************");
                previousHealth = playerHealth;
            } else {
                break;
            }


            //after this, we can give more options...
        } //end of outer while loop

//            System.out.println(alive);


    }


}