package week16;

public class Arrays2D {
    public static void main(String[] args) {
        int[][] arr2d = new int[4][3];
        int count = 1;

        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = count++;
            }
        }
    }
}
