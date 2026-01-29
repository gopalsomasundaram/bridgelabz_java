/**
 * This program calculates the symmetric difference between two sets.
 * The symmetric difference consists of elements present in either
 * of the sets, but not in their intersection.
 *
 * @author gopal
 */
package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetSymmetricDifference {

    /**
     * Finds elements present in either set but not in both.
     * Logic: (Union) minus (Intersection).
     *
     * @param set1 The first set.
     * @param set2 The second set.
     * @return A set representing the symmetric difference.
     */
    public static Set<Integer> getSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        union.removeAll(intersection);
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + getSymmetricDifference(s1, s2));
    }
}