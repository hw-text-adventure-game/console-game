package textAdvGame.Enemies;

import java.util.Random;

public class MazeGuard extends Enemy{

    private int enemyHealth;
    private int specialAttackChance = 25;  //percent chance

    Random random = new Random();
    private int enemyAttackDamage;

    public MazeGuard(String name) {
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
        return "*** Put a description here. ***";
    }

}
//if the enemy has a special trait, put that number into the variable;
//if specialAttack != 0, then do the attack
