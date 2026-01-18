package Inheritance;

/*
this class represents the superclass (parent).
every person in the school system, regardless of their role,
has a name and an age.
*/
class Person {
    String name;
    int age;

    // constructor for common attributes
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // shared method to display basic personal information
    void displayBasicInfo() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

/*
this subclass represents a Teacher.
it inherits from Person and adds the 'subject' attribute.
*/
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        // initializing parent fields
        super(name, age);
        this.subject = subject;
    }

    // specialized method for this role
    void displayRole() {
        System.out.println("Role: Teacher");
        displayBasicInfo();
        System.out.println("Subject Specialization: " + subject);
        System.out.println("------------------------------------------");
    }
}

/*
this subclass represents a Student.
it adds the 'grade' level attribute.
*/
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
        displayBasicInfo();
        System.out.println("Current Grade: " + grade);
        System.out.println("------------------------------------------");
    }
}

/*
this subclass represents Administrative Staff.
it adds the 'department' attribute.
*/
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Support Staff");
        displayBasicInfo();
        System.out.println("Department: " + department);
        System.out.println("------------------------------------------");
    }
}

/*
the driver class manages the school directory.
*/
public class SchoolHierarchy{
    public static void main(String[] args) {
        // creating objects for each specific role
        Teacher t = new Teacher("Mr. John", 40, "Mathematics");
        Student s = new Student("Alice", 15, "10th Grade");
        Staff st = new Staff("Mrs. Smith", 35, "Admissions");

        System.out.println("--- School Directory ---");

        // each subclass executes its own displayRole logic
        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
