package textAdvGame.Enemies;

public class Enemy {

    private static int enemyAttackDamage;
    private String name;
    private int enemyHealth;
    private int specialAttackChance;


    public Enemy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public int getSpecialAttackChance() {
        return specialAttackChance;
    }

    public String monsterInfo() {
        return null;
    }


}
