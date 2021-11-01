package week7;
import java.util.Scanner;

public class CrazyEights {
    private static Scanner in = new Scanner(System.in);
    //suit constants
    //IMPORTANT NOTE!!! Run this in a terminal that supports UTF-8 characters AND has a UTF-8 font enabled. 
    // Otherwise the game will be unplayable as these will not show up correctly...
    // Also copy-pasting these into input boxes of this game doesn't work unless the terminal passes UTF-8 for its input.
    private static final String HEARTS = "♡";
    private static final String CLUBS = "♧";
    private static final String DIAMONDS = "♢";
    private static final String SPADES = "♤";
    //card constants
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    // Game variables
    // These are here for the sole reason that every call to refreshConsole() would be long
    // if it was necessary to pass these in these every time.
    private static String playerCards = "";
    private static String cpu1Cards = "";
    private static String cpu2Cards = ""; 
    //This is used for console message outputs of cpuPlay methods.
    private static String heldMessage = "";
    public static void main(String[] args) {
        boolean gameOver = false;
        int playerPoints = 0, cpu1Points = 0, cpu2Points = 0;
        startConsole();
        while (!gameOver){
            playRound();
            playerPoints += tallyPoints(1);
            cpu1Points += tallyPoints(2);
            cpu2Points += tallyPoints(3);
            if (playerPoints >= 100 || cpu1Points >= 100 || cpu2Points >= 100) {
                gameOver(playerPoints, cpu1Points, cpu2Points);
                return;
            }
            consolePoints(playerPoints, cpu1Points, cpu2Points);
            in.nextLine();
            consoleDeal();
        }
    }

    private static void gameOver(int playerPoints, int cpu1Points, int cpu2Points) {
        clearConsole();
        System.out.println("\033[1mCRAZY EIGHTS!\n\033[0m");
        System.out.println("\033[3mGame over! " + checkWinner(playerPoints, cpu1Points, cpu2Points) + "\033[0m\n");
        System.out.println("\033[1mPlayer Points: \033[0m" + playerPoints);
        System.out.println("\033[1mCPU 1 Points: \033[0m" + cpu1Points);
        System.out.println("\033[1mCPU 2 Points: \033[0m" + cpu2Points);
        System.out.println();
    }

    private static String checkWinner(int playerPoints, int cpu1Points, int cpu2Points) {
        if (playerPoints < cpu1Points && playerPoints < cpu2Points) return "Player WINS!";
        if (cpu1Points < playerPoints && cpu1Points < cpu2Points) return "CPU 1 WINS!";
        if (cpu2Points < cpu1Points && cpu2Points < playerPoints) return "CPU 2 WINS!";
        if (playerPoints == cpu1Points && playerPoints < cpu2Points) return "TIE between CPU 1 and player!";
        if (playerPoints == cpu2Points && playerPoints < cpu1Points) return "TIE between CPU 2 and player!";
        if (cpu1Points == cpu2Points && playerPoints < cpu2Points) return "TIE between CPU 1 and CPU 2!";
        if (playerPoints == cpu1Points && playerPoints == cpu2Points) return "TIE between all!";
        return "(there is an error with the code, check the point totals yourself)";
    }

    private static int tallyPoints(int i) {
        if (i == 1){
            if (playerCards.length() <= 1) return 0;
            return pointsFromHand(playerCards);
        } else if (i == 2){
            if (cpu1Cards.length() <= 1) return 0;
            return pointsFromHand(cpu1Cards);
        } else if (i == 3){
            if (cpu2Cards.length() <= 1) return 0;
            return pointsFromHand(cpu2Cards);
        }
        return 0;
    }

    private static int pointsFromHand(String hand) {
        int total = 0;
        total += countOccurences("8", hand) * 50;
        total += countOccurences(KING, hand) * 10;
        total += countOccurences(JACK, hand) * 10;
        total += countOccurences(QUEEN, hand) * 10;
        total += countOccurences("10", hand) * 10;
        total += countOccurences(ACE, hand);

        for (int i = 2; i <= 9; i++) {
            if(i != 8) total += countOccurences(i + "", hand);
        }
        return total;
    }

    private static int countOccurences(String card, String hand) {
        int total = 0;
            
        for (int i = 0; i < hand.length() - card.length(); i++) {
            String temp = hand.substring(i, i + card.length());
            if (temp.equals(card)) total++;
        }
        return total;
    }

