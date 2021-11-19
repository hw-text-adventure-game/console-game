package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

public class WitchHunter extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage;

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

    public String personalMessage1() {
        return "This where the witch resides; you can feel it in your bones.";
    }

    //witch hunter has a trait for adaptability, 25% chance to dodge an attack/cancel out the enemy attack
    //if(random.nextInt(100) < dodgeChance{ add back whatever health amount was deducted}
    private int dodgeChance = 25;


    public void attackMenu(Enemy evilEnemy) { //Takes in enemy to kill
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;

//        this.playerHealth = 120;
        if(previousHealth < 120){
            previousHealth = playerHealth;
        } else {
            int playerHealth = this.getPlayerHealth();
        }

        int enemyHealth = evilEnemy.getEnemyHealth(); //Enemy Health

//        int enemyDamage = evilEnemy.getEnemyAttackDamage();  //this one is not giving a random number each time, it's giving a random number once, then using that same number for each attack
//        int enemyDamage = random.nextInt(6) + 20;        //this is also not giving a random number each time, I think this needs to be in the if statement
//        System.out.println("ENEMY DAMAGE:" + enemyDamage);

        boolean running = true;

        OUTER:
        while(running) {

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

                    System.out.println("You shoot your crossbow and do " + this.attackDamage + " damage!");

                    enemyHealth -= attackDamage;


                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {

                        playerHealth -= enemyDamage; //Only lower player health if monster is alive

                        System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");

                        if (random.nextInt(100) < dodgeChance) {

                            playerHealth += enemyDamage;

                            System.out.println("------------------------------------------------------------------------");
                            System.out.println("You showed ADAPTABILITY! You predicted the enemies moves and dodged their attack!");
                            System.out.println("------------------------------------------------------------------------");

                        } else {
                            System.out.println("!!-- You receive " + enemyDamage + " damage. --!!");
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
                    System.out.println("You don't have anything in your inventory.");
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


        }

