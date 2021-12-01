package textAdvGame.Enemies;

import java.util.Random;

public class Witch extends Enemy {

    private int enemyHealth;
    private int specialAttackChance = 20;  //percent chance
    public String type;

    Random random = new Random();
    private int enemyAttackDamage;


    public Witch(String name) {
        super(name);
        this.enemyHealth = 25;  //change this to 120 later
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttackDamage() {

        this.enemyAttackDamage = random.nextInt(6) + 15;
        return enemyAttackDamage;
    }

    public int getSpecialAttackChance() {
        return specialAttackChance;
    }

    public String monsterInfo() {
        return "*** A woman full of evil. Has a special move, so be on your guard! ***";
    }

    public int getSpecialAttackDamage() {
        return this.enemyAttackDamage * 2;
    }

    public String getType() {
        return "Normal";
    }

    public String specialMessage() {
        return "*** THE WITCH uses CURSE! She casts a dangerous spell on you! ***\n";
    }



}
