package week12;

public class LightBoard {
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols){
        lights = new boolean[numRows][numCols];

        for (int i = 0; i < lights.length; i++){
            for (int j = 0; j < lights[i].length; i++){
                lights[i][j] = Math.random() <= 0.4;
            }
        }
    }

    public boolean evaluateLight(int row, int col){
        boolean currLight = lights[row][col];
        int totalOn = 0;
        for (int i = 0; i < lights.length; i++){
                if (lights[i][col]) totalOn++;
            }
        if (currLight && totalOn % 2 == 0) return false;
        else if (!currLight && totalOn % 3 == 0) return true;
        return currLight;
    }
}
