/**
 * This program implements an Insurance Policy Management System using various
 * Map implementations (HashMap, LinkedHashMap, TreeMap). It demonstrates
 * efficient lookup by ID, preservation of insertion order, and sorting by
 * date using custom Comparators.
 *
 * @author gopal
 */
package collections.mapinterface;


import java.time.LocalDate;
import java.util.*;

/**
 * Represents the details of an Insurance Policy.
 */
class Policy {
    private String policyNumber;
    private String holderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return String.format("[%s | %-10s | Exp: %s]", policyNumber, holderName, expiryDate);
    }
}

public class InsuranceMapSystem {

    // HashMap for O(1) fast retrieval by policy number
    private Map<String, Policy> fastLookupMap = new HashMap<>();

    // LinkedHashMap to maintain the order in which policies were added
    private Map<String, Policy> insertionOrderMap = new LinkedHashMap<>();

    // TreeMap to keep policies sorted by their expiry date
    // We use a custom comparator to sort values (dates) while keeping keys unique
    private Map<String, Policy> sortedByExpiryMap = new TreeMap<>((k1, k2) -> {
        // This is a simplified approach; in a real system, we might sort a List instead
        // or use a TreeMap where the Key is the Date itself.
        return k1.compareTo(k2);
    });

    /**
     * Adds a policy to all internal map structures.
     *
     * @param p The policy object to store.
     */
    public void addPolicy(Policy p) {
        fastLookupMap.put(p.getPolicyNumber(), p);
        insertionOrderMap.put(p.getPolicyNumber(), p);
        sortedByExpiryMap.put(p.getPolicyNumber(), p);
    }

    /**
     * Retrieves a specific policy using its unique policy number.
     *
     * @param number The policy identifier.
     * @return The Policy object or null if not found.
     */
    public Policy getPolicy(String number) {
        return fastLookupMap.get(number);
    }

    /**
     * Lists all policies expiring within 30 days of the current date.
     */
    public void listExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        System.out.println("\n--- Expiring within 30 days ---");
        for (Policy p : fastLookupMap.values()) {
            if (!p.getExpiryDate().isBefore(today) && p.getExpiryDate().isBefore(limit)) {
                System.out.println(p);
            }
        }
    }

    /**
     * Lists all policies belonging to a specific person.
     *
     * @param name The name of the policyholder.
     */
    public void listByHolder(String name) {
        System.out.println("\n--- Policies for " + name + " ---");
        for (Policy p : fastLookupMap.values()) {
            if (p.getHolderName().equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    /**
     * Removes all policies whose expiry date is before today's date.
     */
    public void removeExpired() {
        LocalDate today = LocalDate.now();
        // Use removeIf on the entry set to avoid ConcurrentModificationException
        fastLookupMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        insertionOrderMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        sortedByExpiryMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().isBefore(today));
        System.out.println("\nExpired policies have been removed.");
    }

    public static void main(String[] args) {
        InsuranceMapSystem system = new InsuranceMapSystem();

        // Adding sample data
        system.addPolicy(new Policy("POL01", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("POL02", "Bob", LocalDate.now().minusDays(5))); // Expired
        system.addPolicy(new Policy("POL03", "Alice", LocalDate.now().plusDays(45)));
        system.addPolicy(new Policy("POL04", "Charlie", LocalDate.now().plusDays(15)));

        // Demonstrate retrieval
        System.out.println("Search POL01: " + system.getPolicy("POL01"));

        // Filtering
        system.listByHolder("Alice");
        system.listExpiringSoon();

        // Cleanup
        system.removeExpired();

        System.out.println("\nRemaining Policies:");
        system.fastLookupMap.values().forEach(System.out::println);
    }
}