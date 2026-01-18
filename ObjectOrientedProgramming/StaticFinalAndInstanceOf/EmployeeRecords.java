package StaticFinalAndInstanceOf;
/*
this class is designed to demonstrate:
static - to track the count of employees and the shared company identity
final - to ensure the employee ID remains constant and unique
this - to handle the assignment of values during the object initialization phase
*/
class Employee {
    // static members
    static String companyName = "Global Tech Solutions";
    static int totalEmployees = 0;

    // instance members
    final int id;
    String name;
    String designation;

    // parameterized constructor
    Employee(int id, String name, String designation) {
        // resolving ambiguity between parameters and instance fields
        this.id = id;
        this.name = name;
        this.designation = designation;
        
        // incrementing global employee count
        totalEmployees++;
    }

    // static method to display current workforce size
    static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }

    // method to display specific employee information
    void displayEmployeeInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println();
    }
}

/*
the main class handles object creation and demonstrates the use of 
the instanceof operator for type checking before accessing data
*/
public class EmployeeRecords{
    public static void main(String[] args) {
        // creating employee objects
        Employee emp1 = new Employee(1001, "Alice Johnson", "Software Engineer");
        Employee emp2 = new Employee(1002, "Bob Smith", "Project Manager");

        // demonstrating the static method
        Employee.displayTotalEmployees();
        System.out.println();

        // using instanceof to verify objects before printing
        Object unknownObject = emp1; // treating employee as a generic object

        if (unknownObject instanceof Employee) {
            System.out.println("Validation Successful: Object is an Employee.");
            // casting back to Employee to call specific methods
            ((Employee) unknownObject).displayEmployeeInfo();
        }

        if (emp2 instanceof Employee) {
            emp2.displayEmployeeInfo();
        }
    }
}