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
        this.attackDamage = random.nextInt(6) + 10;
        this.playerHealth = 100;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public String personalMessage1() {
        return "The owner of the castle probably has a lavish garden, which most likely contains the healing\n" +
                "herbs you need for your potions.";
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

                    this.attackDamage = random.nextInt(6) + 20; //Player Attack Damage

                    int enemyDamage = evilEnemy.getEnemyAttackDamage();

                    System.out.println("You throw a harmful elixir and do " + this.attackDamage + " damage!");

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
                                System.out.println("Player Health " + playerHealth);

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
                            System.out.println("Player Health " + playerHealth);

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
                    attackMenu();
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
