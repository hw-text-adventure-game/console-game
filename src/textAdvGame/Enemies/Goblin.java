package textAdvGame.Enemies;

import java.util.Random;

public class Goblin extends Enemy {

    private int enemyHealth;

    Random random = new Random();
    //attack bw 20 & 25
    private int enemyAttackDamage;

    public Goblin(String name) {
        super(name);
            this.enemyHealth = 100;
            this.enemyAttackDamage = random.nextInt(6) + 20; //THIS ISN"T THE PROPER DAMAGE RANGE, CHANGE LATER
        }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    }
