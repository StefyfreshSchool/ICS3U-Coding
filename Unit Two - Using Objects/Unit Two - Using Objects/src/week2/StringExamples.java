package week2;

public class StringExamples {
    public static void main(String[] args) {

        // creating a string literal does not create a new Object
        String stringLiteral = "This is a string literal";
        String anotherLiteral = "This is a string literal";

        // THe following creates a String Object
        String somethingDifferent = new String("This is a string literal"); // Not a literal

        System.out.println(stringLiteral.length()); // LAst index is one less than the length
        System.out.println(stringLiteral.equals(somethingDifferent));

        System.out.println(stringLiteral.indexOf("in"));
        System.out.println(stringLiteral.indexOf("happy"));

        stringLiteral.length();
        System.out.println(stringLiteral.substring(3));
        System.out.println(stringLiteral.substring(3, 6)); // [startIndex, finalIndex] up to but NOT including 6

    }

}
