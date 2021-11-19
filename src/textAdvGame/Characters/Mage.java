package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

public class Mage extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 15 & 20
    private int attackDamage;
    private int attackDamage2;
    boolean alive = true;

    public Mage(String name,  String profession){
        super(name, profession);
        this.playerHealth = 100;
        this.attackDamage = random.nextInt(6) + 10;
        this.attackDamage2 = random.nextInt(6) + 10;
    }
    //not sure if this needs to be in the constructor, or in the game, probably in the game
    //if(random.nextInt(100) < secondAttackChance{ do the attackmethod again}
    private int persistence = 25;

    //mage also has a trait for perseverance, 25% chance to do a second attack
    //(give the player an extra turn)

    public int getPlayerHealth() {
        return playerHealth;
    }
    public int getAttackDamage() {
        return attackDamage;
    }
    public boolean getStatus() {
        return alive;
    }


    public void attackMenu(Enemy evilEnemy) { //Takes in enemy to kill
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;

//        this.playerHealth = 100;
        if(previousHealth < 100){
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

                System.out.println("MAGE Options:\n" +
                        "[1] Attack\n" +
                        "[2] Trait\n" +
                        "[3] Inventory\n" +
                        "[4] Surrender\n");

                System.out.println("YOUR HEALTH: " + playerHealth + "\n"); //Player Health
                System.out.println("---------------");

                userChoice = scanner.nextLine();

                if (userChoice.equals("1")) {

                    this.attackDamage = random.nextInt(6) + 20; //Player Attack Damage
                    this.attackDamage2 = random.nextInt(6) + 20; //second roll

                    int enemyDamage = evilEnemy.getEnemyAttackDamage();

                    System.out.println("You cast a spell and do " + this.attackDamage + " damage!");

                    enemyHealth -= attackDamage;

                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {

                    playerHealth -= enemyDamage;

                    System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                    System.out.println("!!-- You receive " + enemyDamage + " damage. --!! Your remaining health is " + playerHealth); //this needs to be printed here, after you subtract the damage

                    if (random.nextInt(100) < persistence) {

                        enemyHealth -= attackDamage2;

                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("You showed PERSISTENCE! Determined to not let the enemy get the best of you,\n" +
                                "you cast a second spell, doing " + this.attackDamage2 + " damage!"); //Generates a second random number
                        System.out.println("------------------------------------------------------------------------");

                        if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives, checks after second attack
                            System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                        } else {
                            System.out.println("*** The " + evilEnemy.getName() + "'s health after using your TRAIT is now " + enemyHealth + " ***");
                        }

                    }

                }

                    attackMenu();
                } else if (userChoice.equals("2")) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Your trait is PERSISTENCE. You have a 25% chance to do a second attack.\n" +
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
            previousHealth = playerHealth;
            //after this, we can give more options...
        } //end of outer while loop

//        System.out.println(alive);


    }


}
