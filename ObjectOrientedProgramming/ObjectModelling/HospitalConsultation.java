package ObjectModelling;

import java.util.ArrayList;

/* this class represents the Patient entity.
it is an independent class that can be associated with multiple doctors.
it maintains a record of doctors consulted for history tracking.
*/
class Patient {
    private String name;
    private String ailment;
    private ArrayList<String> consultationHistory;

    Patient(String name, String ailment) {
        this.name = name;
        this.ailment = ailment;
        this.consultationHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAilment() {
        return ailment;
    }

    // method to log a consultation into the patient's records
    public void addConsultationRecord(String doctorName) {
        consultationHistory.add("Consulted with Dr. " + doctorName);
    }

    public void displayHistory() {
        System.out.println("Medical History for " + name + ":");
        for (String record : consultationHistory) {
            System.out.println("  - " + record);
        }
    }
}

/* this class represents the Doctor entity.
it demonstrates communication by interacting directly with a Patient object.
doctors can see multiple patients during their shift.
*/
class Doctor {
    private String doctorName;
    private String specialization;

    Doctor(String doctorName, String specialization) {
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    /* this method implements communication between objects.
    the Doctor object 'calls' a method on the Patient object 
    to update the patient's medical history.
    */
    public void consult(Patient patient) {
        System.out.println("Dr. " + doctorName + " (" + specialization + 
                           ") is consulting Patient: " + patient.getName());
        System.out.println("Diagnosing ailment: " + patient.getAilment());
        
        // updating the patient's record through object communication
        patient.addConsultationRecord(doctorName);
        System.out.println("Consultation complete. Patient record updated.");
        System.out.println();
    }

    public String getDoctorName() {
        return doctorName;
    }
}

/* the Hospital class acts as the container for these entities.
it manages the lists of doctors and patients available in the system.
*/
class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void displayHospitalInfo() {
        System.out.println("Welcome to " + hospitalName);
        System.out.println("Available Doctors: " + doctors.size());
        System.out.println("Registered Patients: " + patients.size());
        System.out.println();
    }
}

/* the driver class demonstrates the many-to-many relationship 
and the communication flow between Doctor and Patient.
*/
public class HospitalConsultation {
    public static void main(String[] args) {
        // 1. Setup the Hospital and its staff/patients
        Hospital cityHospital = new Hospital("St. Lukes Medical Center");
        
        Doctor d1 = new Doctor("House", "Diagnostic Medicine");
        Doctor d2 = new Doctor("Strange", "Neurosurgery");
        
        Patient p1 = new Patient("John Doe", "Chronic Pain");
        Patient p2 = new Patient("Jane Smith", "Head Trauma");

        cityHospital.addDoctor(d1);
        cityHospital.addDoctor(d2);
        cityHospital.addPatient(p1);
        cityHospital.addPatient(p2);

        cityHospital.displayHospitalInfo();

        // 2. Demonstrate Association and Communication
        // Doctor 1 consults Patient 1
        d1.consult(p1);
        
        // Doctor 2 consults Patient 1 (Many-to-Many: Patient has multiple doctors)
        d2.consult(p1);
        
        // Doctor 1 consults Patient 2 (Many-to-Many: Doctor has multiple patients)
        d1.consult(p2);

        // 3. Verify the results of the communication
        p1.displayHistory();
        System.out.println();
        p2.displayHistory();
    }
}