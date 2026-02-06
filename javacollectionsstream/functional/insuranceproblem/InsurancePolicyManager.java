/**
 * This Program implements a management system for Insurance Policies.
 * It uses Java 8 Streams and Lambdas to filter, sort, group, and calculate
 * metrics across a collection of policy objects.
 * * @author gopal
 */
package functional.insuranceproblem;

import java.util.*;
import java.util.stream.Collectors;

class Policy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }
    public String getPolicyNumber() { return policyNumber; }

    @Override
    public String toString() {
        return String.format("Policy[No: %s, Name: %s, Premium: $%.2f]",
                policyNumber, holderName, premiumAmount);
    }
}

public class InsurancePolicyManager {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P001", "Alice Smith", 1500.0),
                new Policy("P002", "Bob Johnson", 900.0),
                new Policy("P003", "Charlie Smith", 2500.0),
                new Policy("P004", "David Miller", 1100.0),
                new Policy("P005", "Eve Adams", 1800.0)
        );

        // 1. Filter Policies by Premium Amount > $1,200
        List<Policy> highPremium = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());

        // 2. Sort Policies by Holder Name
        policies.sort((p1, p2) -> p1.getHolderName().compareTo(p2.getHolderName()));

        // 3. Compute Total Premium
        double totalPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();

        // 4. Print Policy Details formatted
        System.out.println("--- All Policies ---");
        policies.forEach(p -> System.out.println(p));

        // 5. Filter Policies between $1,000 and $2,000
        List<Policy> rangePolicies = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());

        // 6. Find Policy with Highest Premium
        Optional<Policy> maxPolicy = policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount));

        // 7. Group Policies by Holder Name Initial
        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        // 8. Compute Average Premium
        double avgPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .average()
                .orElse(0.0);

        // 9. Sort by Premium Ascending and Print
        System.out.println("\n--- Sorted by Premium ---");
        policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .forEach(System.out::println);

        // 10. Check if any policy exceeds $2,000
        boolean hasExpensivePolicy = policies.stream().anyMatch(p -> p.getPremiumAmount() > 2000);

        // 11. Count Policies for Each Premium Range
        long countLow = policies.stream().filter(p -> p.getPremiumAmount() <= 1000).count();
        long countMid = policies.stream().filter(p -> p.getPremiumAmount() > 1000 && p.getPremiumAmount() <= 2000).count();
        long countHigh = policies.stream().filter(p -> p.getPremiumAmount() > 2000).count();

        // 12. Extract Unique Holder Names
        List<String> uniqueNames = policies.stream()
                .map(Policy::getHolderName)
                .distinct()
                .collect(Collectors.toList());

        // 13. Find Policies by Holder Name Substring (e.g., "Smith")
        List<Policy> smiths = policies.stream()
                .filter(p -> p.getHolderName().contains("Smith"))
                .collect(Collectors.toList());

        // 14. Map of Policy Numbers to Premium Amounts
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));

        System.out.println("\nSummary: Total Premium: " + totalPremium + " | Average: " + avgPremium);
    }
}