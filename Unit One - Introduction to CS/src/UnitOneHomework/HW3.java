package UnitOneHomework;

public class HW3 {
    public static void main(String[] args) {
        int number = 54321; // five digits
        int output = (number % 100 / 10) * (number % 10000 / 1000);
        System.out.println("The product of the second and fourth digits is: " + output);
    }

}
