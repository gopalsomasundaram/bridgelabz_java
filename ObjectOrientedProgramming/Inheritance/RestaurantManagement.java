package Inheritance;

/**
 * the Worker interface defines the mandatory behavior.
 * by implementing this, any class agrees to provide
 * a specific implementation for the performDuties() method.
 */
interface Worker {
    void performDuties();
}

/**
 * this class represents the generic base entity (renamed from Person).
 * it provides the foundational identity attributes for anyone
 * associated with the restaurant system.
 */
class Individual {
    String name;
    int id;

    // constructor to initialize the base identity
    Individual(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // method to display basic identity details
    void displayIdentity() {
        System.out.println("ID: " + id + " | Name: " + name);
    }
}

/**
 * the Chef class demonstrates Hybrid Inheritance.
 * it extends 'Individual' to inherit state and
 * implements 'Worker' to inherit behavior.
 */
class Chef extends Individual implements Worker {
    String cuisineSpecialty;

    Chef(String name, int id, String cuisineSpecialty) {
        /* passing the name and id to the Individual superclass
           to ensure proper initialization.
        */
        super(name, id);
        this.cuisineSpecialty = cuisineSpecialty;
    }

    /* fulfilling the interface contract by providing the
       specific logic for a Chef's duties.
    */
    @Override
    public void performDuties() {
        displayIdentity();
        System.out.println("Role: Chef | Specialty: " + cuisineSpecialty);
        System.out.println("Duty: Designing the menu and preparing gourmet meals.");
        System.out.println("------------------------------------------");
    }
}

/**
 * the Waiter class also utilizes Hybrid Inheritance.
 * it inherits the same base identity but provides a
 * completely different set of duties.
 */
class Waiter extends Individual implements Worker {
    int assignedTableArea;

    Waiter(String name, int id, int assignedTableArea) {
        super(name, id);
        this.assignedTableArea = assignedTableArea;
    }

    @Override
    public void performDuties() {
        displayIdentity();
        System.out.println("Role: Waiter | Assigned Area: Zone " + assignedTableArea);
        System.out.println("Duty: Managing guest orders and coordinating table service.");
        System.out.println("------------------------------------------");
    }
}

/**
 * the driver class demonstrates how the renamed hierarchy
 * operates through polymorphism with interfaces.
 */
public class RestaurantManagement{
    public static void main(String[] args) {
        // creating instances of the subclasses
        Chef headChef = new Chef("Marco", 201, "Italian");
        Waiter leadWaiter = new Waiter("Sarah", 305, 2);

        System.out.println("--- Restaurant Operations Log ---");

        /* using the interface type to manage a collection
           of different objects that share a common behavior.
        */
        Worker[] staff = {headChef, leadWaiter};

        for (Worker w : staff) {
            w.performDuties();
        }
    }
}