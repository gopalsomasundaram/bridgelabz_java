/**
 * This program demonstrates manual reversal of list collections in Java.
 * It provides overloaded methods to handle both ArrayList and LinkedList,
 * emphasizing the logic of index-based iteration for reversal without
 * relying on built-in utility methods like Collections.reverse().
 * @author gopal
 */
package collections.list;

import java.util.*;

public class ReverseList {

    /**
     * Reverses an ArrayList of integers by iterating from the end to the beginning.
     * @param arr The original ArrayList to be reversed.
     * @return A new ArrayList containing elements in reverse order.
     */
    public static ArrayList<Integer> reverse(ArrayList<Integer> arr) {
        // Create a new list with initial capacity of the original for efficiency
        ArrayList<Integer> reversedList = new ArrayList<>(arr.size());

        // Loop backwards from the last index to 0
        for (int i = arr.size() - 1; i >= 0; --i) {
            reversedList.add(arr.get(i));
        }
        return reversedList;
    }

    /**
     * Reverses a LinkedList of integers.
     * While the logic remains similar to ArrayList, this handles the LinkedList implementation.
     * @param arr The original LinkedList to be reversed.
     * @return A new LinkedList containing elements in reverse order.
     */
    public static LinkedList<Integer> reverse(LinkedList<Integer> arr) {
        LinkedList<Integer> reversedList = new LinkedList<>();

        // Iterate through the list backwards using indices
        for (int i = arr.size() - 1; i >= 0; --i) {
            reversedList.add(arr.get(i));
        }
        return reversedList;
    }

    /**
     * Main method to execute and test the reversal logic for both
     * ArrayList and LinkedList types.
     */
    public static void main(String[] args) {
        // Initialize ArrayList with predefined values
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Initialize LinkedList and manually add elements
        LinkedList<Integer> ll1 = new LinkedList<>();
        ll1.add(1);
        ll1.add(2);
        ll1.add(3);
        ll1.add(4);
        ll1.add(5);

        // Perform reversal operations
        ArrayList<Integer> reversedArr1 = reverse(arr1);
        LinkedList<Integer> reversedLl1 = reverse(ll1);

        // Output the results to the console
        System.out.println("Reversed LinkedList: " + reversedLl1);
        System.out.println("Reversed ArrayList: " + reversedArr1);
    }
}