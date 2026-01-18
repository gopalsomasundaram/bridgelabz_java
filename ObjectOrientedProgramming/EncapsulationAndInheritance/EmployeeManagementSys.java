package EncapsulationAndInheritance;

import java.util.ArrayList;

/*
the Department interface defines a contract for organizational data.
any class implementing this must handle department assignment.
*/
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

/*
the Employee class is abstract, meaning it cannot be instantiated.
it uses encapsulation to protect sensitive data like salaries.
*/
abstract class Employee implements Department {
    // encapsulation: private fields accessible only through methods
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // constructor to initialize common fields
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // getters and setters for encapsulated fields
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    /* abstract method: forces subclasses to provide specific
       salary calculation logic.
    */
    public abstract double calculateSalary();

    // concrete method: shared logic provided to all subclasses
    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + name);
        System.out.println("Department: " + getDepartmentDetails());
        System.out.println("Final Salary: $" + calculateSalary());
    }

    // interface implementation
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return (department != null) ? department : "Not Assigned";
    }
}

/*
FullTimeEmployee implements calculateSalary based on a fixed
monthly bonus added to the base salary.
*/
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

/*
PartTimeEmployee implements calculateSalary based on hourly rates.
*/
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name, 0); // base salary is 0 as they are paid hourly
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

/*
the driver class demonstrates polymorphism and encapsulation.
*/
public class EmployeeManagementSys {
    public static void main(String[] args) {
        /*
           polymorphism: storing different subclasses in a
           list of abstract 'Employee' references.
        */
        ArrayList<Employee> workforce = new ArrayList<>();

        FullTimeEmployee ft = new FullTimeEmployee(101, "Aayush", 5000, 1000);
        ft.assignDepartment("Engineering");

        PartTimeEmployee pt = new PartTimeEmployee(102, "Sita", 80, 25);
        pt.assignDepartment("Content Design");

        workforce.add(ft);
        workforce.add(pt);

        System.out.println("--- Employee Payroll Report ---");
        for (Employee emp : workforce) {
            emp.displayDetails();
            System.out.println("--------------------------------");
        }
    }
}