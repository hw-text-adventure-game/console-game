package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

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

    //warrior also has a trait for bravery, 50% chance to do double damage
    //if(random.nextInt(100) < bravery { multiply damage by 2 }
    private int bravery = 25;

    public void attackMenu(Enemy evilEnemy) { //Takes in enemy to kill

        Scanner scanner = new Scanner(System.in);
        String userChoice;

        this.playerHealth = 120;

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

                System.out.println("Warrior Options:\n" +
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

                    System.out.println("You swing your sword and do " + this.attackDamage + " damage!");

                    enemyHealth -= attackDamage;
                    playerHealth -= enemyDamage;

                    System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                    System.out.println("!!-- You receive " + enemyDamage + " damage. --!! Your remaining health is " + playerHealth); //this needs to be printed here, after you subtract the damage

                    if (random.nextInt(100) < bravery) {

                        enemyHealth -= attackDamage;

                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("You showed BRAVERY! You swing your sword valiantly, doing double damage!");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("*** The " + evilEnemy.getName() + "'s health after using your TRAIT is now " + enemyHealth + " ***");

                    }

                    attackMenu();
                } else if (userChoice.equals("2")) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Your trait is BRAVERY. You have a 50% chance to do double the set damage.\n" +
                            "This is a trait that is always active.");
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
            System.out.println("*******************************");
            System.out.println("*** The enemy was defeated! ***");
            System.out.println("*******************************");
            //after this, we can give more options...
        } //end of outer while loop

            System.out.println(alive);


    }

}