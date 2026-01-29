/**
 * This program implements an Insurance Policy Management System using various
 * Set implementations (HashSet, LinkedHashSet, TreeSet) to demonstrate
 * uniqueness, ordering, and performance characteristics.
 *
 * @author gopal
 */
package collections.set;

import java.time.LocalDate;
import java.util.*;

/**
 * Represents an Insurance Policy. Implements Comparable to allow
 * sorting within a TreeSet based on the expiry date.
 */
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String holderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    /**
     * Overridden to ensure uniqueness is defined by the Policy Number.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    /**
     * Defines natural ordering for TreeSet: Primary sort by Expiry Date,
     * Secondary sort by Policy Number to prevent data loss for same-day expiries.
     */
    @Override
    public int compareTo(Policy other) {
        int dateCompare = this.expiryDate.compareTo(other.expiryDate);
        return (dateCompare != 0) ? dateCompare : this.policyNumber.compareTo(other.policyNumber);
    }

    @Override
    public String toString() {
        return String.format("%-6s | %-10s | %-12s | %-10s | $%.2f",
                policyNumber, holderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsuranceManagementSystem {

    /**
     * Main method to demonstrate performance, storage, and retrieval
     * across different Set types.
     */
    public static void main(String[] args) {
        // HashSet for quick O(1) lookups
        Set<Policy> hashSet = new HashSet<>();
        // LinkedHashSet to maintain the order of insertion
        Set<Policy> linkedSet = new LinkedHashSet<>();
        // TreeSet to maintain policies sorted by expiry date
        Set<Policy> treeSet = new TreeSet<>();

        // Creating sample policy data
        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(45), "Auto", 300.0);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(15), "Health", 550.0);
        Policy p4 = new Policy("P001", "Duplicate", LocalDate.now().plusDays(5), "Life", 1000.0);

        // 1. Store Unique Policies
        List<Policy> data = Arrays.asList(p1, p2, p3, p4);
        for (Policy p : data) {
            hashSet.add(p);
            linkedSet.add(p);
            treeSet.add(p);
        }

        // 2. Retrieve and Display Policies
        System.out.println("--- All Unique Policies (TreeSet - Sorted by Expiry) ---");
        for (Policy p : treeSet) System.out.println(p);

        System.out.println("\n--- Policies Expiring Soon (Next 30 Days) ---");
        LocalDate thirtyDaysLater = LocalDate.now().plusDays(30);
        for (Policy p : treeSet) {
            if (p.getExpiryDate().isBefore(thirtyDaysLater)) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- Policies with Coverage Type: Health ---");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase("Health")) {
                System.out.println(p);
            }
        }

        // 3. Performance Comparison Summary
        printPerformanceComparison();
    }

    /**
     * Static method to print the performance characteristics of the sets used.
     */
    public static void printPerformanceComparison() {
        System.out.println("\n--- Performance Comparison ---");
        System.out.println("HashSet:       O(1) search/add. Best for high-speed lookups.");
        System.out.println("LinkedHashSet: O(1) search/add. Predictable iteration (insertion order).");
        System.out.println("TreeSet:       O(log n) search/add. Automatically keeps data sorted.");
    }
}