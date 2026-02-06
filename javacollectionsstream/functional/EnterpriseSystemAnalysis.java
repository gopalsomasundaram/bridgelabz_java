/**
 * This Program handles Enterprise data processing for Employees and Sales.
 * It demonstrates advanced grouping, multi-level aggregation, and custom transformations.
 * * @author gopal
 */
package functional;

import java.util.*;
import java.util.stream.Collectors;

// --- Problem 1 Classes ---
class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id; this.name = name; this.department = department; this.salary = salary;
    }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

// --- Problem 2 Classes ---
class Sale {
    int productId;
    int quantity;
    double price;

    Sale(int productId, int quantity, double price) {
        this.productId = productId; this.quantity = quantity; this.price = price;
    }
}

class ProductSales {
    int productId;
    double totalRevenue;

    ProductSales(int productId, double totalRevenue) {
        this.productId = productId; this.totalRevenue = totalRevenue;
    }
    public double getTotalRevenue() { return totalRevenue; }
    @Override
    public String toString() { return "ID: " + productId + " | Revenue: $" + totalRevenue; }
}

public class EnterpriseSystemAnalysis {
    public static void main(String[] args) {
        // --- Problem 1 Logic ---
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Gopal", "Engineering", 85000),
                new Employee(2, "Amit", "Engineering", 95000),
                new Employee(3, "Rahul", "HR", 60000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        // --- Problem 2 Logic ---
        List<Sale> sales = Arrays.asList(new Sale(101, 15, 100.0), new Sale(102, 5, 50.0), new Sale(103, 20, 200.0));

        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.quantity > 10)
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top Sales: " + topProducts);
    }
}