package week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(removeChars("happy", 1, 3));
    }

    /**
     * 
     * Prints 3 copies of a substring in str starting at index
     */
    public static String twoChar(String str, int index) {
        String output = str.substring(index, index + 2);
        return output + output + output;
    }

    public static String removeChars(String str, int index, int n) {
        String s1 = str.substring(0, index);
        String s2 = str.substring(index + n, str.length());
        return s1 + s2;
    }

    public static double sqrtSum(int number) {
        int n1 = number % 10;
        int n2 = number / 10 % 10;
        int n3 = number / 100 % 10;
        int n4 = number / 1000;
        return Math.sqrt(n1 + n2 + n3 + n4);
    }

    
}
