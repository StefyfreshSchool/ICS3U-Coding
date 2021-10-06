package week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        //exampleOne();
        exampleTwo(87);
        exampleTwo(77);
        exampleThree();
    }

    private static void exampleThree() {
        // OR =>  || (x > 7 || y > 7)
        // AND => && (X > 7 && y > 7)
        // DON'T use == with strings 
        /**
        >
        <
        >=
        <=
        ==
        !=
        !()  NOT EQUALS
         */
    }

    private static void exampleTwo(int mark) {
        // DO NOT FORGET to have "else if"!
        if (mark >= 90){
            System.out.println("A+");
        } else if (mark >= 80){
            System.out.println("A");
        }else if (mark >= 70){
            System.out.println("B");
        }else if (mark >= 60){
            System.out.println("C");
        }else if (mark >= 80){
            System.out.println("D");
        }else{
            System.out.println("F.");
        }
    }

    private static void exampleOne() {
        /**
         * If (boolean expression is true){ //do this }
         */
        int x = 7;
        if (x % 2 == 0) {
            System.out.println(x + " is even!");
        } else {
            System.out.println(x + " is odd!");
        }
    }

    
}
