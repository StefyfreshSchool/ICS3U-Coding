package week7;

import java.util.Scanner;

import static java.lang.Math.*;

public class ThreeCardPoker {
    private static final String HEARTS = "H";
    private static final String CLUBS = "C";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int MAX_CARDS = 3;
    private static final int PLAYER_WINS = 1;
    private static final int DEALER_WINS = 2;

    private static final int HIGH_CARD = 1;
    private static final int PAIR = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int STRAIGHT = 4;
    private static final int FLUSH = 5;
    private static final int STRAIGHT_FLUSH = 6;
    private static final int TIE = 3;
    public static void main(String[] args) {
        // 7H -> 7 hearts
        // AD -> ace of diamonds
        // KC -> king of clubs

        // playerHand -> "7H AD KC"
        // dealerHand -> "XX XX XX"
        clearConsole();
        Scanner in = new Scanner(System.in);
        int wallet = 500;
        final int MIN_BET = 50;
        final int MAX_BET = 100;

        boolean playAgain = true;
        while (playAgain){
            wallet = playPokerHand(in, wallet, MIN_BET, MAX_BET);
            if (wallet >= MAX_BET * 2) playAgain(in);
            else{
                System.out.println("You don't have enough money to play again!");
                playAgain = false;
            }
        }
        
    }
    
    
    private static boolean fold(Scanner in) {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Do you want to play again? ([F]old / [D]iscard)");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("FOLD") || answer.equals("D")) {
                return true;
            }else if (answer.equals("DISCARD") || answer.equals("D")) {
                return false;
            } else {
                System.out.println("Invalid input: F or D only!");
            }
        }
        return false;
    }


    private static int playPokerHand(Scanner in, int wallet, int min, int max) {
        int bet = getBet(in, wallet, min, max);

        String playerHand = "";
        String dealerHand = "";

        for (int i = 0; i < MAX_CARDS; i++) {
            playerHand += getCard(playerHand);
        }

        for (int i = 0; i < MAX_CARDS; i++) {
            dealerHand += getCard(playerHand + dealerHand);
        }
        System.out.println("Player: " + playerHand);
        System.out.println("Dealer: XX XX XX");
        if ( !fold(in) ){
            bet = getBet(in, wallet, min, max);
            playerHand = DiscardMethod.discard(in, playerHand);
            System.out.println(playerHand);
        } else {
            System.out.println("Player folds.");
            wallet -= bet;
            return wallet;
        }

        if (compareHands(playerHand, dealerHand) == PLAYER_WINS){
            System.out.println("Player wins!");
            wallet += bet;
        } else if (compareHands(playerHand, dealerHand) == DEALER_WINS){
            System.out.println("Dealer wins!");
            wallet -= bet;
        } else {
            System.out.println("Tie.");
        }
        return wallet;
    }


    private static int compareHands(String playerHand, String dealerHand) {
        if (getHand(playerHand) > getHand(dealerHand)) return PLAYER_WINS;
        else if (getHand(dealerHand) > getHand(playerHand)) return DEALER_WINS;
        else{
            if (getHighCard(playerHand) > getHighCard(dealerHand)) return PLAYER_WINS;
            else if (getHighCard(dealerHand) > getHighCard(playerHand)) return DEALER_WINS;
            else return TIE;

        }
    }


    private static int getHighCard(String cards) {
        if (cards.indexOf(ACE) >= 0) return 14;
        if (cards.indexOf(KING) >= 0) return 13;
        if (cards.indexOf(QUEEN) >= 0) return 12;
        if (cards.indexOf(JACK) >= 0) return 11;
        return 0;
    }


    private static int getHand(String cards) {
        if (isFlush(cards) && isStraight(cards)) return STRAIGHT_FLUSH;
        if (isFlush(cards)) return FLUSH;
        if (isStraight(cards)) return STRAIGHT;
        if (isThreeOfAKind(cards)) return THREE_OF_A_KIND;
        if (isPair(cards)) return PAIR;
        return HIGH_CARD;
    }


    private static boolean isPair(String cards) {
        int s1 = cards.indexOf(" "), s2 = cards.substring(s1 + 1).indexOf(" ") + s1 + 1;
        if (cards.substring(0, s1 - 1).equals(cards.substring(s1 + 1, s2 - 1))) return true;
        if (cards.substring(s1 + 1, s2 - 1).equals(cards.substring(s2 + 1, cards.length() - 2))) return true;
        if (cards.substring(0, s1 - 1).equals(cards.substring(s2 + 1, cards.length() - 2))) return true;
        return false;
    }


    private static boolean isThreeOfAKind(String cards) {
        int s1 = cards.indexOf(" "), s2 = cards.substring(s1 + 1).indexOf(" ") + s1 + 1;
        if (cards.substring(0, s1 - 1).equals(cards.substring(s1 + 1, s2 - 1)) && cards.substring(0, s1 - 1).equals(cards.substring(s2 + 1, cards.length() - 2))) return true;
        return false;
    }


    private static boolean isStraight(String cards) {
        int s1 = cards.indexOf(" "), s2 = cards.substring(s1 + 1).indexOf(" ") + s1 + 1;
        int i1 = 0,i2 = 0,i3 = 0;
        try {i1 = Integer.parseInt(cards.substring(0, s1 - 1));} catch (Exception e) {i1 = faceNum(cards.substring(0, s1 - 1), cards);}
        try {i2 = Integer.parseInt(cards.substring(s1 + 1, s2 - 1));} catch (Exception e) {i2 = faceNum(cards.substring(s1 + 1, s2 - 1), cards);}
        try {i3 = Integer.parseInt(cards.substring(s2 + 1, cards.length() - 2));} catch (Exception e) {i3 = faceNum(cards.substring(s2 + 1, cards.length() - 2), cards);}
        
        if (abs(i1-i2) + abs(i1-i3) + abs(i2-i3) == 4) return true;
        return false;
    }


    private static int faceNum(String str, String cards) {
        if (str.equals(JACK)) return 11;
        if (str.equals(QUEEN)) return 12;
        if (str.equals(KING)) return 13;
        if (str.equals(ACE) && cards.indexOf("2") > -1 && cards.indexOf("3") > -1) return 1;
        return 14;
    }


    private static boolean isFlush(String cards) {
        int s1 = cards.indexOf(" "), s2 = cards.substring(s1 + 1).indexOf(" ") + s1 + 1;
        if (cards.substring(s1 - 1,s1).equals(cards.substring(s2 - 1, s2)) && cards.substring(s1 - 1, s1).equals(cards.substring(cards.length() - 2, cards.length() - 1))) return true;
        return false;
    }


    private static String discard(Scanner in, String playerHand) {
        int replace = getNumber(in, "How many cards do you want to replace? ", 0, 3);
        //prompt with cards to replace ( 2 should be like 3H 7D and 1 would be like AD)
        

        return null;
    }

    private static int getNumber(Scanner in, String prompt, int min, int max) {
        boolean validInput = false;
        int out = 0;
        while(!validInput){
            System.out.print(prompt + "[" + min + " - " + max + "]");
            try {
                out = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println(out + " is not a valid number.");
            }
            
            if (out > max || out < min) System.out.println(out + " is not between " + min + " and " + max + ".");
        }
        return out;
    }

    private static String getCard(String cardsUsed) {
        String card = getFace() + getSuit();
        if (cardsUsed.indexOf(card) > -1) getCard(cardsUsed);
        
        return card + " ";
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * 4);
        if (suit == 1) {
            return HEARTS;
        } else if (suit == 1){
            return SPADES;
        }else if (suit == 2){
            return CLUBS;
        }else {
            return DIAMONDS;
        }
    }

    private static String getFace() {
        int face = (int) (Math.random() * 13) + 1;
        if (face > 1 && face <= 10) return "" + face;
        if (face == 1) return ACE;
        if (face == 11) return JACK;
        if (face == 12) return QUEEN;
        if (face == 13) return KING;
        return "";
    }

    private static int getBet(Scanner in, int wallet, int min, int max) {
        boolean validInput = false;
        int bet = 0;

        while (!validInput){
            System.out.print("Please enter a wager: [" + min + " - " + max + "]: ");
            try {
                bet = Integer.parseInt(in.nextLine());

                if (bet > wallet) System.out.println("You do not have enough money to make this bet. You only have $" + wallet + ".");
                else if (bet < min || bet > max) System.out.println("You must make a bet between " + min + " - " + max + ".");
                else validInput = true;  
            } catch (Exception ex) {
                System.out.println("Invalid bet.");
            }

        }
        return bet;
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
    
}
