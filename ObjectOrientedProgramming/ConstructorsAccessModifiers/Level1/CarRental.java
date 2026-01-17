package ConstructorsAccessModifiers.Level1;
/*
 * This class models a Car Rental system using overloaded constructors.
 * It ensures the total cost is automatically calculated upon object creation.
 */
public class CarRental {
    //Attributes
    String customerName;
    String carModel;
    int rentalDays;
    int costPerDay;
    int totalCost;

    // Default constructor
    // Allows for custom rental agreements.
    CarRental() {
        customerName = "Customer";
        carModel = "Hatchback";
        rentalDays = 1;
        costPerDay = 1000;
        calculateTotalCost();
    }

    // Parameterized constructor
    CarRental(String c, String m, int d, int rate) {
        customerName = c;
        carModel = m;
        rentalDays = d;
        costPerDay = rate;
        calculateTotalCost();
    }
    //Helper Method
    void calculateTotalCost() {
        totalCost = rentalDays * costPerDay;
    }

    void displayData() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model    : " + carModel);
        System.out.println("Rental Days  : " + rentalDays);
        System.out.println("Total Cost   : " + totalCost);
    }

    public static void main(String[] args) {

        // Creates a Hatchback for 1 day at 1000
        CarRental r1 = new CarRental(); // default
        r1.displayData();
        System.out.println();

        // Creates an SUV for 5 days at 2000
        CarRental r2 = new CarRental("Amit", "SUV", 5, 2000); // parameterized
        r2.displayData();
    }
}
