package Week1;

/**
 * Compound Assignment Operators
 */
public class ExampleSeven {
    public static void main(String[] args) {
        int x = 1;
        //x = x + 7;
        x += 7; //8
        x -= 3; //5
        x *= 2; //10
        x /= 3; //3
        x %= 4; //3

        x++;
        ++x;
        x--;
        --x;

        int y = 2 * x++; //increment x after use
        int z = 2 * ++x; //increment x before use
    }

}
