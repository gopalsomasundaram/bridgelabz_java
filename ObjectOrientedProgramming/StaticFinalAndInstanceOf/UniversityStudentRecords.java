package StaticFinalAndInstanceOf;

/**
 * this class demonstrates the use of:
 * static - to represent shared university data and track enrollment totals
 * final - to ensure the roll number is a constant identifier for each student
 * this - to assign constructor parameters to instance variables accurately
 */
class Student {
    // static members
    static String universityName = "Tech State University";
    static int studentCount = 0;

    // instance members
    final int rollNumber;
    String name;
    char grade;

    //parameterized constructor to initialize student details.
    Student(int rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        
        // incrementing the shared counter every time a new student is created
        studentCount++;
    }

    // static method to access class-level data
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled at " + universityName + ": " + studentCount);
    }

    // method to show individual student records
    void displayInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

/**
 * this class serves as the entry point for the application.
 * it demonstrates object creation and the use of the instanceof
 * operator for safe type checking.
 */
public class UniversityStudentRecords {
    public static void main(String[] args) {
        // initializing student objects
        Student s1 = new Student(101, "Rahul Sharma", 'A');
        Student s2 = new Student(102, "Priya Patel", 'B');

        // displaying the shared university statistics
        Student.displayTotalStudents();
        System.out.println();

        /* using instanceof to ensure the object is a Student 
           before we attempt to call specific methods or logic.
        */
        Object obj = s1; // upcasting to Object type

        if (obj instanceof Student) {
            System.out.println("Verification Passed: Object is a valid Student instance.");
            // casting back to Student to access displayInfo
            ((Student) obj).displayInfo();
        }

        if (s2 instanceof Student) {
            s2.displayInfo();
        }
    }
}
