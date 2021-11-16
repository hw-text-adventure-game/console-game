package textAdvGame.Characters;

import textAdvGame.Characters.Character;

import java.util.Random;

public class Mage extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 15 & 20
    private int attackDamage;

    public Mage(String name,  String profession){
        super(name, profession);
        this.playerHealth = 100;
        this.attackDamage = random.nextInt(6) + 15;
    }
    //not sure if this needs to be in the constructor, or in the game, probably in the game
    //if(random.nextInt(100) < secondAttackChance{ do the attackmethod again}
    private int secondAttackChance = 25;

    //mage also has a trait for perseverance, 25% chance to do a second attack
    //(give the player an extra turn)

    public int getPlayerHealth() {
        return playerHealth;
    }
    public int getAttackDamage() {
        return attackDamage;
    }
}
