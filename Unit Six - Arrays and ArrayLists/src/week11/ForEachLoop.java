package week11;

public class ForEachLoop {
    public static void main(String[] args) {
        int[] arr = {30, 50, 10, 8, 90, 6, 5};

        // For each is when iterating through array and you do not need the index
        // Cannot change the size of the arrayList (add or remove elements)

        int sum = 0;

        for (int el : arr) {
            sum += el;
        }

        String[] a = {"Test", "Alphabet", "Steve", "Baseball", "Leafs"};

        String vowels = "aeiou";
        int numVowels = 0;
        for (String el : a) {
            for (int i = 0; i < el.length(); i++) {
                if (vowels.indexOf(el.substring(i, i + 1).toLowerCase()) >= 0) numVowels++;
            }
        }

        System.out.println(numVowels);
    }
    
}
