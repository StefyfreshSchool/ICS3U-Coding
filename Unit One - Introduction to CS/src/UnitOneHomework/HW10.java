package UnitOneHomework;

public class HW10 {
    public static void main(String[] args) {
        double a = 1.2;
        double b = 5;
        double c = -26;
        double x1;
        double x2;
        x1 = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
        x2 = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
        System.out.println("The two roots of the equation are " + x1 + " and " + x2 + ".");
    }

}
