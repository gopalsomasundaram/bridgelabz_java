package Inheritance;

/*
 * This class represents a generic Employee
 * with common attributes and behavior.
 */
class Employee {

    // Name of the employee
    String name;

    // Employee ID
    int id;

    // Employee salary
    double salary;

    // Constructor to initialize employee details
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary);
    }
}

/*
 * This class represents a Manager
 * and extends the Employee class.
 */
class Manager extends Employee {

    // Number of team members managed
    int teamSize;

    // Constructor to initialize manager details
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    // Override method to display manager details
    @Override
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary + " " + teamSize);
    }
}

/*
 * This class represents a Developer
 * and extends the Employee class.
 */
class Developer extends Employee {

    // Primary programming language of the developer
    String programmingLanguage;

    // Constructor to initialize developer details
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Override method to display developer details
    @Override
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary + " " + programmingLanguage);
    }
}

/*
 * This class represents an Intern
 * and extends the Employee class.
 */
class Intern extends Employee {

    // Internship duration in months
    int durationMonths;

    // Constructor to initialize intern details
    Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }

    // Override method to display intern details
    @Override
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary + " " + durationMonths);
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        /* creating individual objects for each subclass.
           notice how each subclass calls the parent constructor
           using the 'super' keyword.
        */
        Manager mgr = new Manager("Alice", 101, 90000.0, 5);
        Developer dev = new Developer("Bob", 102, 75000.0, "Java");
        Intern intern = new Intern("Charlie", 103, 20000.0, 6);

        System.out.println("Displaying Specific Employee Details:");
        System.out.println("------------------------------------");
        mgr.displayDetails();
        dev.displayDetails();
        intern.displayDetails();
        System.out.println();

        /*
           demonstrating Upcasting and Polymorphism:
           we can store different types of employees in an array of type Employee.
           even though the reference is of type 'Employee', Java calls the
           overridden 'displayDetails' method of the actual object type at runtime.
        */
        Employee[] employeeList = {mgr, dev, intern};

        System.out.println("Displaying Details using Polymorphic Array:");
        System.out.println("-----------------------------------------");
        for (Employee emp : employeeList) {
            // checking instance type before processing (as practiced earlier)
            if (emp instanceof Employee) {
                emp.displayDetails();
            }
        }
    }
}
