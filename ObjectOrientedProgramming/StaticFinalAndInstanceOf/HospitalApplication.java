package StaticFinalAndInstanceOf;
/*
this class is used to demonstrate the following concepts:
static - to represent shared hospital info and track the occupancy count
final - to ensure the patient ID is a constant, permanent identifier
this - to map constructor parameters to the instance variables of the class
*/
class Patient {
    // static members
    static String hospitalName = "City General Hospital";
    static int patientCount = 0;

    // instance members
    final int patientID;
    String name;
    int age;
    String ailment;

    // parameterized constructor
    Patient(int patientID, String name, int age, String ailment) {
        /* using 'this' keyword to resolve ambiguity between 
           the constructor arguments and the class fields 
        */
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;

        // incrementing the static counter for every new patient admitted
        patientCount++;
    }

    // static method to return the total number of patients
    static int getTotalPatients() {
        return patientCount;
    }

    // method to display patient information
    void displayPatientDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println();
    }
}

/*
the main class acts as the hospital administration system,
creating patient records and validating them using instanceof
*/
public class HospitalApplication {
    public static void main(String[] args) {
        // creating patient objects
        Patient p1 = new Patient(101, "John Doe", 45, "Hypertension");
        Patient p2 = new Patient(102, "Timothy Kumar", 32, "High blood pressure");

        // using the static method to show total admissions
        System.out.println("Total Admissions Today: " + Patient.getTotalPatients());
        System.out.println();

        // using instanceof to check object type before processing
        if (p1 instanceof Patient) {
            System.out.println("Validation: Object is a valid Patient record.");
            p1.displayPatientDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayPatientDetails();
        }
    }
}
