package week4;
import static java.lang.Math.*;

public class BVGPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width  = 8;

        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;
        final int linerCost = 2;

        double volume = calculateVolume(length, width, shallowLength, shallowHeight, transition, deepHeight);
        double volume90 = volume*0.9;
        double area = calculateArea(length, width, shallowLength, shallowHeight, transition, deepHeight);
        double linerPrice = area * linerCost;
        System.out.println(volume+" | "+volume90+" | "+area+" | $"+linerPrice + " | NOT ROUNDED");
    }

    public static double calculateVolume(int length, int width, int shallowLength, int shallowHeight, int transition, int deepHeight){
        int r1 = length*width*shallowHeight;
        int transitionHeight = deepHeight-shallowHeight;
        double transitionLength = (sqrt(pow(transition, 2) - pow(transitionHeight, 2)));
        double deepLength = length - shallowLength - transitionLength;
        double r2 = width*deepLength*transitionHeight;
        double t1 = (transitionLength*width*transitionHeight)/2;
        return r1 + r2 + t1;
    }
    
    public static double calculateArea(int length, int width, int shallowLength, int shallowHeight, int transition, int deepHeight){
        int w1 = shallowHeight*width*2;
        int w2 = length*shallowHeight*2;
        int transitionHeight = deepHeight-shallowHeight;
        int w3 = width*transitionHeight;
        double transitionLength = (sqrt(pow(transition, 2) - pow(transitionHeight, 2)));
        double deepLength = length - shallowLength - transitionLength;
        double w4 = deepLength*transitionHeight*2;
        double f1 = deepLength*width;
        int f2 = shallowLength*width;
        int f3 = transition*width;
        double t1 = transitionHeight*transitionLength;
        return w1 + w2 + w3 + w4 + f1 + f2 + f3 + t1;
    }
}
