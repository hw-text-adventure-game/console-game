package textAdvGame.Characters;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;

import java.util.ArrayList;
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
        this.attackDamage = random.nextInt(6) + 15;
        this.attackDamage2 = random.nextInt(6) + 15;
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

    public void showInventory(ArrayList<String> characterInventory) {

        if(!characterInventory.isEmpty()) {
            for(String item : characterInventory) {
                System.out.println("- " + item); //Counter was just printing 1 for every item,
                // so I had to change it until a solution is found :(
            }
        }
    }

    public String personalMessage1() {
        return "You can feel the magical aura of this castle; the Revival Stone is definitely hidden in there.\n";
    }

    public String oldManResponse1() {

        return "Hangman Man: So you're " + this.getName() + " the " + this.getProfession() + " eh? And you want to find the Revival Stone? Heh heh,\n" +
                "you're even more persistent than the other bozos who come through these woods; I guess that's what mages are after these\n" +
                "days. The Witch might have it, but I doubt she'd give it up to anyone, so you should just give up...but even if I say that,\n" +
                "I know you won't give up either. heh.\n";
    }

    public void attackMenu(Enemy evilEnemy, ArrayList<String> characterInventory) { //Takes in enemy to kill
        int previousHealth = 0;

        Scanner scanner = new Scanner(System.in);
        String userChoice;
        ArrayList<String> inventory = characterInventory; //The inventory

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

            INNER:
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

                    this.attackDamage = random.nextInt(6) + 15; //Player Attack Damage
                    this.attackDamage2 = random.nextInt(6) + 15; //second roll

                    int enemyDamage = evilEnemy.getEnemyAttackDamage();

                    if(evilEnemy.getType().equals("Rock")) {
                        int reducedDamage = this.attackDamage = random.nextInt(6) + 15 / 2;
                        System.out.println("You cast a spell and do " + reducedDamage + " damage!");
                    } else if (evilEnemy.getType().equals("Shadow")) {
                        int shadowDamage = this.attackDamage = random.nextInt(6) + 20 + 5;
                        System.out.println("CRITICAL HIT! You cast a spell and do " + shadowDamage + " damage!");
                    }
                    else {
                        System.out.println("You cast a spell and do " + this.attackDamage + " damage!");
                    }

                    enemyHealth -= attackDamage;

                    if (enemyHealth <= 0) { //Displays 0 if enemy health dips into negatives
                        System.out.println("*** The " + evilEnemy.getName() + " has no more health! ***");
                    } else {
                        System.out.println("*** The " + evilEnemy.getName() + "'s health is now " + enemyHealth + " ***");

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
                System.out.println("*******************************");
                System.out.println("*** The enemy was defeated! ***");
                System.out.println("*******************************");
            previousHealth = playerHealth;
        } else {
            break;
            }
        } //end of while running loop

    }

}
