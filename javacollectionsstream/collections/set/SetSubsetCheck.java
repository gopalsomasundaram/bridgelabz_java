/**
 * This program checks if one set is a subset of another set.
 * A set is a subset if all its elements are contained within
 * the parent set.
 *
 * @author gopal
 */
package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetSubsetCheck {

    /**
     * Verifies if the first set is a subset of the second set.
     *
     * @param sub The potential subset.
     * @param parent The set to check against.
     * @return true if 'sub' is a subset of 'parent', false otherwise.
     */
    public static boolean isSubset(Set<Integer> sub, Set<Integer> parent) {
        // containsAll checks if every element in 'sub' exists in 'parent'
        return parent.containsAll(sub);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Is set1 a subset of set2? " + isSubset(set1, set2));
    }
}