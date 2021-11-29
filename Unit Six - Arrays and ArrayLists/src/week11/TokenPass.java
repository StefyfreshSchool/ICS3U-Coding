package week11;

public class TokenPass {
    private int[] tokens;
    private int currentPlayer;

    public TokenPass(int playerCount){
        if (playerCount <= 0) throw new IllegalStateException("Player count must be positive and above zero!");
        tokens = new int[playerCount];
        currentPlayer = (int)(Math.random() * currentPlayer + 1);

        for (int i = 0; i < playerCount; i++){
            tokens[i] = (int)(Math.random() * 10 + 1);
        }
    }
    
    public void distributeCurrentPlayerTokens(){
        int leftTokens = tokens[currentPlayer];
        int player = currentPlayer;

        while (leftTokens > 0){
            player++;
            if (player >= tokens.length) player = 0;
            tokens[player]++;
            leftTokens--;
        }
    }
}
