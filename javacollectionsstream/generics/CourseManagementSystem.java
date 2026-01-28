/**
 * This Program implements a course management system using java generics
 * for allowing different class types of a single abstract class to be used
 * in the same class, allowing for more resusable code while also maintaining
 * type safety and readability. We achieve this using generic classes, methods
 * and wildcards
 *
 * @author gopal
 */
package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * this class serves as the main abstract class (blueprint) for
 * all of the different courses, it declares the GeoCourseType()
 * function that needs to be implemented in subclasses
 */
abstract class CourseType{
    abstract String GetCourseType();
}

/**
 * this class is a subclass of CourseType and
 * implements GetCourseType function
 */
class ExamCourse extends CourseType{
    @Override
    public String GetCourseType(){
        return "Exam Course";
    }
}
/**
 * this class is a subclass of CourseType and
 * implements GetCourseType function
 */
class AssignmentCourse extends CourseType{
    @Override
    public String GetCourseType(){
        return "Assignment Course";
    }
}
/**
 * this class is a subclass of CourseType and
 * implements GetCourseType function
 */
class ResearchCourse extends CourseType{
    @Override
    public String GetCourseType(){
        return "Research Course";
    }
}

/**
 * This class creates and manages list of classes as private member.
 * It also allows printing of all of the members of the list.
 * This class can also accommodate any class that it was instanciated with using generics
 * @param <T> this is the class type that class would be instantiated with allowing for
 *           reusability of this class
 */
class Course<T extends CourseType>{
    //list creation
    private List<T> courseList = new ArrayList<>();

    //getter for list
    public List<T> getCourseList(){
        return courseList;
    }

    //setter for list
    public void setCourseList(List<T> courseList){
        this.courseList = courseList;
    }

    //Allows addition of single course to the list
    public void AddCourse(T singleCourse){
        courseList.add(singleCourse);
    }

    /**
     * This method takes a list containing sub classes of CourseTypes
     * and prints all of the courses assessment types within it
     * @param courseList list containgin all of the courses added
     * @param <P> allows for resuability while accomodating any course type
     */
    public <P extends CourseType> void printCourses(List<P> courseList){
        System.out.println("There are a total of "+courseList.size()+" courses");
        for(CourseType i : courseList){
            System.out.println(i.GetCourseType());
        }
    }
}

//class for main function
public class CourseManagementSystem {
    //public main method
    public static void main(String[] args){
        System.out.println("department 1 courses:");
        //object creation to add and hold courses for department1
        Course<CourseType> department1 = new Course<>();
        department1.AddCourse(new ExamCourse());
        department1.AddCourse(new ResearchCourse());
        department1.AddCourse(new AssignmentCourse());
        //method call to print all of the courses in the list
        department1.printCourses(department1.getCourseList());

        System.out.println("department 2 coursese: ");
        //object creation to add and hold courses for department2
        Course<CourseType> department2 = new Course<>();
        department2.AddCourse(new AssignmentCourse());
        department2.AddCourse(new AssignmentCourse());
        department2.AddCourse(new ExamCourse());
        department2.AddCourse(new ExamCourse());
        //object creation to add and hold courses for department2
        department2.printCourses(department2.getCourseList());
    }
}
