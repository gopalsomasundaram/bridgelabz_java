/**
 * This program demonstrates Object Serialization and Deserialization in Java.
 * It saves a list of Employee objects to a binary file and retrieves them,
 * preserving the object state across different execution instances.
 *
 * @author gopal;
 */
package streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Employee class implements Serializable to allow its instances
 * to be converted into a byte stream.
 */
class Employee implements Serializable {
    // serialVersionUID ensures that the serialized object is compatible
    // with the current class definition during deserialization.
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-10s | Dept: %-12s | Salary: $%.2f",
                id, name, department, salary);
    }
}

public class EmployeeSerializationDemo {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        // Initialize a list with sample employee data
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "Engineering", 85000));
        employeeList.add(new Employee(102, "Bob", "Design", 72000));
        employeeList.add(new Employee(103, "Charlie", "Marketing", 65000));

        // --- STEP 1: SERIALIZATION (Writing to file) ---
        System.out.println("Step 1: Serializing object to " + FILE_NAME + "...");

        // ObjectOutputStream is a filter stream that handles the conversion of objects to bytes
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            // writeObject handles the entire list and its contents automatically
            oos.writeObject(employeeList);
            System.out.println("Successfully saved data.\n");

        } catch (IOException e) {
            System.err.println("IO Error during serialization: " + e.getMessage());
        }

        // --- STEP 2: DESERIALIZATION (Reading from file) ---
        System.out.println("Step 2: Deserializing object from " + FILE_NAME + "...");

        // ObjectInputStream reconstructs the object from the binary file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            // Casting the generic object back to our specific List type
            @SuppressWarnings("unchecked")
            List<Employee> retrievedList = (List<Employee>) ois.readObject();

            System.out.println("Successfully retrieved " + retrievedList.size() + " employees:");
            for (Employee emp : retrievedList) {
                System.out.println(emp);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found! Ensure the serialization step completed.");
        } catch (IOException e) {
            System.err.println("Error reading the object file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // This occurs if the Employee class is missing from the classpath during reading
            System.err.println("The Employee class definition was not found: " + e.getMessage());
        }
    }
}