package ObjectModelling;
import java.util.ArrayList;
/* this class represents the Employee.
in this composition model, an Employee is a part of a Department.
*/
class Employee {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/* this class represents the Department.
it 'owns' its employees. if a department is removed, 
the employees within it are also removed from the system.
*/
class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    // method to add an employee directly to the department
    public void addEmployee(String empName) {
        Employee newEmp = new Employee(empName);
        employees.add(newEmp);
    }

    public void displayDepartment() {
        System.out.println("  Department: " + deptName);
        for (Employee e : employees) {
            System.out.println("    - Employee: " + e.getName());
        }
    }
}

/* this class represents the Company (The Parent).
it encapsulates the departments. the composition is achieved by 
instantiating Departments strictly within the Company's methods.
*/
class Company {
    private String companyName;
    private ArrayList<Department> departments;

    Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    /* composition logic: the Department is created INSIDE the Company.
    this ensures the Department cannot exist without a Company.
    */
    public void createDepartment(String deptName, String[] empNames) {
        Department newDept = new Department(deptName);
        for (String name : empNames) {
            newDept.addEmployee(name);
        }
        departments.add(newDept);
    }

    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.displayDepartment();
        }
    }
}

/* the driver class demonstrates the lifecycle of the composition.
*/
public class CompanyComposition{
    public static void main(String[] args) {
        // creating the parent object
        Company techCorp = new Company("TechGlobal Industries");

        // creating parts (Departments/Employees) through the parent
        techCorp.createDepartment("Engineering", new String[]{"Alice", "Bob"});
        techCorp.createDepartment("Human Resources", new String[]{"Charlie"});

        techCorp.displayCompany();

        /* in Java, when 'techCorp' is set to null, the garbage collector 
        will eventually remove it. since the Departments and Employees 
        were created inside it and aren't referenced elsewhere, 
        they are deleted as well.
        */
        techCorp = null; 
        System.out.println("Company object set to null. All parts are now unreachable.");
    }
}
