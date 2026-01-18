package EncapsulationAndInheritance;

import java.util.ArrayList;

/* * the GPS interface defines the contract for location-based services.
 * any vehicle in the fleet must be able to track its movement.
 */
interface GPS {
    void updateLocation(String location);
    String getCurrentLocation();
}

/* * renamed the base class to 'TransportVehicle' to be more unique.
 * it uses encapsulation to protect the ratePerKm and driver details.
 */
abstract class TransportVehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public TransportVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Standby";
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    // abstract method for specialized billing
    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Driver: " + driverName + " | ID: " + vehicleId);
        System.out.println("Location: " + getCurrentLocation());
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
}

/* * 'Sedan' replaces 'Car'.
 * includes a premium base fee for comfort.
 */
class Sedan extends TransportVehicle {
    public Sedan(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        double comfortFee = 50.0;
        return (getRatePerKm() * distance) + comfortFee;
    }
}

/* * 'Motorcycle' replaces 'Bike'.
 * most economical option for quick transit.
 */
class Motorcycle extends TransportVehicle {
    public Motorcycle(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

/* * 'Rickshaw' replaces 'Auto'.
 */
class Rickshaw extends TransportVehicle {
    public Rickshaw(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        double meterStart = 25.0;
        return (getRatePerKm() * distance) + meterStart;
    }
}

/* * the driver class processes the fleet using the unique class names.
 */
public class RideHaillingApp {
    public static void main(String[] args) {
        ArrayList<TransportVehicle> fleet = new ArrayList<>();

        // using the new class names to avoid naming conflicts
        Sedan lux = new Sedan("SED-99", "Rahul", 18.0);
        Motorcycle express = new Motorcycle("MOTO-44", "Deepak", 7.0);
        Rickshaw local = new Rickshaw("RICK-22", "Khan", 12.0);

        lux.updateLocation("Airport Terminal 1");
        express.updateLocation("Central Station");
        local.updateLocation("Market Square");

        fleet.add(lux);
        fleet.add(express);
        fleet.add(local);

        double distanceKm = 10.0;
        System.out.println("--- Booking Estimate (Distance: " + distanceKm + " km) ---");
        System.out.println("---------------------------------------------------------");

        for (TransportVehicle v : fleet) {
            v.getVehicleDetails();
            System.out.println("Total Fare: ₹" + v.calculateFare(distanceKm));
            System.out.println("---------------------------------------------------------");
        }
    }
}