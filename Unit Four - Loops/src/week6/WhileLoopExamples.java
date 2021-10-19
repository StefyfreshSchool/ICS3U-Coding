package week6;

import java.util.Scanner;

public class WhileLoopExamples {
    public static void main(String[] args) {
        exampleOne();
        int numVowels = countVowels("This is a sentence with VOWELS!");
        int sum = getSumInclusive(1,9);
        System.out.println(sum);
        System.out.println(numVowels);

        Scanner in = new Scanner(System.in);
        int num = getValidInput(10,20);
    }

    private static int getValidInput(int i, int j) {
        return 0;
    }

    private static int getSumInclusive(int start, int end) {
        int count = start;
        int sum = 0;
        while (count <= end){
            sum += count;
            count++;
        }
        return sum;
    }

    private static int countVowels(String str) {
        int i = 0;
        int numVowels = 0;
        String vowels = "AEIOUaeiou";
        while (i < str.length()){
            String nextChar = str.substring(i, i + 1);
            if (vowels.indexOf(nextChar) >= 0){
                numVowels++;
            }
            i++;
        }
        return 0;
    }

    private static void exampleOne() {
        // sum numbers from one to 100 and display to screen
        int count = 1;
        int sum = 0;
        while (count <= 100){
            sum += count;
            count++;
        }
        System.out.println(sum);
    }

    public int countHi(String str) {
        int i = 0;
        int n = 0;
        while (i < str.length()-2){
            if (str.substring(i,i+2).equals("hi")) n++;
            i++;
        }
        return n;
    }
    
    
}
