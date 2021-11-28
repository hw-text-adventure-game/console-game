package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.ArrayList;
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

    public void showInventory(ArrayList<String> characterInventory) {

        if(!characterInventory.isEmpty()) {
            for(String item : characterInventory) {
                System.out.println("- " + item); //Counter was just printing 1 for every item,
                // so I had to change it until a solution is found :(
            }
        }
    }

    public String personalMessage1() {
        return "A castle this big is bound to be full of treasure, you hit the jackpot!\n";
    }

    public String oldManResponse1() {

        return "So you're " + this.getName() + " the " + this.getProfession() + " eh? I really despise your kind; you don't care what\n" +
                "you take, as long as it benefits you in the end...but if that's what the world has come to, guess I can't entirely blame\n" +
                "ya. Oh well, I reckon if you're quick enough you can snatch a potion or two from The Witch; it'll fetch ya a high price.\n";
    }

    //also has a trait for agility, run away from battle, can be used 3 times to "cancel" a fight
    private int agility = 3;

    public void attackMenu(Enemy evilEnemy, ArrayList<String> characterInventory) { //Takes in enemy to kill
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        ArrayList<String> inventory = characterInventory; //The inventory

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

            INNER:
            while (enemyHealth > 0) {
                System.out.println("---------------");
                System.out.println("ATTACK MENU\n");

                System.out.println("THIEF Options:\n" +
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
                        System.out.println("You slash the enemy with your blades and do " + reducedDamage + " damage!"); //Attack if monster type is rock
                    } else if (evilEnemy.getType().equals("Plant")) {
                        int plantDamage = this.attackDamage = random.nextInt(6) + 20 + 5;
                        System.out.println("CRITICAL HIT! You slash the enemy with your blades and do " + plantDamage + " damage!");
                    }
                    else {
                        System.out.println("You slash the enemy with your blades and do " + this.attackDamage + " damage!"); //Attack
                    }


                    enemyHealth -= attackDamage;


                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {
                        System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");
                    }
                        if(evilEnemy.getSpecialAttackChance() != 0) {  //checking if enemy has special attack

                            if (random.nextInt(100) < evilEnemy.getSpecialAttackChance()) {  //if the enemy does have special attack, activate enemy trait
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

                            System.out.println("!!-- You receive " + enemyDamage + " damage. --!!");
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
