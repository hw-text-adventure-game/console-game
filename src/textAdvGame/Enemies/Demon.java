package textAdvGame.Enemies;

import java.util.Random;

public class Demon extends Enemy {

    private int enemyHealth;
    private int specialAttackChance = 15;  //percent chance
    public String type;

    Random random = new Random();
    private int enemyAttackDamage;


    public Demon(String name) {
        super(name);
        this.enemyHealth = 100;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttackDamage() {

        this.enemyAttackDamage = random.nextInt(6) + 10;
        return enemyAttackDamage;
    }

    public int getSpecialAttackChance() {
        return specialAttackChance;
    }

    public String monsterInfo() {
        return "*** A demon that blends in with the darkness. Has a special move, so be on your guard! ***";
    }

    public int getSpecialAttackDamage() {
        return this.enemyAttackDamage * 2;
    }

    public String getType() {
        return "Shadow";
    }

    public String specialMessage() {
        return "*** The PHANTOM DEMON uses FANG! They fly at you and bite your arm, causing you to bleed! ***\n";
    }

    public String traitMessage() {
        return "!!- The PHANTOM DEMON is a SHADOW monster! +5 damage will be added if your character has a weapon that produces light! -!!\n" +
                "!!- If you have a LANTERN, you can scare the PHANTOM DEMON away! -!!\n";
    }

}
