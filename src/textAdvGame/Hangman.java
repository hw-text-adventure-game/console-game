package textAdvGame;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    //default constructor, not sure if we need this constructor.
    public Hangman() {
    }

    public static void hangmanGame() {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String[] wordArr = {"class", "programming", "instance", "static", "method", "constructor", "byte", "double", "boolean", "float", "scanner"}; //You can change these words to whatever you want to fit in with the theme of the game

        boolean weArePlaying = true;

        while (weArePlaying) {
            System.out.println("Welcome to my game of textAdvGame.Hangman. Guess correctly and I'll let you pass.");  //You can add instructions or story here
            char[] randomWordToGuess = wordArr[rand.nextInt(wordArr.length)].toCharArray();
            int numberOfUnderscores = randomWordToGuess.length;   //this sets the number of underscores to the length of the word
            char[] playerGuess = new char[numberOfUnderscores];  //this creates an empty char array where we can save the users input

            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';        //use single quotes for char
            }

            boolean wordIsGuessed = false;    //set it to false, bc at the beginning the word has not been guess yet
            int tries = 2 * randomWordToGuess.length;  //this gives the player a certain number of tries, right now it's 2 times the length of the word

            while (!wordIsGuessed && tries > 0) {
                System.out.print("Current word: ");
                printArray(playerGuess);        //printArray method is below
                System.out.printf("You have %d left.\n", tries);

                System.out.println("Enter a single character");
                char input = scanner.nextLine().charAt(0);    //if the user enters alfjaeflkj it will only get the first char
                tries--;

                if (input == '-') {
                    weArePlaying = false;    //if the player enters a minus sign, or dash, we'll end the game
                    wordIsGuessed = true;
                } else {
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }
                    if (isTheWordGuessed(playerGuess)) {      //create your method below
                        wordIsGuessed = true;
                        System.out.println(playerGuess);
                        System.out.println("Congratulations, you won!");
                    }
                }
            }
            if (!wordIsGuessed) System.out.println("You ran out of guesses :/");
            System.out.println("Do you want to play again? (yes/no)");   //Instead of giving them the option to play again, we could kick them back into the maze or make them fight, or whatever you want to do
            String anotherGame = scanner.nextLine();
            if (anotherGame.equals("no") || anotherGame.equals("n")) weArePlaying = false;
        }
        System.out.println("Goodbye");
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static boolean isTheWordGuessed(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') return false;
        }
        return true;      //if there are no underscores, that means the word has been guessed
    }

    //You should be able to call Hangman.hangmanGame(); to use it in the game


}


//basic hangman console game. Adapated from a tutorial from Rok Novosel https://www.youtube.com/watch?v=VvKGhCaxHSg