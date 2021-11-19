package textAdvGame.Characters;

import textAdvGame.Characters.Character;

import java.util.Random;

public class Cleric extends Character {
    private int playerHealth;
    Random random = new Random();
    //attack bw 15 & 20
    private int attackDamage;

    public Cleric(String name,  String profession){
        super(name, profession);
        this.attackDamage = random.nextInt(6) + 15;
        this.playerHealth = 100;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    //cleric also has a trait to heal himself 5-15 random range
    //when the player/cleric wants to heal himself, call this method.
    public void healSelf(){
        Random random = new Random();
        int healAmnt = random.nextInt(11) + 5;  //this generates a random number between 5 and 15. (a number from 0-10, then shifted +5 to get 5 to 15)
        playerHealth = playerHealth + healAmnt;
    }

    //for Cleric, enemy attack is negated, whatever damage the enemy would've done get's added back to the players health
}
