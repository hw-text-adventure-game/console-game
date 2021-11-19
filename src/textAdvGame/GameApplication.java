package textAdvGame;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.Goblin;


public class GameApplication {


    public static void beginGame(){
        boolean alive = true;
        while(alive) { //While character is alive, continue story
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("\"You wake up in the Enchanted Forest, unsure of how you got there. The forest you are in has been\n" +
                "known for it's strange properties; all adventurers who enter the forest never return as the same\n" +
                "person...or even return at all. As you rub the sleep out of your eyes, you begin to remember who you" +
                " are.");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        Character userCharacter = Character.chooseCharacter();

        System.out.println(userCharacter.getName());

        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("\"After you remember your name and your past, you get up and begin to search The Enchanted Forest,\n" +
                "but suddenly you hear a noise from behind you!\"");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        Enemy firstEnemy;
        firstEnemy = new Goblin("GOBLIN");
        Enemy secondEnemy = new Goblin("GOBLIN");
        Enemy thirdEnemy = new Goblin("GOBLIN");
        Enemy fourthEnemy = new Goblin("GOBLIN");

        System.out.println("***** A " + firstEnemy.getName() + " appears! *****");

        userCharacter.attackMenu(firstEnemy);
        userCharacter.attackMenu(secondEnemy);
        userCharacter.attackMenu(thirdEnemy);
        userCharacter.attackMenu(fourthEnemy);


            //check if character is dead after every fight

        if(userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
            alive = false;
            gameOver();
            break;
        }

        }

        //Tried to create maze methods in separate class, but the game needs access to Character userCharacter
        //to work. I tried a bunch of things, but it wouldn't work no matter what I did. Worse case scenario,
        //we move the maze methods into the game application unless we can find another way.

    }

public static void gameOver() {
        System.out.println("GAME OVER!");
}

    public static void youWin() {
        System.out.println("YOU WIN!");
    }



    public static void main(String[] args) {
        beginGame();

    }
}
