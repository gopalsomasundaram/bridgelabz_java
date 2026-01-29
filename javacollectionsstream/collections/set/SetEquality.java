/**
 * This program demonstrates how to compare two sets for equality.
 * In Java's Set interface, two sets are considered equal if they
 * have the same size and contain the same elements, as the Set
 * definition naturally disregards element ordering.
 *
 * @author gopal
 */
package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetEquality {

    /**
     * Compares two sets to determine if they are equal.
     * This method leverages the standard equals() implementation
     * which checks for element containment and size.
     *
     * @param set1 The first set of integers.
     * @param set2 The second set of integers to compare against.
     * @return true if the sets contain the same elements, false otherwise.
     */
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        // Base case: if both are null, they are equal
        if (set1 == null && set2 == null) {
            return true;
        }
        // If one is null but the other isn't, they are not equal
        if (set1 == null || set2 == null) {
            return false;
        }

        // The equals method in Sets compares content, not memory address or order
        return set1.equals(set2);
    }

    /**
     * Main method to test equality between different set instances.
     */
    public static void main(String[] args) {
        // Create first set
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));

        // Create second set with different insertion order
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // Check for equality
        boolean result = areSetsEqual(set1, set2);

        // Output result
        // Set1: {1, 2, 3}, Set2: {3, 2, 1} -> Output: true
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Are the sets equal? " + result);
    }
}