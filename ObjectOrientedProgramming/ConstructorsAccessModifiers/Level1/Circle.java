package ConstructorsAccessModifiers.Level1;

public class Circle {
    double radius;

    // Default
    Circle() {
        this(5.0);   //chaining
    }

    // Parameterized
    Circle(double r) {
        radius = r;
    }

    void displayData() {
        System.out.println("Radius : " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.displayData();

        Circle c2 = new Circle(7.5);
        c2.displayData();
    }
}
