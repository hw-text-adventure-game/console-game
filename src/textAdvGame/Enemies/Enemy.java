package textAdvGame.Enemies;

public class Enemy {

    private static int enemyAttackDamage;
    private String name;
    private int enemyHealth;

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



}
