package textAdvGame;

import java.util.Random;

public class WitchHunter extends Character{
    private int playerHealth;
    Random random = new Random();
    //attack bw 20 & 25
    private int attackDamage;

    public WitchHunter(String name,  String profession){
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

    //witch hunter has a trait for adaptability, 25% chance to dodge an attack/cancel out the enemy attack
    //if(random.nextInt(100) < dodgeChance{ add back whatever health amount was deducted}
    private int dodgeChance = 25;


}

