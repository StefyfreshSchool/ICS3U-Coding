package week11;

import static java.lang.Math.*;

import java.util.Arrays;

public class SearchingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {30, 50, 10, 8, 90, 6, 5};

        int index = linearSearch(arr, 90);
        index = linearSearch(arr, 92);

        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (random() * 1000);
        }

        Arrays.sort(arr2);
        Arrays.sort(arr);

        index = binarySearch(arr, 5);
        index = binarySearch(arr2, 413);
    }

    private static int binarySearch(int[] arr, int i) {
        int min = 0;
        int max = arr.length - 1;
        while (max >= min){
            int med = (min + max) / 2;
            if (arr[med] == i) return med;
            else if (arr[med] > i) max = med - 1;
            else if (arr[med] < i) min = med + 1;
            
        }
        
        return -1;
    }

    private static int linearSearch(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i) return i;
        }
        return -1;
    }
}
