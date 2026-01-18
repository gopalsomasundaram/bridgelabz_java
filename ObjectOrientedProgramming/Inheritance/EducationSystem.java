package Inheritance;

/*
this class represents the base level (Grandparent).
it defines the most fundamental properties of any 
educational offering, whether physical or digital.
*/
class Course {
    String courseName;
    int duration; // in hours

    // constructor for the base class
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // method to display foundational course info
    void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

/*
this class represents the second level (Parent).
it extends Course, inheriting the basic details while 
adding attributes specific to internet-based learning.
*/
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        // passing academic data to the Course constructor
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Format: " + (isRecorded ? "Recorded Sessions" : "Live Sessions"));
    }
}

/*
this class represents the third level (Child).
it extends OnlineCourse, inheriting all previous details 
and adding a pricing and discount model.
*/
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, 
                     boolean isRecorded, double fee, double discount) {
        // passing data up the chain to the OnlineCourse constructor
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // method to calculate the final price after discount
    double getFinalPrice() {
        return fee - (fee * discount / 100);
    }

    /* method overriding: this version displays the academic, 
       technical, and financial details of the course.
    */
    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Original Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + getFinalPrice());
        System.out.println("------------------------------------------");
    }
}

/*
the driver class manages the instantiation and display 
of the course hierarchy.
*/
public class EducationSystem {
    public static void main(String[] args) {
        /*
           creating a PaidOnlineCourse object.
           it inherits 'courseName' from Course, 
           'platform' from OnlineCourse, 
           and has its own 'fee' attribute.
        */
        PaidOnlineCourse myCourse = new PaidOnlineCourse(
            "Java Backend Development", 
            40, 
            "Udemy", 
            true, 
            49.99, 
            15.0
        );

        System.out.println("--- Course Enrollment Details ---");
        // this triggers the display logic from the lowest level in the chain
        myCourse.displayCourseInfo();
    }
}