    private static void playRound() {
        String playPile = "";
        playerCards = "";
        cpu1Cards = "";
        cpu2Cards = "";
        heldMessage = "";
        for (int i = 0; i < 5; i++) {
            //Deals cards in order CPU 1 - CPU 2 - PLAYER (as if CPU 1 is the dealer) and repeats.
            cpu1Cards += getCard();
            cpu2Cards += getCard();
            playerCards += getCard();
        }
        playPile = getPlayPile();
        
        while(playerCards.length() > 1 && cpu1Cards.length() > 1 && cpu2Cards.length() > 1){
            refreshConsole("", playPile, "");
            String temp = "";
            temp = playerPlay(playPile);
            if (temp != "") playPile = temp;
            if (playerCards.length() <= 1) return;
            anim();
            temp = cpu1Play(playPile);
            if (temp != "") playPile = temp;
            if (cpu1Cards.length() <= 1) return;
            anim();
            temp = cpu2Play(playPile);
            if (temp != "") playPile = temp;
        }
    }

    private static String playerPlay(String playPile) {
        String card = "";
        boolean validInput = false;
        String playerMessage = "Choose a card to play or '#' if you can't play: ";
        int drawCardConcurrent = 0;
        while(!validInput){
            refreshConsole(heldMessage, playPile, playerMessage);
            heldMessage = "";
            card = in.nextLine().toUpperCase();

            if (card.equals("#")){
                if (checkCanPlay(playPile)) playerMessage = "You can play! Please enter a card: ";
                else{
                    String temp = drawCard(playPile, drawCardConcurrent);
                    int dash = temp.indexOf("-");
                    if (dash == 0){
                        refreshConsole("Player can't play.", playPile, "");
                        return "";
                    }
                    drawCardConcurrent = Integer.parseInt(temp.substring(dash + 1));
                    card = temp.substring(0, dash);
                
                    playerMessage = "Choose a card to play or '#' if you can't play: ";
                    heldMessage = "Player draws a card.";
                }
            }
            else if (card == "" || card.indexOf(" ") == 0 || card.length() == 1 || card.length() > 3 || card.length() == 0) playerMessage = "Not a valid card! Please enter a card or '#': ";
            else if (card.substring(1, 2).equals(" ") || card.substring(card.length() - 1, card.length()).equals(" ")) playerMessage = "Not a valid card! Please enter a card or '#': ";
            else if (checkValidPlay(card, playPile) == false) playerMessage = "That is not a valid play! Please enter a card or '#': ";
            else {
                card = card.substring(0, card.length() - 1) + parseCard(card);
                if (playerCards.indexOf(card) == -1) playerMessage = "You do not have that card! Please enter a card or '#': ";
                else {
                    validInput = true;
                    playerCards = removeCard(card, playerCards);
                    playPile = card;
                    refreshConsole("Player plays: " + card, playPile, "");
                    card = checkEight(card, playPile);
                    drawCardConcurrent = 0;
                    return card + " ";
                }
            }
        }
        return "";
    }

