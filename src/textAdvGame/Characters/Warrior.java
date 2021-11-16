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

    //warrior also has a trait for bravery, 50% chance to do double damage
    //if(random.nextInt(100) < bravery { multiply damage by 2 }
    private int bravery = 25;

    public void attackMenu(Enemy evilEnemy) { //Takes in enemy to kill

        Scanner scanner = new Scanner(System.in);
        String userChoice;

        this.playerHealth = 120;
        System.out.println("YOUR HEALTH:" + playerHealth); //Player Health

        int enemyHealth = evilEnemy.getEnemyHealth(); //Enemy Health

        int enemyDamage = evilEnemy.getEnemyAttackDamage();
        System.out.println("ENEMY DAMAGE:" + enemyDamage);


        while(enemyHealth > 0) {
            System.out.println("ATTACK MENU");

        System.out.println("Warrior Options:\n" +
                "[1] Attack\n" +
                "[2] Trait\n" +
                "[3] Inventory\n" +
                "[4] Surrender\n");

        userChoice = scanner.nextLine();

        if(userChoice.equals("1")) {
            if(random.nextInt(100) < bravery) {

                this.attackDamage = random.nextInt(6) + 20; //Player Attack Damage
                System.out.println("ENEMY HEALTH:" + enemyHealth); //Enemy Attack Damage

                enemyHealth -= attackDamage;
                playerHealth -= enemyDamage;

                System.out.println("You showed BRAVERY! You swing your sword valiantly, doing " + this.attackDamage * 2 + " damage!");
                System.out.println("*** You receive " + enemyDamage + " damage. Your remaining health is " + this.playerHealth);
            } else {
                System.out.println("You swing your sword and do " + this.attackDamage + " damage!");
                System.out.println("*** You receive " + enemyDamage + " damage. Your remaining health is " + this.playerHealth);
            }
            attackMenu();
        }
        else if(userChoice.equals("2")) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Your trait is BRAVERY. You have a 50% chance to do double the set damage.\n" +
            "This is a trait that is always active.");
            System.out.println("----------------------------------------------------------------------------------------");
            attackMenu();
        } else if(userChoice.equals("3")) {
            System.out.println("You don't have anything in your inventory.");
            attackMenu();
        } else if (userChoice.equals("4")) {
            System.out.println("Surrendering the fight will cause the game to end. Are you SURE you want to surrender? [Y/N]");
        } else {
            System.err.println("Pick a valid number.");
            attackMenu();
        }

    }


    }

}
