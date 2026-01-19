package EncapsulationAndInterface;

import java.util.ArrayList;

/*
the MedicalRecord interface defines the contract for clinical data management.
using an interface allows us to separate administrative billing from
medical data handling.
*/
interface MedicalRecord {
    void addRecord(String entry);
    void viewRecords();
}

/*
the Patient class is abstract, serving as the secure foundation for the system.
it uses encapsulation to shield sensitive medical history from direct access.
*/
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private ArrayList<String> history; // encapsulated sensitive data

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.history = new ArrayList<>();
    }

    // getters for administrative fields
    public String getName() { return name; }
    public String getPatientId() { return patientId; }

    // abstract method: forces subclasses to implement
    public abstract double calculateBill();

    // concrete method: shared logic for displaying patient identity
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + " | Name: " + name + " | Age: " + age);
    }

    @Override
    public void addRecord(String entry) {
        history.add(entry);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + name + ":");
        if (history.isEmpty()) {
            System.out.println("  - No records found.");
        } else {
            for (String entry : history) {
                System.out.println("  - " + entry);
            }
        }
    }
}

/*
 InPatient subclass: billing includes daily room charges and specialized care.
 */
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRoomRate;

    public InPatient(String id, String name, int age, int days, double rate) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyRoomRate = rate;
    }

    @Override
    public double calculateBill() {
        double flatAdmissionFee = 500.0;
        return (daysAdmitted * dailyRoomRate) + flatAdmissionFee;
    }
}

/*
OutPatient subclass: billing is based on consultation fees and diagnostic tests.
*/
class OutPatient extends Patient {
    private double consultationFee;
    private double labCharges;

    public OutPatient(String id, String name, int age, double fee, double labs) {
        super(id, name, age);
        this.consultationFee = fee;
        this.labCharges = labs;
    }

    @Override
    public double calculateBill() {
        return consultationFee + labCharges;
    }
}

/*
the driver class demonstrates polymorphic billing and secure record management.
*/
public class HospitalPatientManagement {
    public static void main(String[] args) {
        ArrayList<Patient> hospitalRegistry = new ArrayList<>();

        // 1. Create different types of patients
        InPatient p1 = new InPatient("IN-101", "Aayush", 21, 5, 1200.0);
        OutPatient p2 = new OutPatient("OUT-202", "Sita", 28, 500.0, 1500.0);

        // 2. Add some medical history (Encapsulated Interaction)
        p1.addRecord("Diagnosed with Fever");
        p1.addRecord("Prescribed Paracetamol");
        p2.addRecord("Routine Blood Checkup");

        hospitalRegistry.add(p1);
        hospitalRegistry.add(p2);

        System.out.println("--- Hospital Billing & Medical Summary ---");
        System.out.println("------------------------------------------");

        for (Patient p : hospitalRegistry) {
            // displaying administrative data
            p.getPatientDetails();
            
            // dynamic polymorphism in billing
            System.out.println("Total Amount Due: ₹" + p.calculateBill());
            
            // viewing sensitive data via the interface methods
            p.viewRecords();
            System.out.println("------------------------------------------");
        }
    }
}