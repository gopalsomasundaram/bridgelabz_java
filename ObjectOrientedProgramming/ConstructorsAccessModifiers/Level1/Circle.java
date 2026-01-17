package ConstructorsAccessModifiers.Level1;
/*
 * This class demonstrates Constructor Chaining.
 * It ensures that all object initialization flows through a single point of logic.
 */
public class Circle {
    //Attributes
    double radius;

    // Default Constructor
    Circle() {
        this(5.0);   //chaining
    }

    // Parameterized Constructor
    Circle(double r) {
        radius = r;
    }

    void displayData() {
        System.out.println("Radius : " + radius);
    }

    public static void main(String[] args) {
        //creating object without parameters
        Circle c1 = new Circle();
        c1.displayData();

        //creating object with parameters
        Circle c2 = new Circle(7.5);
        c2.displayData();
    }
}
