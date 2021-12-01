package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cleric extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 15 & 20
    private int attackDamage;
    private int healChance = 25;


    public Cleric(String name,  String profession){
        super(name, profession);
        this.attackDamage = random.nextInt(6) + 15;
        this.playerHealth = 100;
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
        return "The owner of the castle probably has a lavish garden, which most likely contains the healing\n" +
                "herbs you need for your potions.\n";
    }

    public String oldManResponse1() {

        return "Hangman Man: So you're " + this.getName() + " the " + this.getProfession() + " eh? You're the softer type, then. Makes me wonder\n" +
                "what a person like you is doing out here, but I can already tell from the look in your eyes. You're here for someone else,\n" +
                "not yourself. That's real selfless of ya. Be careful though, your empathy could kill you out here.\n";
    }

    public String personalDesire() {
        return "The witch pulls out a small bag of herbs, the same rare healing herbs you're been looking for this entire time.\n" +
                "\n" +
                "The Witch: \"This is what you came all this way for, right? For these herbs? Well, it's all yours if you take my offer.\"\n";
    }

    public void attackMenu(Enemy evilEnemy, ArrayList<String> characterInventory) { //Takes in enemy to kill
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        ArrayList<String> inventory = characterInventory; //The inventory

        if (previousHealth < 120) {
            previousHealth = playerHealth;
        } else {
            int playerHealth = this.getPlayerHealth();
        }

        int enemyHealth = evilEnemy.getEnemyHealth(); //Enemy Health


        boolean running = true;

        OUTER:
        while (running) {

            INNER:
            while (enemyHealth > 0) {
                System.out.println("---------------");
                System.out.println("ATTACK MENU\n");

                System.out.println("CLERIC Options:\n" +
                        "[1] Attack\n" +
                        "[2] Trait\n" +
                        "[3] Inventory\n" +
                        "[4] Surrender\n");

                System.out.println("YOUR HEALTH: " + playerHealth + "\n"); //Player Health
                System.out.println("---------------");

                userChoice = scanner.nextLine();

                if (userChoice.equals("1")) {

                    this.attackDamage = random.nextInt(6) + 15; //Player Attack Damage

                    int enemyDamage = evilEnemy.getEnemyAttackDamage();

                    if(evilEnemy.getType().equals("Rock")) {
                        int reducedDamage = this.attackDamage = random.nextInt(6) + 15 / 2;
                        System.out.println("You throw a harmful elixir and do " + reducedDamage + " damage!");
                    } else if (evilEnemy.getType().equals("Shadow")) {
                        int shadowDamage = this.attackDamage = random.nextInt(6) + 20 + 5;
                        System.out.println("CRITICAL HIT! You throw a harmful elixir and do " + shadowDamage + " damage!");
                    }
                    else {
                        System.out.println("You throw a harmful elixir and do " + this.attackDamage + " damage!");
                    }

                    enemyHealth -= attackDamage;


                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {
                        if (evilEnemy.getSpecialAttackChance() != 0) {  //checking if enemy has special attack

                            if (random.nextInt(100) < evilEnemy.getSpecialAttackChance()) {  //if the enemy does have special attack, activate enemy trait
                                int enemySpecialDamage = evilEnemy.getSpecialAttackDamage();
                                System.out.println("Enemy Special Damage " + enemySpecialDamage);

                                playerHealth -= enemySpecialDamage;
                                System.out.println("Maze Guardian Health " + enemyHealth);
                                System.out.println("Enemy's special attack was activated");
                                System.out.println("!!-- You receive " + enemySpecialDamage + " damage. --!!");

                                if (random.nextInt(100) < healChance) {

                                    playerHealth += enemySpecialDamage;
                                    int healthGained = (int)Math.ceil(enemySpecialDamage * .5);
                                    playerHealth += healthGained;

                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("You showed EMPATHY! You drink a magical elixir and gain \n"
                                            + healthGained + " health! Your total health is now " + playerHealth);
                                    System.out.println("------------------------------------------------------------------------");

                                }

                            } else {     //if the enemy does have a special attack, but the chance wasn't high enough, then do the following

                                playerHealth -= enemyDamage;

                                System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                                System.out.println("!!-- You receive " + enemyDamage + " damage. --!!");
//                                System.out.println("Player Health " + playerHealth); //THIS IS SHOWING PLAYER HEALTH BEFORE THEY HAVE A CHANCE TO DODGE, MOVED IT DOWN--CAN PROBABLY REMOVE IT WHEN WE ARE FINISHED

                                //WE NEED AN OPPORTUNITY TO DODGE HERE TOO
                                if (random.nextInt(100) < healChance) {

                                    playerHealth += enemyDamage;
                                    int healthGained = (int)Math.ceil(enemyDamage * .5);
                                    playerHealth += healthGained;

                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("You showed EMPATHY! You drink a magical elixir and gain \n"
                                            + healthGained + " health! Your total health is now " + playerHealth);
                                    System.out.println("------------------------------------------------------------------------");

                                }

                            }
                        } else {   //if enemy has no special attack (like the goblin) do the following
                            playerHealth -= enemyDamage;

                            System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                            System.out.println("!!-- You receive " + enemyDamage + " damage. --!!"); //this needs to be printed here, after you subtract the damage
//                            System.out.println("Player Health " + playerHealth); //THIS IS SHOWING PLAYER HEALTH BEFORE THEY HAVE A CHANCE TO DODGE, MOVED IT DOWN

                            if (random.nextInt(100) < healChance) {

                                playerHealth += enemyDamage;
                                int healthGained = (int)Math.ceil(enemyDamage * .5);
                                playerHealth += healthGained;

                                System.out.println("------------------------------------------------------------------------");
                                System.out.println("You showed EMPATHY! You drink a magical elixir and gain \n"
                                        + healthGained + " health! Your total health is now " + playerHealth);
                                System.out.println("------------------------------------------------------------------------");

                            }

                        }

                    }
                    attackMenu();
                } else if (userChoice.equals("2")) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("\"Your trait is EMPATHY. Gives you a 25% chance to partially heal from an attack.\n" +
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
                                playerHealth = 100;
                                inventory.remove("HEALING POTION");
                                viewInventory = false;
                            } else if (userItem.equalsIgnoreCase("HEALING POTION 2") && inventory.contains("HEALING POTION 2")) {
                                System.out.println("You drink the entire HEALING POTION and regain your full health.");
                                playerHealth = 100;
                                inventory.remove("HEALING POTION 2");
                                viewInventory = false;
                            }
                            else if (userItem.equalsIgnoreCase("RED MUSHROOM") && inventory.contains("RED MUSHROOM")) {
                                System.out.println("What do you think you're going to do with that mushroom?");
                                attackMenu();
                            } else if (userItem.equalsIgnoreCase("LANTERN") && inventory.contains("LANTERN")) {
                                if (evilEnemy.getType().equals("Shadow")) {
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

    //for Cleric, enemy attack is negated, whatever damage the enemy would've done get's added back to the players health
}
