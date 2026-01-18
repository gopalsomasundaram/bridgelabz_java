package Inheritance;

/**
 * the Refuelable interface defines behavior for combustion engines.
 * only vehicles that require liquid fuel will implement this contract.
 */
interface Refuelable {
    void refuel();
}

/**
 * this class represents the general superclass.
 * it stores foundational data like model and speed that apply
 * to every type of transport in the system.
 */
class BaseVehicle {
    String model;
    double maxSpeed;

    // constructor to initialize common vehicle attributes
    BaseVehicle(String model, double maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // common method to display basic specifications
    void displaySpecs() {
        System.out.println("Model: " + model + " | Max Speed: " + maxSpeed + " km/h");
    }
}

/**
 * the ElectricVehicle class extends the Vehicle superclass.
 * it adds a specialized charge() method instead of refueling.
 */
class ElectricVehicle extends BaseVehicle {
    int batteryCapacity; // in kWh

    ElectricVehicle(String model, double maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    // specific behavior for electric transport
    void charge() {
        System.out.println("Status: " + model + " is currently charging its " +
                batteryCapacity + " kWh battery.");
    }

    void displayDetails() {
        displaySpecs();
        System.out.println("Power Type: Electric | Battery: " + batteryCapacity + " kWh");
        System.out.println("------------------------------------------");
    }
}

/**
 * the PetrolVehicle class demonstrates Hybrid Inheritance.
 * it inherits from the Vehicle class (State) and
 * implements the Refuelable interface (Behavior).
 */
class PetrolVehicle extends BaseVehicle implements Refuelable {
    double tankCapacity; // in liters

    PetrolVehicle(String model, double maxSpeed, double tankCapacity) {
        super(model, maxSpeed);
        this.tankCapacity = tankCapacity;
    }

    /* implementation of the interface method.
       this ensures PetrolVehicle provides the logic for refueling.
    */
    @Override
    public void refuel() {
        System.out.println("Status: " + model + " is refueling at the petrol station.");
    }

    void displayDetails() {
        displaySpecs();
        System.out.println("Power Type: Petrol | Tank: " + tankCapacity + " Liters");
        System.out.println("------------------------------------------");
    }
}

/**
 * the driver class manages the vehicle system and
 * triggers specific behaviors for each type.
 */
public class VehicleManagement{
    public static void main(String[] args) {
        // creating objects for both vehicle types
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 225.0, 75);
        PetrolVehicle mustang = new PetrolVehicle("Ford Mustang", 250.0, 60.0);

        System.out.println("--- Vehicle Operations Log ---");

        // handling the Electric Vehicle
        tesla.displayDetails();
        tesla.charge();
        System.out.println();

        // handling the Petrol Vehicle (utilizing both inheritance and interface)
        mustang.displayDetails();
        mustang.refuel();

        /* demonstrating interface polymorphism:
           we can group any Refuelable object together.
        */
        if (mustang instanceof Refuelable) {
            System.out.println("\nVerification: This vehicle supports refueling protocols.");
        }
    }
}