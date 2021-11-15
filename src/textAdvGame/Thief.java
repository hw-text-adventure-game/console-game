package textAdvGame;

import java.util.Random;

public class Thief extends Character{
    private int playerHealth;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage;

    public Thief(String name,  String profession){
        super(name, profession);
        this.playerHealth = 120;
        this.attackDamage = random.nextInt(6) + 20;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }
    public int getAttackDamage() {
        return attackDamage;
    }

    //also has a trait for agility, run away from battle, can be used 3 times to "cancel" a fight
    private int agility = 3;

}
