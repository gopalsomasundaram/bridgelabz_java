/**
 * This program demonstrates handling common runtime exceptions in Java,
 * specifically focusing on NullPointerException and IndexOutOfBoundsException
 * when working with dynamic collections like ArrayList.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayAtIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initializing the reference to null to demonstrate NullPointerException handling
        ArrayList<Integer> arr = null;

        System.out.println("Enter the array of integers (Enter -1 to stop input):");

        while (true) {
            // Check for integer input before reading
            if (scanner.hasNextInt()) {
                int temp = scanner.nextInt();

                // Termination condition
                if (temp == -1) break;

                // Lazy initialization: create the list only when the first element arrives
                if (arr == null) {
                    arr = new ArrayList<>();
                }

                // Adding elements to the dynamic list
                arr.add(temp);
            } else {
                scanner.next(); // Clear invalid input
            }
        }

        System.out.print("Now enter the Index to get value from: ");

        try {
            // scanner.nextInt() could throw InputMismatchException if not handled
            int index = scanner.nextInt();

            // Potential triggers:
            // 1. NullPointerException if arr was never initialized (no input provided)
            // 2. IndexOutOfBoundsException if index < 0 or index >= arr.size()
            System.out.println("Value at index " + index + " : " + arr.get(index));

        } catch (NullPointerException e) {
            // Caught if the user entered -1 immediately, leaving 'arr' as null
            System.out.println("Error: Array is not initialized! (No data was entered)");

        } catch (IndexOutOfBoundsException e) {
            // Caught if the user asks for a position that doesn't exist in the list
            System.out.println("Error: Index is Invalid! Range is 0 to " + (arr.size() - 1));

        } catch (Exception e) {
            // General safety net for unexpected errors (e.g., InputMismatchException)
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            // Closing the scanner resource to prevent memory leaks
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}