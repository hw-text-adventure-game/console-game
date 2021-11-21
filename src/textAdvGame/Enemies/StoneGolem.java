package textAdvGame.Enemies;

import java.util.Random;

public class StoneGolem extends Enemy{

    private int enemyHealth;
    private int specialAttackChance = 35;  //percent chance
    public String type;

    Random random = new Random();
    private int enemyAttackDamage;

    public StoneGolem(String name) {
        super(name);
        this.enemyHealth = 120;
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
        return "*** A creature made entirely of rock. Has a special move, so be on your guard! ***";
    }

    public int getSpecialAttackDamage() {
        return this.enemyAttackDamage * 2;
    }

    public String getType() {
        return "Rock";
    }

    public String specialMessage() {
        return "*** The STONE GOLEM uses BOULDER! They pick up a giant rock and throw it at you! ***\n";
    }

    public String traitMessage() {
        return "!!- The STONE GOLEM is made of ROCK! Your attacks will only be half as effective! -!!\n";
    }

}


