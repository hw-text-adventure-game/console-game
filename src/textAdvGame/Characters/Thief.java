package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

public class Thief extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage;

    public Thief(String name,  String profession){
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
        return "A mansion this big is bound to be full of treasure, you hit the jackpot!";
    }

    //also has a trait for agility, run away from battle, can be used 3 times to "cancel" a fight
    private int agility = 3;

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

                    System.out.println("You swing your sword and do " + this.attackDamage + " damage!");

                    enemyHealth -= attackDamage;


                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {
                        if(evilEnemy.getSpecialAttackChance() != 0) {  //checking if enemy has special attack

                            if (random.nextInt(100) < evilEnemy.getSpecialAttackChance()) {  //if the enemy does have special attack, activate enemy trait
                                int enemySpecialDamage = evilEnemy.getSpecialAttackDamage();
                                System.out.println("Enemy Special Damage " + enemySpecialDamage);

                                playerHealth -= enemySpecialDamage;
                                System.out.println("Enemy's special attack was activated");
                                System.out.println("Special Damage " + enemySpecialDamage);
                                System.out.println("Player Health " + playerHealth);
                                System.out.println("Maze Guardian Health " + enemyHealth);
                            }
                            else {     //if the enemy does have a special attack, but the chance wasn't high enough, then do the following

                                playerHealth -= enemyDamage;

                                System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                                System.out.println("!!-- You receive " + enemyDamage + " damage. --!!");
                                System.out.println("Player Health " + playerHealth);
                            }
                        } else {   //if enemy has no special attack (like the goblin) do the following

                            playerHealth -= enemyDamage;

                            System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                            System.out.println("!!-- You receive " + enemyDamage + " damage. --!!"); //this needs to be printed here, after you subtract the damage
                            System.out.println("Player Health " + playerHealth);
                        }
                    }
                    attackMenu();
                } else if (userChoice.equals("2")) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("Your trait is AGILITY. You can run away from a battle. Can only be used\n" +
                            "three times. Would you like to use your trait? [Y/N]");
                    System.out.println("----------------------------------------------------------------------------------------");
                    String runAway = scanner.nextLine();
                    if (runAway.equalsIgnoreCase("Y")) {
                        if(agility > 1){
                            agility--;
                            System.out.println("You showed AGILITY! You decided the battle was not one worth winning, so you\n" +
                                    "make a tactful retreat! You can run away " + agility + " more times.");
                            alive = true;
                            break OUTER;
                        } else if (agility == 1){
                            agility--;
                            System.out.println("You use the last of your AGILITY. You can't run away anymore after this.");
                        }else {
                            System.out.println("You tried to show AGILITY, but the enemy corners you! You can't run away anymore.");
                            attackMenu();
                        }
                    } else {
                        attackMenu();
                    }
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

            if(alive == true) { //Will only print this if you're alive, removing the problem that this
                //message would pop up whether or not you won or lost
                System.out.println("*******************************");
                System.out.println("*** The enemy was defeated! ***");
                System.out.println("*******************************");
                previousHealth = playerHealth;
            } else {
                break;
            }


        } //end of outer while loop

    }


}
