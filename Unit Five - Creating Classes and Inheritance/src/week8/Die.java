package week8;

public class Die {
    // private can only be accessed inside the class.
    // other classes cannot access private attributes/methods/constructors directly.
    private int topSide;

    private int numSides;


    // default/no-argument constructor
    // If you do not create a constructor then Java creates a default no-argument blank constructor.
    public Die(){
        numSides = 6;
        roll();
    }

    // this refers to THIS instance of the Die.
    // The Die that we are creating/the die that called the method.
    /**
     * Die die1 = new Die()
     * die1.roll();     this (inside the class) would be die1
     */

    public Die(int numSides){
        this.numSides = numSides;
    }

    public void roll(){
        this.topSide = (int) (Math.random() * numSides) + 1;
    }

    public int getTopSide() {
        return topSide;
    }

    public String toString(){
        return "" + topSide;
    }

    public boolean equals(Object obj){
        if (obj == this) return true;
        if (!(obj instanceof Die)) return false;
        return this.topSide == ((Die)obj).topSide;
    }
}
