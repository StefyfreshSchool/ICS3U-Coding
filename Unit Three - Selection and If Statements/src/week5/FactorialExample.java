package week5;

public class FactorialExample {
    public static void main(String[] args) {
        

    }

    public static int factorial(int n) {
        if (n == 1) return n;
        if (n > 1) {     
            n *= factorial(n - 1);     
            return n;
        }
        return n;
    }
    
    public static int  fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        else return fibonacci(n - 2) + fibonacci(n - 1);       
    }
}
