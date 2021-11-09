package week9;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double l, double w){
        length = l;
        width = w;
    }

    public Rectangle(double side){
        length = side;
        width = side;
    }
    
    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return length * 2 + width * 2;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public boolean equals(Object obj){
        if (obj == null) return false;
        if (!(obj instanceof Rectangle)) return false;
        Rectangle r = (Rectangle) obj;
        return this.length == r.length && this.width == r.width;
    }
    

    public String toString() {
        return "Rectangle: length of " + length + " and width of " + width;
    }
}
