package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WitchHunter extends Character {
    private int playerHealth;
    Random random = new Random();
    private int attackDamage;
    private int dodgeChance = 25;  //witch hunter trait for adaptability, Percent% chance to dodge an attack/cancel out the enemy attack
    private ArrayList<String> inventory = new ArrayList<>();

    public WitchHunter(String name,  String profession){
        super(name, profession);
        this.playerHealth = 120;
        this.attackDamage = random.nextInt(6) + 20;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
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
        return "This where the witch resides; you can feel it in your bones.\n";
    }

    public String oldManResponse1() {

        return "So you're " + this.getName() + " the " + this.getProfession() + " eh?";
    }

    public void attackMenu(Enemy evilEnemy, ArrayList<String> characterInventory) { //Takes in enemy to kill
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        ArrayList<String> inventory = characterInventory; //The inventory

        if(previousHealth < 120){
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

                System.out.println("WITCH HUNTER Options:\n" +
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
                        System.out.println("You shoot your crossbow and do " + reducedDamage + " damage!"); //Attack if monster type is rock
                    } else if (evilEnemy.getType().equals("Plant")) {
                        int plantDamage = this.attackDamage = random.nextInt(6) + 20 + 5;
                        System.out.println("CRITICAL HIT! You shoot your crossbow and do " + plantDamage + " damage!");
                    }
                    else {
                        System.out.println("You shoot your crossbow and do " + this.attackDamage + " damage!"); //Attack
                    }

                    enemyHealth -= attackDamage;


                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {
                        if(evilEnemy.getSpecialAttackChance() != 0) {  //checking if enemy has special attack

                            if (random.nextInt(100) < evilEnemy.getSpecialAttackChance()) {  //if the enemy does have special attack, activate enemy trait
                                int enemySpecialDamage = evilEnemy.getSpecialAttackDamage();

                                System.out.println(evilEnemy.specialMessage() + "!!-- It does " + enemySpecialDamage + " damage! --!!");

                                playerHealth -= enemySpecialDamage;

                                if (random.nextInt(100) < dodgeChance) {

                                    playerHealth += enemySpecialDamage;

                                    System.out.println("---------------------------------------------------------------------------------");
                                    System.out.println("You showed ADAPTABILITY! You predicted the enemies moves and dodged their attack\n" +
                                            "before it could hit you!");
                                    System.out.println("---------------------------------------------------------------------------------");

                                }

                            } else {     //if the enemy does have a special attack, but the chance wasn't high enough, then do the following

                                playerHealth -= enemyDamage;

                                System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                                System.out.println("!!-- You receive " + enemyDamage + " damage. --!!");
//                                System.out.println("Player Health " + playerHealth); //THIS IS SHOWING PLAYER HEALTH BEFORE THEY HAVE A CHANCE TO DODGE, MOVED IT DOWN--CAN PROBABLY REMOVE IT WHEN WE ARE FINISHED

                                //WE NEED AN OPPORTUNITY TO DODGE HERE TOO
                                if (random.nextInt(100) < dodgeChance) {

                                playerHealth += enemyDamage;

                                    System.out.println("---------------------------------------------------------------------------------");
                                    System.out.println("You showed ADAPTABILITY! You predicted the enemies moves and dodged their attack\n" +
                                            "before it could hit you!");
                                    System.out.println("---------------------------------------------------------------------------------");

                                }

                            }
                        } else {   //if enemy has no special attack (like the goblin) do the following
                            playerHealth -= enemyDamage;

                            System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                            System.out.println("!!-- You receive " + enemyDamage + " damage. --!!"); //this needs to be printed here, after you subtract the damage
//                            System.out.println("Player Health " + playerHealth); //THIS IS SHOWING PLAYER HEALTH BEFORE THEY HAVE A CHANCE TO DODGE, MOVED IT DOWN

                                if (random.nextInt(100) < dodgeChance) {

                                    playerHealth += enemyDamage;

                                    System.out.println("---------------------------------------------------------------------------------");
                                    System.out.println("You showed ADAPTABILITY! You predicted the enemies moves and dodged their attack\n" +
                                            "before it could hit you!");
                                    System.out.println("---------------------------------------------------------------------------------");

                                }

                        }

                    }
                    attackMenu();
                } else if (userChoice.equals("2")) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("\"Your trait is ADAPTABILITY. Gives you a 25% chance to dodge any attack.\n" +
                            "This is a trait that is always active.\"");
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
                            } else if (userItem.equalsIgnoreCase("exit")) {
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

            if (alive == true) { //Will only print this if you're alive, removing the problem that this
                //message would pop up whether or not you won or lost
                System.out.println("*******************************");
                System.out.println("*** The enemy was defeated! ***");
                System.out.println("*******************************");
                previousHealth = playerHealth;
            } else {
                break;
            }
        }
    }


        }