    private static String cpu1Play(String playPile) {
        heldMessage = "CPU 1 plays: ";
        String suit = playPile.substring(playPile.length() - 2, playPile.length() - 1);
        String rank = playPile.substring(0, playPile.length() - 2);
        String card;
        int drawCardConcurrent = 0;
        while (true){
            int i1 = cpu1Cards.indexOf(suit);
            int i2 = cpu1Cards.indexOf(rank);
            int i3 = cpu1Cards.indexOf("8");
            //RULE 4
            if ((playerCards.length() <= 4 || cpu2Cards.length() <= 4) && i3 >= 0){
                String newSuit = "";
                boolean newSuitCheck = true;
                while (newSuitCheck){
                    newSuit = getSuit();
                    if(!(playPile.indexOf(newSuit) >= 0)) newSuitCheck = false;
                    cpu1Cards = removeCard("8" + cpu1Cards.substring(i3 + 1, i3 + 2), cpu1Cards);
                }
                refreshConsole("CPU 1 plays: 8" + newSuit, playPile, "");
                heldMessage += "8" + newSuit;
                return "8" + newSuit + " ";
            }
            //RULE 1
            if (i1 >= 0){
                if (!cpu1Cards.substring(i1 - 1, i1).equals("8")){
                    if (i1 < 2) card = cpu1Cards.substring(i1 - 1, i1 + 2);
                    else if (!cpu1Cards.substring(i1 - 2, i1 - 1).equals(" ")) card = cpu1Cards.substring(i1 - 2, i1 + 2);
                    else card = cpu1Cards.substring(i1 - 1, i1 + 2);

                    cpu1Cards = removeCard(card, cpu1Cards);
                    refreshConsole("CPU 1 plays: " + card, playPile, "");
                    heldMessage += card;
                    return card;
                }
            }
            //RULE 2
            if (i2 >= 0){
                if (!cpu1Cards.substring(i2, i2 + 1).equals("8")){
                    if (cpu1Cards.substring(i2 + 2, i2 + 3).equals(" ")) card = cpu1Cards.substring(i2, i2 + 3);
                    else card = cpu1Cards.substring(i2, i2 + 4);

                    cpu1Cards = removeCard(card, cpu1Cards);
                    refreshConsole("CPU 1 plays: " + card, playPile, "");
                    heldMessage += card;
                    return card;
                }
            }
            //RULE 3
            if (i3 >= 0){
                card = cpu1Cards.substring(i3, i3 + 3);
                cpu1Cards = removeCard(card, cpu1Cards);
                if (cpu1Cards.indexOf(HEARTS) >= 0) {
                    refreshConsole("CPU 1 plays: " + card, playPile, "");
                    heldMessage += "8" + HEARTS;
                    return "8" + HEARTS + " ";
                }
                if (cpu1Cards.indexOf(CLUBS) >= 0){
                    refreshConsole("CPU 1 plays: " + card, playPile, "");
                    heldMessage += "8" + CLUBS;
                    return "8" + CLUBS + " ";
                }
                if (cpu1Cards.indexOf(DIAMONDS) >= 0){
                    refreshConsole("CPU 1 plays: " + card, playPile, "");
                    heldMessage += "8" + DIAMONDS;
                    return "8" + DIAMONDS + " ";
                }
                if (cpu1Cards.indexOf(SPADES) >= 0) {
                    refreshConsole("CPU 1 plays: " + card, playPile, "");
                    heldMessage += "8" + SPADES;
                    return "8" + SPADES + " ";
                }
            }

            //draw new card
            String temp = cpuDrawCard(playPile, drawCardConcurrent, 1);
            int dash = temp.indexOf("-");
            if (dash == 0){
                refreshConsole("CPU 1 can't play.", playPile, "");
                return "";
            }
            drawCardConcurrent = Integer.parseInt(temp.substring(dash + 1));
            card = temp.substring(0, dash);
        }
    }

