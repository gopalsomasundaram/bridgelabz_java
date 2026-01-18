package StaticFinalAndInstanceOf;
/*
this class is used to demonstrate the following concepts:
static - to manage a uniform registration fee for all vehicles
final - to ensure the registration number is permanent and tamper-proof
this - to map the constructor arguments to the instance variables
*/
class Vehicle {
    // static members
    static double registrationFee = 500.0;

    // instance members
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    // parameterized constructor
    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        /* using 'this' keyword to resolve the naming conflict between 
           the constructor parameters and the class fields 
        */
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // static method to update the common fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("The registration fee has been updated for all vehicles.");
    }

    // method to display vehicle and owner details
    void displayVehicleDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Current Fee Applied: " + registrationFee);
        System.out.println();
    }
}

/*
the main class executes the registration logic and uses the
instanceof operator to verify the object type before processing
*/
public class RegistrationApplication {
    public static void main(String[] args) {
        // updating the static fee before creating instances
        Vehicle.updateRegistrationFee(650.0);
        System.out.println();

        // creating vehicle objects
        Vehicle v1 = new Vehicle("KA-01-ME-1234", "Ananya Rao", "SUV");
        Vehicle v2 = new Vehicle("DL-05-AB-9876", "Vikram Singh", "Sedan");

        // using instanceof to check object type
        if (v1 instanceof Vehicle) {
            System.out.println("Object Verified: Displaying registration record for v1...");
            v1.displayVehicleDetails();
        }

        if (v2 instanceof Vehicle) {
            System.out.println("Object Verified: Displaying registration record for v2...");
            v2.displayVehicleDetails();
        }
    }
}