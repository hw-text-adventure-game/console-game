package textAdvGame.Enemies;

import java.util.Random;

public class Goblin extends Enemy {

    private int enemyHealth;
    private int specialAttack = 0;

    Random random = new Random();
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
        this.enemyAttackDamage = random.nextInt(6) + 5;
        return enemyAttackDamage;
    }

    public String monsterInfo() {
        return "*** A creature with green skin and a large nose. Probably smells bad. ***\n";
    }

    }

