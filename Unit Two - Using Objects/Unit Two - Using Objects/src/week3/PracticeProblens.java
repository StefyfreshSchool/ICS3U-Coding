package week3;

public class PracticeProblens {
    public static void main(String[] args) {
        questionA();
        question5();
    }

    public static void questionA(){
        int num = (int) (Math.random() * 100);
        System.out.println(num);
    }
    
    public static void question5(){
        System.out.println((int) ((100 / (110 + 44.0)) * 1000) / 1000.0);
    }
}
