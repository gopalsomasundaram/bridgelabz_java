package EncapsulationAndInheritance;

import java.util.ArrayList;

/*
the Insurable interface defines the protocol for insurance calculations.
this allows us to attach insurance logic to vehicles that require it.
*/
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

/*
the Vehicle class is abstract, serving as a template for all rentals.
it uses encapsulation to hide sensitive data like the insurance policy.
*/
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // rate per day
    private String insurancePolicyNumber; // encapsulated sensitive data

    public Vehicle(String vehicleNumber, String type, double rentalRate, String policy) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policy;
    }

    // getters for encapsulated fields
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // protected getter so only subclasses or the class itself can see the policy
    protected String getInsurancePolicyNumber() { return insurancePolicyNumber; }

    /* abstract method: each vehicle type will have a
       unique way to calculate costs (e.g., weight-based for trucks).
    */
    public abstract double calculateRentalCost(int days);

    public void displayBasicInfo() {
        System.out.println("Vehicle No: " + vehicleNumber + " | Type: " + type);
    }
}

/*
Car subclass implements both the Vehicle template and Insurable behavior.
*/
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String policy) {
        super(vehicleNumber, "Car", rentalRate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; // flat daily rate
    }

    @Override
    public double calculateInsurance() {
        return 500.0; // flat insurance for cars
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy: " + getInsurancePolicyNumber() + " (Standard Car Coverage)";
    }
}

/*
Bike subclass implements the Vehicle template.
*/
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate, "NONE");
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) * 0.9; // 10% discount for bikes
    }
}

/*
Truck subclass implements the Vehicle template and Insurable behavior.
Includes weight-based rental logic.
*/
class Truck extends Vehicle implements Insurable {
    private double loadCapacity;

    public Truck(String vehicleNumber, double rentalRate, String policy, double load) {
        super(vehicleNumber, "Truck", rentalRate, policy);
        this.loadCapacity = load;
    }

    @Override
    public double calculateRentalCost(int days) {
        // trucks have an additional fee based on load capacity
        return (getRentalRate() * days) + (loadCapacity * 50);
    }

    @Override
    public double calculateInsurance() {
        return 1200.0 + (loadCapacity * 100); // insurance based on risk/weight
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy: " + getInsurancePolicyNumber() + " (Heavy Vehicle Coverage)";
    }
}

/*
the driver class manages the rental operations and polymorphism.
*/
public class RentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> fleet = new ArrayList<>();

        fleet.add(new Car("KA-01-1234", 1000.0, "POL-CAR-99"));
        fleet.add(new Bike("TN-02-5678", 300.0));
        fleet.add(new Truck("MH-03-9012", 3000.0, "POL-TRK-77", 10.5));

        int rentalDays = 5;
        System.out.println("--- Rental & Insurance Report (For " + rentalDays + " Days) ---");
        System.out.println("----------------------------------------------------------");

        for (Vehicle v : fleet) {
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = 0;
            String insuranceInfo = "N/A (No Insurance Required)";

            // polymorphism check using instanceof
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                insuranceCost = ins.calculateInsurance();
                insuranceInfo = ins.getInsuranceDetails();
            }

            v.displayBasicInfo();
            System.out.println("Rental Cost: ₹" + rentalCost);
            System.out.println("Insurance: ₹" + insuranceCost);
            System.out.println("Details: " + insuranceInfo);
            System.out.println("----------------------------------------------------------");
        }
    }
}