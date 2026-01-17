package ClassAndObject.Level2;
/*
 * This class models a Student and uses conditional logic to
 * determine a grade based on the student's marks.
 */
public class Student {
    //Instance Variables
    String name = "John";
    int rollNumber = 12;
    int marks = 85;
    // This method returns a single character 'A' through 'D' based on thresholds.
    char calculateGrade() {
        if (marks >= 90)
            return 'A';
        else if (marks >= 75)
            return 'B';
        else if (marks >= 60)
            return 'C';
        else
            return 'D';
    }

    void displayData() {
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Marks : " + marks);
        System.out.println("Grade : " + calculateGrade());
    }

    public static void main(String[] args) {
        //Instantiation
        Student obj = new Student();
        //Execution
        obj.displayData();
    }
}
