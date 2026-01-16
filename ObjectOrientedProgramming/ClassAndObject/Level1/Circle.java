package ClassAndObject.Level1;

import java.lang.Math;
public class Circle {
    int radius;
    int area;
    int circumference;
    Circle(int radius){
        this.radius = radius;//constructore for getting radius value
    }
    void calcArea(){
        area = (int)((Math.PI)*(Math.pow((double)radius,2)));
    }
    void calcCircumference(){
        circumference = (int)(2.0*Math.PI*(double)radius);
    }
    void displayData(){
        System.out.println("Area of circle is: "+area);
        System.out.println("circumference of a circle is: "+circumference);
    }
    public static void main(String[] args){
        Circle obj = new Circle(13);
        obj.calcArea();
        obj.calcCircumference();
        obj.displayData();
    }
}
