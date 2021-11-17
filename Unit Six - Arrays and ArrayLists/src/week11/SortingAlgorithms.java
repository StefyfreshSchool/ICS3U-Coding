package week11;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {30, 20, 5, 70, 90, 85, 10};
        int[] arr2 = {30, 20, 5, 70, 10};
        
        // selectionSort(arr);
        // insertionSort(arr);

        bogoSort(arr2);

        int f = 0;
    }

    private static void bogoSort(int[] arr2) {
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i - 1] > arr2[i]){
                shuffle(arr2);
                break;
            } 
        }
        bogoSort(arr2);
    }

    private static void shuffle(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            int temp = arr2[i];
            int index = (int) (Math.random() * (arr2.length - i + 1)) + i;
            arr2[i] = arr2[index];
            arr2[index] = temp;
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // division between sorted and unsorted
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) { // select the smallest
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // division between sorted and unsorted
            int index = i;
            for (int j = i + 1; j < arr.length; j++) { // select the smallest
                if (arr[j] < arr[index]){
                    index = j;
                } 
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    
}
