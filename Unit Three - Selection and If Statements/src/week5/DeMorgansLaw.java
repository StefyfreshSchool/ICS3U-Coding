package week5;

public class DeMorgansLaw {
    public static void main(String[] args) {
        int x = 7;
        boolean result = (x < 3) && (x > 10);
        System.out.println(result);

        boolean result2 = (x < 3) && (x > 10);
        System.out.println(!result2);

        // !(A && B) == !A || !B

        boolean result3 = !(x < 3) || !(x > 10);
        System.out.println(result3);

        boolean result4 = x >= 3 || x <= 10;
        System.out.println(result4);
    }
    
}
