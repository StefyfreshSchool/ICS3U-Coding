package week3;

public class RandomExamples {
    public static void main(String[] args) {
        double r = Math.random();
        System.out.println(r); //random number between 0.0 and 1.0 not including 1

        int a = (int) (r*10) + 1;
        System.out.println(a);

        //random number between lower and upper bound
        //  int random = (int)(Math.random()*(upperBound-lowerBound+1)) + lowerBound
        /*
        String str = "Random numbers";

        int index = (int)(Math.random()*str.length());
        str = str.substring(0, index) + "x" + str.substring(index + 1);
        System.out.println(str);
        */
        String str = "Random numbers";

        int index = (int)(Math.random()*str.length());
        str = str.substring(0, index) + str.substring(index);
        System.out.println(str);
    }
    
}
