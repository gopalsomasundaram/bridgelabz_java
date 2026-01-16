package ClassAndObject.Level2;

public class Student {
    String name = "John";
    int rollNumber = 12;
    int marks = 85;

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
        Student obj = new Student();
        obj.displayData();
    }
}