    private static String cpu2Play(String playPile) {
        heldMessage = "CPU 2 plays: ";
        String suit = playPile.substring(playPile.length() - 2, playPile.length() - 1);
        String rank = playPile.substring(0, playPile.length() - 2);
        String card;
        int drawCardConcurrent = 0;
        while (true){
            int i1 = cpu2Cards.indexOf(suit);
            int i2 = cpu2Cards.indexOf(rank);
            int i3 = cpu2Cards.indexOf("8");
            //RULE 4
            if ((playerCards.length() <= 4 || cpu2Cards.length() <= 4) && i3 >= 0){
                String newSuit = "";
                boolean newSuitCheck = true;
                while (newSuitCheck){
                    newSuit = getSuit();
                    if(!(playPile.indexOf(newSuit) >= 0)) newSuitCheck = false;
                    cpu2Cards = removeCard("8" + cpu2Cards.substring(i3 + 1, i3 + 2), cpu2Cards);
                }
                refreshConsole("CPU 2 plays: 8" + newSuit, playPile, "");
                heldMessage += "8" + newSuit;
                return "8" + newSuit + " ";
            }
            //RULE 1
            if (i1 >= 0){
                if (!cpu2Cards.substring(i1 - 1, i1).equals("8")){
                    if (i1 < 2) card = cpu2Cards.substring(i1 - 1, i1 + 2);
                    else if (!cpu2Cards.substring(i1 - 2, i1 - 1).equals(" ")) card = cpu2Cards.substring(i1 - 2, i1 + 2);
                    else card = cpu2Cards.substring(i1 - 1, i1 + 2);

                    cpu2Cards = removeCard(card, cpu2Cards);
                    refreshConsole("CPU 2 plays: " + card, playPile, "");
                    heldMessage += card;
                    return card;
                }
            }
            //RULE 2
            if (i2 >= 0){
                if (!cpu2Cards.substring(i2, i2 + 1).equals("8")){
                    if (cpu2Cards.substring(i2 + 2, i2 + 3).equals(" ")) card = cpu2Cards.substring(i2, i2 + 3);
                    else card = cpu2Cards.substring(i2, i2 + 4);

                    cpu2Cards = removeCard(card, cpu2Cards);
                    refreshConsole("CPU 2 plays: " + card, playPile, "");
                    heldMessage += card;
                    return card;
                }
            }
            //RULE 3
            if (i3 >= 0){
                card = cpu2Cards.substring(i3, i3 + 3);
                cpu2Cards = removeCard(card, cpu2Cards);
                if (cpu2Cards.indexOf(HEARTS) >= 0) {
                    refreshConsole("CPU 2 plays: " + card, playPile, "");
                    heldMessage += "8" + HEARTS;
                    return "8" + HEARTS + " ";
                }
                if (cpu2Cards.indexOf(CLUBS) >= 0){
                    refreshConsole("CPU 2 plays: " + card, playPile, "");
                    heldMessage += "8" + CLUBS;
                    return "8" + CLUBS + " ";
                }
                if (cpu2Cards.indexOf(DIAMONDS) >= 0){
                    refreshConsole("CPU 2 plays: " + card, playPile, "");
                    heldMessage += "8" + DIAMONDS;
                    return "8" + DIAMONDS + " ";
                }
                if (cpu2Cards.indexOf(SPADES) >= 0) {
                    refreshConsole("CPU 2 plays: " + card, playPile, "");
                    heldMessage += "8" + SPADES;
                    return "8" + SPADES + " ";
                }
            }

            //draw new card
            String temp = cpuDrawCard(playPile, drawCardConcurrent, 2);
            int dash = temp.indexOf("-");
            if (dash == 0){
                heldMessage = "CPU 2 can't play.";
                return "";
            }
            drawCardConcurrent = Integer.parseInt(temp.substring(dash + 1));
            card = temp.substring(0, dash);
        }
    }

    private static boolean checkCanPlay(String playPile) {
        int card = playerCards.indexOf(playPile.substring(0, playPile.length() - 2));
        int suit = playerCards.indexOf(playPile.substring(playPile.length() - 2, playPile.length() - 1));
        int eight = playerCards.indexOf("8");
        if (card == -1 && suit == -1 && eight == -1) return false;
        return true;
    }

    private static String drawCard(String playPile, int draw) {
        if (draw == 5) return "-";
        draw++;
        refreshConsole("", playPile, "Drawing a card");
        anim();
        String card = getCard();
        playerCards += card;
        return card + "-" + draw;
    }
    private static String cpuDrawCard(String playPile, int draw, int cpu) {
        if (draw == 5) return "-"; 
        String card = getCard();
        if (cpu == 1) cpu1Cards += card;
        else if (cpu == 2) cpu2Cards += card;
        draw++;
        refreshConsole("CPU " + cpu + " draws a card.", playPile, "");
        anim();
        return card + "-" + draw;
    }

    private static String removeCard(String card, String handCards) {
        int i = handCards.indexOf(card);
        int space = handCards.substring(i).indexOf(" ") + i;
        if (i == 0) return handCards.substring(space + 1);
        return handCards.substring(0, i) + handCards.substring(space + 1, handCards.length());
    }

    private static String checkEight(String card, String playPile) {
        if (!card.substring(0,1).equals("8")) return card;
        else{
            String playerMessage = "You played an 8! Please enter a new suit: ";
            String suit = "";
            boolean validInput = false;
            while (!validInput){
                refreshConsole("Player plays: " + card, playPile, playerMessage);
                suit = in.nextLine().toUpperCase();
                suit = parseCard(suit);
                if (suit.length() == 0 || suit.length() > 1) playerMessage = "That is not a valid entry! Please enter a suit: ";
                else if(!suit.equals(HEARTS) && !suit.equals(DIAMONDS) && !suit.equals(CLUBS) && !suit.equals(SPADES)) playerMessage = "That is not a valid suit! Please enter a suit: ";
                else {
                    validInput = true;
                }
            }
            playPile = "8" + suit;
            refreshConsole("New suit: " + suit, playPile, "");
            return playPile;
        }
    }

