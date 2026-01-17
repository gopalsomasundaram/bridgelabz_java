package ClassAndObject.Level1;
/*
 * This class demonstrates a parameterized constructor and
 * basic geometric calculations using the Math class.
 */
import java.lang.Math;
public class Circle {
    //attributes
    int radius;
    int area;
    int circumference;

    //Parameterized Constructor
    Circle(int radius){

        this.radius = radius;//constructore for getting radius value
    }

    //Calculate Area
    void calcArea(){

        area = (int)((Math.PI)*(Math.pow((double)radius,2)));
    }

    //Calculate circumference
    void calcCircumference(){

        circumference = (int)(2.0*Math.PI*(double)radius);
    }

    //pring data
    void displayData(){
        System.out.println("Area of circle is: "+area);
        System.out.println("circumference of a circle is: "+circumference);
    }

    public static void main(String[] args){
        //object creation (with a specific value)
        Circle obj = new Circle(13);
        obj.calcArea();
        obj.calcCircumference();
        obj.displayData();
    }
}
