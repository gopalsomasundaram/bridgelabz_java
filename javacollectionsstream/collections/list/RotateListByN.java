/**
 * This program demonstrates list manipulation by rotating elements.
 * It shifts the first 'n' elements of a list to the end, effectively
 * performing a left rotation. The implementation uses a temporary
 * list to ensure the original data remains immutable.
 *
 * @author gopal
 */
package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateListByN {

    /**
     * Rotates a list to the left by n positions.
     * The method takes the first element and moves it to the end of the
     * list, repeating this process 'n' times.
     *
     * @param arr The original list of integers to be rotated.
     * @param n   The number of positions to rotate the list.
     * @return    A new List containing the rotated elements.
     */
    public static List<Integer> rotateList(List<Integer> arr, int n) {
        // Create a copy of the input list to avoid modifying the original source
        List<Integer> result = new ArrayList<>(arr);

        // Perform the rotation n times
        for (int i = 0; i < n; ++i) {
            // Retrieve the current first element
            int temp = result.getFirst();
            // Append the first element to the end of the list
            result.add(temp);
            // Remove the original first element to complete the shift
            result.removeFirst();
        }
        return result;
    }

    /**
     * Main method to demonstrate the rotation logic with a sample dataset.
     */
    public static void main(String[] args) {
        // Initialize a fixed-size list for testing
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // Define rotation count
        int rotationCount = 3;

        // Execute and print the result
        System.out.println("Original List: " + arr);
        System.out.println("Rotated List (" + rotationCount + "): " + rotateList(arr, rotationCount));
    }
}