package week9;


// Inheriting everything from Rectangle into Box
public class Box extends Rectangle{

    /**If an explicit constructor is not written, Java supplies this one for you.
    * It does nothing except call your parent's no-argument constructor.
    public Box(){
        super();
    }
    */

    private double height;

    public Box(double l, double w, double h){
        //length = l; child classes do not have direct access to the parent's private attributes and methods
        //width = w;
        super(l,w); //If you are going to call the parent constructor it has to be the first thing in your constructor.
        height = h;
        // super(l,w); This causes an error because it is not the first thing in the constructor.
    }

    public Box(double side){
        super(side);
        height = side;
    }

    public boolean equals(Object obj){
        if (obj == null) return false;
        if (!(obj instanceof Box)) return false;
        Box b = (Box) obj;
        return this.getLength() == b.getLength() && this.getWidth() == b.getWidth() && this.height == b.height;
    }

    public double getArea(){
        return super.getArea() * 2 + getLength() * height * 2 + getWidth() * height * 2;
    }

    public double getVolume(){
        return super.getArea() * height;
    }

    public String toString() {
        return "Box: length of " + getLength() + ", width of " + getWidth() + " and height of " + height;
    }

    public double getPerimeter(){
        return super.getPerimeter() * 2 + height * 4;
    }
}
