package Week1;

public class ExampleEight {
    public static void main(String[] args) {
        final int NUM_MARKS = 5;
        int m1 = 84, m2 = 78, m3 = 87, m4 = 97, m5 = 63;
        //cast any int causes double math to occur
        double avg = (double)(m1 + m2 + m3 + m4 + m5)/NUM_MARKS;
        
        System.out.println(avg);



        //int y = 7.3; //type mismatch

        //int y = (double)3;

        double z = 4.5;
        int y = (int) z;

        //narrow conversion  double -> int
        //widen conversion  int -> double
    }

}