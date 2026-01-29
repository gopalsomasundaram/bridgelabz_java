/**
 * This program groups Employee objects by their department using a Map.
 * It demonstrates how to categorize list data into a map-based structure.
 *
 * @author gopal
 */
package collections.mapinterface;


import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() { return name; }
}

public class EmployeeGrouper {

    /**
     * Groups a list of employees by their department name.
     *
     * @param employees The list of employees to group.
     * @return A map where keys are departments and values are lists of employees.
     */
    public static Map<String, List<Employee>> groupByDept(List<Employee> employees) {
        Map<String, List<Employee>> groupMap = new HashMap<>();

        for (Employee e : employees) {
            groupMap.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }
        return groupMap;
    }

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = groupByDept(list);
        System.out.println("Grouped Employees: " + grouped);
    }
}