package ObjectModelling;

import java.util.ArrayList;

/**
 * this class represents the Professor entity.
 * professors are independent of the courses they teach (aggregation).
 */
class Professor {
    private String name;
    private String department;

    Professor(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    /**
     * demonstrates communication: the professor 'announces' their 
     * assignment to a specific course.
     */
    public void teachCourse(String courseName) {
        System.out.println("Professor " + name + " from " + department + 
                           " is now teaching " + courseName);
    }
}

/**
 * this class represents the Student entity.
 * students have a 'has-a' relationship with courses through enrollment.
 */
class Student {
    private String studentName;
    private int studentId;
    private ArrayList<String> enrolledCourses;

    Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    /**
     * implements object communication: the student interacts with 
     * the course system to register.
     */
    public void enrollInCourse(String courseName) {
        enrolledCourses.add(courseName);
        System.out.println("Student " + studentName + " (ID: " + studentId + 
                           ") has successfully enrolled in " + courseName);
    }

    public void displayEnrolledCourses() {
        System.out.println("Enrolled Courses for " + studentName + ": " + enrolledCourses);
    }
}

/**
 * this class acts as the aggregator. it maintains references 
 * to both the teacher (Professor) and the learners (Students).
 */
class Course {
    private String courseCode;
    private String courseName;
    private Professor instructor;
    private ArrayList<Student> studentList;

    Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentList = new ArrayList<>();
    }

    /**
     * association logic: linking a professor to this course.
     */
    public void assignProfessor(Professor professor) {
        this.instructor = professor;
        professor.teachCourse(this.courseName);
    }

    /**
     * aggregation logic: adding an existing student to the course roster.
     */
    public void registerStudent(Student student) {
        studentList.add(student);
        student.enrollInCourse(this.courseName);
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse: " + courseName + " [" + courseCode + "]");
        System.out.println("Instructor: " + (instructor != null ? instructor.getName() : "TBD"));
        System.out.println("Total Students: " + studentList.size());
        System.out.println("------------------------------------------");
    }
}

/**
 * the driver class demonstrates the interactions between students, 
 * professors, and the courses they share.
 */
public class UniversityManagement{
    public static void main(String[] args) {
        // 1. Initializing independent entities (Aggregation foundation)
        Professor prof1 = new Professor("Dr. Aris", "Computer Science");
        Student s1 = new Student("Aayush", 4001);
        Student s2 = new Student("Sita", 4002);

        // 2. Creating the course hub
        Course dsa = new Course("CS201", "Data Structures and Algorithms");

        // 3. Demonstrating Association and Communication
        // linking the professor to the course
        dsa.assignProfessor(prof1);

        // linking students to the course
        dsa.registerStudent(s1);
        dsa.registerStudent(s2);

        // 4. Verification of the system state
        dsa.displayCourseInfo();
        s1.displayEnrolledCourses();
    }
}
