package Inheritance;

/*
this class serves as the superclass (parent).
it contains common properties that every vehicle shares,
reducing code duplication in the subclasses.
*/
class Vehicle {
    double maxSpeed;
    String fuelType;

    // constructor to initialize common vehicle traits
    Vehicle(double maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // generic method to display vehicle data
    void displayInfo() {
        System.out.print("Max Speed: " + maxSpeed + " km/h | Fuel: " + fuelType);
    }
}

/*
this class represents a Car and extends Vehicle.
it adds the unique attribute 'seatCapacity'.
*/
class Car extends Vehicle {
    int seatCapacity;

    Car(double maxSpeed, String fuelType, int seatCapacity) {
        // calling the parent constructor to set common fields
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // reuse parent display logic
        System.out.println(" | Seats: " + seatCapacity + " [Car]");
    }
}

/*
this class represents a Truck and adds 'loadCapacity'.
*/
class Truck extends Vehicle {
    double loadCapacity; // in tons

    Truck(double maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println(" | Load Capacity: " + loadCapacity + " tons [Truck]");
    }
}

/*
this class represents a Motorcycle and adds 'hasSidecar'.
*/
class Motorcycle extends Vehicle {
    boolean hasSidecar;

    Motorcycle(double maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println(" | Sidecar: " + (hasSidecar ? "Yes" : "No") + " [Motorcycle]");
    }
}

/*
the driver class demonstrates polymorphism.
we store specialized objects in a generalized array.
*/
public class TransportSystem {
    public static void main(String[] args) {
        /*
           polymorphism in action:
           an array of type 'Vehicle' can hold any object that 'Is-A' Vehicle.
           this allows us to handle different objects uniformly.
        */
        Vehicle[] fleet = {
            new Car(220.0, "Petrol", 5),
            new Truck(100.0, "Diesel", 15.5),
            new Motorcycle(180.0, "Petrol", false)
        };

        System.out.println("--- Fleet Information ---");
        for (Vehicle v : fleet) {
            /*
               at runtime, Java identifies the actual object type
               and calls the correct overridden displayInfo() method.
               this is called Dynamic Method Dispatch.
            */
            v.displayInfo();
        }
    }
}