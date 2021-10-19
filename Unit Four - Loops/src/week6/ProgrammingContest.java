package week6;

public class ProgrammingContest {
    public static void main(String[] args) {
        framingSquares(3,4,1,2);
        System.out.println();
        diamonds("BAYVIEWGLEN");
        System.out.println();
        wordFrame("CANADA");
        
        
    }

    private static void wordFrame(String str) {
        System.out.println("*" + str + "*");
        for (int i = 0; i < str.length(); i++) {
            int iB = str.length() - i;
            System.out.print(str.substring(iB - 1, iB));
            for (int j = 0; j < str.length(); j++) {
                System.out.print("*");
            }
            System.out.print(str.substring(i, i + 1));
            System.out.println();
        }
        System.out.print("*");
        for (int i = 0; i < str.length(); i++) {
            int iB = str.length() - i;
            System.out.print(str.substring(iB - 1, iB));
        }
        System.out.print("*");
    }

    private static void diamonds(String str) {
        // forward
        for (int m = 0; m < str.length() - 1; m++) {
            System.out.print(" ");
        }
        System.out.println(str.substring(0,1));
        for (int i = 1; i < str.length(); i++) {
            String c = str.substring(i, i + 1);
            for (int j = 0; j < str.length() - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            System.out.println();
        }
        // backward
        for (int i = 1; i < str.length() - 1; i++) {
            int iB = str.length() - i;
            String c = str.substring(iB - 1, iB);
            for (int j = 0; j < str.length() - iB; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            for (int j = 0; j < 2 * iB - 3; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            System.out.println();
        }
        for (int m = 0; m < str.length() - 1; m++) {
            System.out.print(" ");
        }
        System.out.println(str.substring(0,1));
    }

    private static void framingSquares(int M, int N, int P, int Q) {
        int w = N + 2 * P + 2 * Q;
        for(int i = 0; i < Q; i++){
            for (int j = 0; j < w; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < P; i++){
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < 2 * P + N; j++) {
                System.out.print("+");
            }
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < M; i++){
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < P; j++) {
                System.out.print("+");
            }
            for (int j = 0; j < N; j++) {
                System.out.print(".");
            }
            for (int j = 0; j < P; j++) {
                System.out.print("+");
            }
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < P; i++){
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < 2 * P + N; j++) {
                System.out.print("+");
            }
            for (int j = 0; j < Q; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < Q; i++){
            for (int j = 0; j < w; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
    
}
