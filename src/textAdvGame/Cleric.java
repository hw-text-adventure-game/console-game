package textAdvGame;

import java.util.Random;

public class Cleric extends Character{
    private int playerHealth = 100;
    Random random = new Random();
    //attack bw 15 & 20
    private int attackDamage = random.nextInt(6) + 15;

    public Cleric(String name){
        super(name);
    }


    //cleric also has a trait to heal himself 5-15 random range
    //when the player/cleric wants to heal himself, call this method.
    public void healSelf(){
        Random random = new Random();
        int healAmnt = random.nextInt(11) + 5;  //this generates a random number between 5 and 15. (a number from 0-10, then shifted +5 to get 5 to 15)
        playerHealth = playerHealth + healAmnt;
    }
}