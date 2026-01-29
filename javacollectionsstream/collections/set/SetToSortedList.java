/**
 * This program demonstrates how to convert an unordered HashSet
 * into a sorted ArrayList. This is useful when you need to maintain
 * uniqueness during collection but require order for output.
 *
 * @author gopal
 */
package collections.set;

import java.util.*;

public class SetToSortedList {

    /**
     * Converts a set to a list and sorts it in ascending order.
     *
     * @param set The HashSet to be converted.
     * @return A List containing sorted elements.
     */
    public static List<Integer> convertAndSort(Set<Integer> set) {
        // Create a list from the set elements
        List<Integer> list = new ArrayList<>(set);

        // Use the Collections utility to sort the list
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertAndSort(set));
    }
}