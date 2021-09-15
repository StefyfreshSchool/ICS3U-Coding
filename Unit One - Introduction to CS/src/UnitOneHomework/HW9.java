package UnitOneHomework;

public class HW9 {
    public static void main(String[] args) {
        int pennies = 1;
        int nickels = 2;
        int dimes = 1;
        int quarters = 5;
        int loonies = 1;
        int toonies = 6;
        double total; //in cents
        total = pennies + nickels * 5 + dimes * 10 + quarters * 25 + loonies * 100 + toonies * 200;
        System.out.println("The user has $" + total/100.0 + ".");
    }
    
}
