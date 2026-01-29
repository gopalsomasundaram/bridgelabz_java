/**
 * This program demonstrates how to find the Nth element from the end of a
 * LinkedList without explicitly calculating the list size. It utilizes the
 * two-pointer approach for optimal traversal.
 *
 * @author gopal
 */
package collections.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthElementFromEnd {

    /**
     * Finds the Nth element from the end using two pointers.
     * The first pointer moves N steps ahead. Then, both pointers move
     * at the same speed until the first pointer reaches the end.
     *
     * @param list The LinkedList to search through.
     * @param n The position from the end (1-indexed).
     * @return The element at the Nth position from the end, or null if out of bounds.
     */
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list == null || n <= 0 || n > list.size()) {
            return null;
        }

        // We use ListIterators to act as our two pointers
        ListIterator<String> mainPtr = list.listIterator();
        ListIterator<String> referencePtr = list.listIterator();

        // Move the reference pointer N steps forward
        for (int i = 0; i < n; i++) {
            if (referencePtr.hasNext()) {
                referencePtr.next();
            } else {
                return null; // N is larger than the list size
            }
        }

        // Move both pointers until reference pointer reaches the end
        while (referencePtr.hasNext()) {
            mainPtr.next();
            referencePtr.next();
        }

        // The main pointer is now at the Nth element from the end
        return mainPtr.next();
    }

    /**
     * Main method to test the Nth element retrieval logic.
     */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        String result = findNthFromEnd(list, n);

        // Input: [A, B, C, D, E], N=2 -> Output: D
        System.out.println("List: " + list);
        System.out.println(n + "nd element from end: " + result);
    }
}