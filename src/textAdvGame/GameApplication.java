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

        System.out.println("***** A " + firstEnemy.getName() + " appears! *****");

        userCharacter.attackMenu(firstEnemy);



            //check if character is dead after every fight

        if(userCharacter.getStatus() == false) { //if getStatus is false (not alive), end game. Otherwise, continue.
            alive = false;
            gameOver();
            break;
        } else {
            youWin();
            break;
        }

//        System.out.println("A test.");
        }


        //Right now it will loop if you're alive, but once we add more story this problem will go away. Once
        // character wins game, we can call a youWin(); method and break out of game

        //Went ahead and added youWin method to demonstrate this.
    }

public static void gameOver() {
        System.out.println("GAME OVER!");
}

    public static void youWin() {
        System.out.println("YOU WIN!");
    }

    //how would we play the game? after the user selects their character, enters their name etc

    //Rhi Response: Java does everything in order, so if you look at line 15-16 that I added, that part will ONLY activate
    // after the character selection and that's how the rest of the game goes on.
    //Right under those new lines you can create a fightGoblin method that will let the user fight an enemy and so on.


    //then we would have to instantiate whatever character they pick. Each character needs their own method like the console game, since they
    //will have different options...

    //Rhi Response: Merged chooseCharacter and enterName together. Properly returns usercharacter and userinput now.
    //All info is in one easy to grab spot! Also made instantiation methods on lines 104-120. Changes on all
    //class files made as well to accommodate.


    public static void main(String[] args) {
        beginGame();

    }
}
