package week7;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain){
            play("READY TO USE SURFACE CLEANER", in);
            playAgain = playAgain(in);
        }
    }

    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Do you want to play again? ([Y]es / [N]o)");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("YES") || answer.equals("Y")) {
                return true;
            }else if (answer.equals("NO") || answer.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input: Y or N only!");
            }
        }
        return false;
    }

    /**
     
        O
      --|--
        |
       / \
      
      
     7 pieces
     */


    private static void play(String hint, Scanner in) {
        String lettersUsed = "";
        int numPieces = 0;
        boolean gameOver = false;
        String availableLetters = " A B C D E F G J H I J K L M N O P Q R S T U V W X Y Z";

        while (!gameOver){
            String encryptedHint = encryptHint(hint, lettersUsed);
            System.out.println(encryptedHint);
            String letter = getLetter(in, availableLetters);
            lettersUsed += letter;

            availableLetters = availableLetters.replace(letter, "_");
            if (hint.indexOf(letter) < 0) {
                numPieces++;
            }
            drawHangman(numPieces);

            if (numPieces == 7) {
                System.out.println("You LOSE!");
                gameOver = true;
            } else if (encryptHint(hint, lettersUsed).indexOf("_") < 0){
                System.out.println("You WIN!!");
                gameOver = true;
            }
            clearScreen();
        }
    }

    private static String getLetter(Scanner in, String availableLetters) {
        System.out.println("Available Letters:\n" + availableLetters);
        boolean validInput = false;
        String letter = "";
        while (!validInput) {
            System.out.print("Please choose a letter: ");
            letter = in.nextLine().toUpperCase();  
            
            if (letter.length() == 1 && availableLetters.indexOf(letter) >= 0) {
                validInput = true;
            } else{
                System.out.println("Invalid choice. Single letters only.");
                System.out.println("Available Leters:\n" + availableLetters);
            } 
        }
        return letter;
    }

    private static String encryptHint(String hint, String lettersUsed) {
        String out = "";

        for (int i = 0; i < hint.length(); i++) {
            String s = hint.substring(i, i + 1);
            if (s.equals(" ")) out += "/ ";
            if (lettersUsed.indexOf(s) >= 0) out += s + " ";
            else out += "_ ";
        }
        return out;
    }

    private static void drawHangman(int numPieces) {
        if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   |");
            System.out.println("|  / \\");
        } else if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   |");
            System.out.println("|  /");
        } else if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
            System.out.println("|   |");
        } else if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|--");
        } else if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("| --|");
        } else if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
            System.out.println("|   |");
        } else if (numPieces == 7){
            System.out.println("_____");
            System.out.println("|   |");
            System.out.println("|   O");
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
