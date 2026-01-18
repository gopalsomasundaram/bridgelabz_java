package ConstructorsAccessModifiers.Level2;
/**
 * The Student class demonstrates the use of different access modifiers
 * (public, protected, and private) to implement Encapsulation.
 * It serves as a base class for specialized student types.
 */
// Base Class
class Student {
    //Public attribute
    public int rollNumber;

    //Protected attribute
    protected String name;

    //Private attribute
    private double cgpa;

    // Constructor
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    //Getter for private member
    public double getCGPA() {
        return cgpa;
    }

    //Setter for private member
    public void setCGPA(double newCGPA) {
        this.cgpa = newCGPA;
    }
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Adam", 8.5);

        pg.displayPGDetails();

        // Modifying private data through public setter
        pg.setCGPA(9.2);
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
/**
 * PostgraduateStudent is a subclass of Student.
 * It demonstrates how 'protected' members of a parent class
 * are accessible to its children.
 */
// Subclass demonstrating Protected access
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        // Calling the parent constructor
        super(rollNumber, name, cgpa);
    }

    public void displayPGDetails() {
        // name is accessible as PostgraduateStudent is subclass
        // cgpa is noy accessible directly we must use getCGPA()
        System.out.println("PG Student: " + name + " (Roll: " + rollNumber + ")");
        System.out.println("Current CGPA: " + getCGPA());
    }
}
