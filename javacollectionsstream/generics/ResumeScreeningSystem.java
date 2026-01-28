package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class serves as the main blueprint for all job roles.
 * Any subclass must implement the getRole() method to return
 * the name of the specific job role.
 */
abstract class JobRole{
    abstract String getRole();
}

/**
 * This class represents the Software Engineer role
 * and implements the getRole() method.
 */
class SoftwareEngineer extends JobRole{
    @Override
    public String getRole(){
        return "Software engineer";
    }
}

/**
 * This class represents the Data Scientist role
 * and implements the getRole() method.
 */
class DataScientist extends JobRole{
    @Override
    public String getRole(){
        return "Data Scientist";
    }
}

/**
 * This class represents the Product Manager role
 * and implements the getRole() method.
 */
class ProductManager extends JobRole{
    @Override
    public String getRole(){
        return "Product Manger";
    }
}

/**
 * This class creates and manages a list of resumes based on job roles.
 * It uses Java Generics to allow handling of any subclass of JobRole,
 * improving code reusability while maintaining type safety.
 *
 * @param <T> The specific JobRole type that this class
 *            is instantiated with.
 */
class Resume<T extends JobRole>{
    // List to store resumes based on job roles
    private List<T> screeningList = new ArrayList<>();

    /**
     * Getter method to retrieve the screening list.
     *
     * @return list containing all resumes
     */
    List<T> getScreeningList(){
        return screeningList;
    }

    /**
     * Setter method to replace the screening list.
     *
     * @param screeningList list of resumes to be assigned
     */
    void setScreeningList(List<T> screeningList){
        this.screeningList = screeningList;
    }

    /**
     * Adds a resume to the screening list based on job role.
     *
     * @param resume resume object belonging to a specific JobRole
     */
    void addResumeByRole(T resume){
        screeningList.add(resume);
    }

    /**
     * This method accepts a list containing subclasses of JobRole
     * and prints the total number of resumes along with their roles.
     *
     * @param screeningList list containing resume objects
     * @param <P> Generic parameter allowing flexibility for
     *            different JobRole implementations
     */
    <P extends JobRole> void printResumeRoles(List<P> screeningList){
        System.out.println("There are a total of "+screeningList.size()+" resumes, their roles are:");
        for(JobRole i: screeningList){
            System.out.println(i.getRole());
        }
    }
}

/**
 * This class contains the main method and demonstrates
 * the Resume Screening System using generics.
 */
public class ResumeScreeningSystem {
    // main method
    public static void main(String[] args){
        // Object creation for resume screening
        Resume<JobRole> screening = new Resume<>();

        // Adding resumes for different job roles
        screening.addResumeByRole(new DataScientist());
        screening.addResumeByRole(new SoftwareEngineer());
        screening.addResumeByRole(new SoftwareEngineer());
        screening.addResumeByRole(new ProductManager());
        screening.addResumeByRole(new DataScientist());

        // Printing all resume roles
        screening.printResumeRoles(screening.getScreeningList());
    }
}
