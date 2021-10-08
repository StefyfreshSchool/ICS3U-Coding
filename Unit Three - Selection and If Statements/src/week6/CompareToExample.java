package week6;

public class CompareToExample {
    public static void main(String[] args) {
        System.out.println("abce".compareTo("bcd"));

        //System.out.println("a".compareTo("g"));
        //System.out.println("g".compareTo("a"));
        //System.out.println("g".compareTo("g"));
        //System.out.println("g".compareTo("G"));
        System.out.println("go".compareTo("get")); // "go" > "get" because "o" > "e"

        System.out.println("goo".compareTo("go"));
    }
    
}
