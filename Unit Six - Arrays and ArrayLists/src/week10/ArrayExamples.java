package week10;

public class ArrayExamples {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Animal[] animals = new Animal[3];
        
        // access elements at indexes with [index]
        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 10;
        arr[3] = 12;
        arr[4] = -2;

        animals[0] = new Animal();
        animals[1] = new Animal();
        animals[2] = new Animal();

        System.out.println(arr.length);
        System.out.println(animals.length / 2);
        
    }
}
