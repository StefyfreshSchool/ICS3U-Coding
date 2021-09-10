package Week1;
/**
 * Escape sequences are used  for special characters in Strings
 */
public class ExampleThree {

    public static void main(String[] args) {
        //System.out.println("This is "very" special!"); //compile error
        System.out.println("This is \"very\" special!"); //backslash to excape special characters

        //System.out.println("This is \very special!"); //cannot escape \v

        System.out.println("This\nis\nvery\nspecial!"); //new line
        //vaid escape sequencces are \b \t \n \f \r \" \' \\
    }
}
