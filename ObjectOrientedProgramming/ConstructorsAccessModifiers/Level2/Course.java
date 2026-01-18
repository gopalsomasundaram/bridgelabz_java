package ConstructorsAccessModifiers.Level2;
/*
 * This class demonstrates the difference between Instance and Static members.
 * It shows how static members provide a "Global" state for all objects of the class.
 */
public class Course {
    // Instance variables
    String courseName;
    int duration;   // in months
    int fee;

    // Class (static) variable
    static String instituteName = "ABC Institute";

    // Parameterized constructor
    Course(String c, int d, int f) {
        courseName = c;
        duration = d;
        fee = f;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course Name     : " + courseName);
        System.out.println("Duration (Months): " + duration);
        System.out.println("Fee             : " + fee);
        System.out.println("Institute Name  : " + instituteName);
    }

    // Class (static) method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 6, 30000);
        Course c2 = new Course("Python", 4, 25000);

        c1.displayCourseDetails();
        System.out.println();

        // Update institute name for all courses
        Course.updateInstituteName("XYZ Technologies");

        c2.displayCourseDetails();
    }
}
