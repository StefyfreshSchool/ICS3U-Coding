package Week1;

/**
 * final modifier - Make a variable constant
 */
public class ExampleSix {
    public static void main(String[] args) {
        final int x = 7;
        //x = 8; SYntax error because we cannot reassign a final variable
        final int y;
        y = x; //no issues because it is first assignment to y
        final int NUMBER_OF_STUDENTS = 30; //naming convention for constants is ALL_CAPS_WITH_UNDERSCORES

    }
    
}
