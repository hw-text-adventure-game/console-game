package textAdvGame;

import textAdvGame.Characters.Character;
import textAdvGame.Enemies.Enemy;
import textAdvGame.Enemies.StoneGolem;

import java.util.ArrayList;

public class Castle {

    public static void enterCastleGarden(Character myCharacter, ArrayList<String> characterInventory) {

        boolean alive = true;

        while (alive) {

        Character userCharacter = myCharacter;
        ArrayList<String> inventory = characterInventory;

        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("After escaping the caves, you find a long, stone staircase leading out of the trench and straight.\n" +
                "to the witch's castle. You climb up the long staircase, arriving at the castle gardens, which are lavish and " +
                "bright. You spot a stone with glowing blue words, similar to the one you found when you exited the maze:\n" +

                "\n" +

                "\"If you can't face the witch yet it's what you crave, perhaps your answer is back in the dark caves.\n" +
                "If your searches are fruitless, remember you're not alone, call for help by calling for the Wayward Stone.\"\n" +

                "\n" +

                "After reading the message on the stone you approach the castle gardens, however a STONE GOLEM is guarding the entrance!\n" +
                "To get to the door of the castle, you decide to fight the monster!");
        System.out.println("------------------------------------------------------------------------------------------------------------\n");

        Enemy firstEnemy;
        firstEnemy = new StoneGolem("STONE GOLEM"); //Change to maze guardian or boulder monster

        System.out.println("***** A " + firstEnemy.getName() + " appears! *****");
        System.out.println(firstEnemy.monsterInfo());
        System.out.println(firstEnemy.traitMessage());

        userCharacter.attackMenu(firstEnemy, inventory);
        if (userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
            alive = false;
            gameOver();
            break;
        }


        //Put password area here later



    }

 }






    public static void gameOver () {
        System.out.println("GAME OVER!");
        GameApplication.beginGame();
    }

    public static void youWin () {
        System.out.println("YOU WIN!");
        GameApplication.beginGame();
    }


}
