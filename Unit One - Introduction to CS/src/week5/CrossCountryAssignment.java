package week5;

import java.util.Scanner;

public class CrossCountryAssignment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("RUNNER 1");
        processRunner(in);
        System.out.println("RUNNER 2");
        processRunner(in);
        System.out.println("RUNNER 3");
        processRunner(in);
    }

    /**
     * Runs the calculations and asks the user for input.
     * 
     * @param in - The input scanner
     */
    private static void processRunner(Scanner in) {
        String name;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        System.out.print("Enter your first and last name: ");
        name = in.nextLine();
        System.out.print("Enter the first mile time: ");
        mileOne = in.nextLine();
        System.out.print("Enter the second mile time: ");
        mileTwo = in.nextLine();
        System.out.print("Enter the total time: ");
        finish = in.nextLine();

        splitTwo = minusStr(mileTwo, mileOne);
        splitThree = minusStr(finish, mileTwo);

        displayInfo(name, mileOne, splitTwo, splitThree, finish);
    }

    /**
     * Displays the information passed in to the screen.
     * 
     * @param name       - Runner name
     * @param mileOne    - Mile one (split one) time
     * @param splitTwo   - Split two time
     * @param splitThree - Split three time
     * @param finish     - Total time
     */
    private static void displayInfo(String name, String mileOne, String splitTwo, String splitThree, String finish) {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("First split time: " + mileOne);
        System.out.println("Second split time: " + splitTwo);
        System.out.println("Third split time: " + splitThree);
        System.out.println("Total time: " + finish);
        System.out.println("----------");
    }

    /**
     * Subtracts two times.
     * 
     * @param s1 - First time to subtract
     * @param s2 - Second time to subtract.
     * @return The subtracted time {@code (s1 - s2)}
     */
    public static String minusStr(String s1, String s2) {
        return toStr(toSec(s1) - toSec(s2));
    }

    /**
     * Convert a time to seconds and miliseconds.
     * 
     * @param str - Formatted input time
     * @return Time converted to seconds
     */
    public static double toSec(String str) {
        int i = str.indexOf(":");
        int min = Integer.parseInt(str.substring(0, i)) * 60;
        double sec = Double.parseDouble(str.substring(i + 1));
        return sec + min;
    }

    /**
     * Converts seconds to a formatted time in format {@code MIN:SEC.MILISEC}
     * 
     * @param sec - Input time in seconds
     * @return Formatted time
     */
    public static String toStr(double sec) {
        /** PLEASE READ
         * String.format() uses the same syntax as out.printf() so I used it!
         * Please let me know if it was not OK to use it.
         * 
         * My original code was: 
         * return (int) (sec / 60) + ":" + sec % 60;
         */

        return String.format("%d:%06.3f", (int) (sec / 60), sec % 60);
    }
}