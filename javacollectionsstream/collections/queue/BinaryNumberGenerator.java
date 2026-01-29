/**
 * This program generates the first N binary numbers using a Queue.
 * It follows a pattern where appending "0" and "1" to the current
 * binary string produces the next numbers in the sequence.
 *
 * @author gopal
 */
package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class BinaryNumberGenerator {

    /**
     * Generates a list of binary numbers up to N.
     *
     * @param n The total number of binary strings to generate.
     * @return A list containing the binary representations.
     */
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Start with the first binary number
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            // Generate next numbers by appending 0 and 1
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("First " + n + " binary numbers: " + generateBinary(n));
    }
}