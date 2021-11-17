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
        }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttackDamage() {

        //Rhi: moved attackDamage in here that way when we call getEnemyAttackDamage, it gives us a
        // random num *every time* we call it
        this.enemyAttackDamage = random.nextInt(6) + 10; //THIS ISN"T THE PROPER DAMAGE RANGE, CHANGE LATER
        return enemyAttackDamage;
    }

    }

