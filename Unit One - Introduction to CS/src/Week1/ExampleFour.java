package Week1;

/**
 * Variables - store information / data
 * Primitive Data Types(int, double, char, boolean)
 * Assignment Operator - assigns a value to a variable (assignment operator is =)
 */
public interface ExampleFour {
    public static void main(String[] args) {
        int markOne = 75; //declare int markOne storing val 75
        int markTwo = 80;
        int markThree = 87;
        int average; //declaration with no assignemnt
        average = (markOne + markTwo + markThree)/3;

        System.out.println("The average of the marks is: " + average); //join data types with +
        

    }
}