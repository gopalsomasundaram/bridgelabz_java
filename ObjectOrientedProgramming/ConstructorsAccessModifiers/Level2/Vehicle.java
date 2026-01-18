package ConstructorsAccessModifiers.Level2;
/**
 * The Vehicle class is designed to manage individual vehicle records
 * while maintaining a global registration fee applicable to all instances.
 * It demonstrates the interaction between instance-specific data
 * and class-level (static) configuration.
 */
public class Vehicle {
    // 1. Instance Variables
    private String ownerName;
    private String vehicleType;

    // 2. Class Variable (Static)
    private static int registrationFee = 5000;

    // Constructor to initialize instance variables
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // 3. Instance Method
    public void displayVehicleDetails() {
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Vehicle Type    : " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }



    //Static Method
    //Updates the shared fee
    public static void updateRegistrationFee(int newFee) {
        registrationFee = newFee;
        System.out.println("Global Registration Fee updated to: " + newFee);
    }

    public static void main(String[] args) {
        // Create two different vehicle objects
        Vehicle v1 = new Vehicle("Arun", "Sedan");
        Vehicle v2 = new Vehicle("Sita", "SUV");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        // Update the global fee using the Class Name
        Vehicle.updateRegistrationFee(6500);

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}