    private static boolean checkValidPlay(String card, String playPile) {
        card = card.substring(0, card.length() - 1) + parseCard(card);
        if (card.substring(0, 1).equals("8")) return true;
        else if (playPile.substring(0, playPile.length() - 2).equals(card.substring(0, card.length() - 1))) return true;
        else if (playPile.substring(playPile.length() - 2, playPile.length() - 1).equals(card.substring(card.length() - 1, card.length()))) return true;
        return false;
    }

    private static String getPlayPile() {
        String card = getCard();
        if (card.indexOf("8") >= 0) card = getPlayPile();
        return card;
    }

    private static String getCardsHidden(String cards) {
        int n = 0;
        for (int i = 0; i < cards.length(); i++) {
            if (cards.substring(i, i + 1).indexOf(" ") == 0) n++;
        }
        String out = "";
        for (int i = 0; i < n; i++) {
            out += "XX ";
        }
        return out;
    }

    private static String getCard() {
        return getFace() + getSuit() + " ";
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * 4);
        if (suit == 1) return HEARTS;
        else if (suit == 2) return SPADES;
        else if (suit == 3) return CLUBS;
        else return DIAMONDS;
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


    //Below this line are all the methods for the UI of the game.
    private static void clearConsole() {
        try {new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} catch (Exception e) {}
    }

    private static void refreshConsole(String message, String playPile, String playerMessage) {
        clearConsole();
        System.out.println("\033[1mCRAZY EIGHTS!\n\033[0m");
        System.out.println("\033[3m" + message + "\033[0m\n");
        System.out.println("\033[1mCPU 1: \033[0m" + getCardsHidden(cpu1Cards));
        System.out.println("\033[1mCPU 2: \033[0m" + getCardsHidden(cpu2Cards));
        System.out.println();
        System.out.println("\033[1mPlay Pile: \033[0m" + playPile);
        System.out.println();
        System.out.println("\033[1mYour cards: \033[0m" + playerCards);
        System.out.print("\033[3m" + playerMessage + "\033[0m");
        // Searching online revealed that the control character \033[3m creates italic text, \033[1m creates bold text and \033[0m resets it.
    }

    /**
     * Parses a card from {@code H, S, D, C}  to {@code ♡, ♤, ♢, ♧}
     * @param card
     * @return parsed card
     */
    private static String parseCard(String card) {
        if (card.indexOf("H") >= 0) return HEARTS;
        if (card.indexOf("S") >= 0) return SPADES;
        if (card.indexOf("D") >= 0) return DIAMONDS;
        if (card.indexOf("C") >= 0) return CLUBS;
        return card;
    }

    private static void consolePoints(int playerPoints, int cpu1Points, int cpu2Points) {
        clearConsole();
        System.out.println("\033[1mCRAZY EIGHTS!\n\033[0m");
        System.out.println("\033[3mRound over!\033[0m\n");
        System.out.println("\033[1mPlayer Points: \033[0m" + playerPoints);
        System.out.println("\033[1mCPU 1 Points: \033[0m" + cpu1Points);
        System.out.println("\033[1mCPU 2 Points: \033[0m" + cpu2Points);
        System.out.println();
        System.out.print("Press enter to continue...");
    }

    private static void startConsole() {
        clearConsole();
        System.out.println("\033[1mWELCOME TO CRAZY EIGHTS!\n\033[0m");
        anim();
        clearConsole();
        System.out.println("\033[1mWELCOME TO CRAZY EIGHTS!\n\033[0m");
        System.out.println("\033[3mHow to play:\033[0m\n");
        System.out.println("If you have a card of the same rank or suit as the card in play, you can play it.");
        System.out.println("If you have an eight, it is wild and you will need to choose a new suit.\n");
        System.out.println("When entering cards, your entries will be formatted.");
        System.out.println("H becomes ♡, S becomes ♤, D becomes ♢, and C becomes ♧.\n");
        System.out.print("Press enter to continue...");
        in.nextLine();
        clearConsole();
        System.out.println("\033[1mCRAZY EIGHTS!\n\033[0m");
        consoleDeal();
    }

    private static void consoleDeal() {
        clearConsole();
        System.out.println("\033[1mCRAZY EIGHTS!\n\033[0m");
        System.out.print("\033[3mDealing cards\033[0m");
        anim();
    }

    private static void sleep(int i) {
        try {Thread.sleep(i);} catch (InterruptedException e){}
    }

    private static void anim() {
        System.out.print(".");
        sleep(300);
        System.out.print(".");
        sleep(300);
        System.out.print(".");
        sleep(400);
    }
}