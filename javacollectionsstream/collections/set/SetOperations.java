/**
 * This program demonstrates basic set operations: Union and Intersection.
 * Union combines all unique elements from both sets, while Intersection
 * retrieves only the elements that are common to both.
 *
 * @author gopal
 */
package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetOperations {

    /**
     * Computes the union of two sets.
     *
     * @param set1 The first set.
     * @param set2 The second set.
     * @return A new set containing all elements from both sets.
     */
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    /**
     * Computes the intersection of two sets.
     *
     * @param set1 The first set.
     * @param set2 The second set.
     * @return A new set containing only common elements.
     */
    public static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Union: " + getUnion(s1, s2));
        System.out.println("Intersection: " + getIntersection(s1, s2));
    }
}