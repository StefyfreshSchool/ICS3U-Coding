package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(1); 
        Double d = new Double(2.0); //
        
        Integer num = 7; // primitive int auto-boxing
        int m = num; //auto-unboxing

        int x = 6 + num; //auto-unboxing to add primitive and object (wrapper)
        int y = m + num;

        int z = n.intValue();
        //same as int z = n

        System.out.println(Integer.MAX_VALUE);  //constants for the largest and smallest ints
        System.out.println(Integer.MIN_VALUE);
    }
    
}
