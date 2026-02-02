/**
 * This program demonstrates the use of multiple catch blocks to handle
 * different types of RuntimeExceptions that can occur during a single
 * operation involving array access and mathematical division.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.ArrayList;
import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        // Initialize Scanner for console input
        Scanner scanner = new Scanner(System.in);

        // Initializing the list reference to null to showcase NullPointerException handling
        ArrayList<Integer> arr = null;

        System.out.println("Enter the array of integers (Enter -1 to stop input):");

        while (true) {
            // Check if input is an integer to avoid InputMismatchException
            if (scanner.hasNextInt()) {
                int temp = scanner.nextInt();

                // Break condition for user input
                if (temp == -1) break;

                // Lazy initialization of the ArrayList
                if (arr == null) {
                    arr = new ArrayList<>();
                }

                // Adding the element directly to the existing list
                arr.add(temp);
            } else {
                scanner.next(); // Clear buffer for invalid input
            }
        }

        // Potential for error if user enters non-integers here
        System.out.print("Enter the index of dividend: ");
        int index = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // One try block can have multiple catch blocks to handle specific risks
        try {
            /*
             * Three distinct risks in this single line:
             * 1. NullPointerException: if 'arr' was never initialized (no input provided).
             * 2. IndexOutOfBoundsException: if 'index' is not within list bounds.
             * 3. ArithmeticException: if 'divisor' is zero.
             */
            int result = arr.get(index) / divisor;
            System.out.println("Result of division: " + result);

        } catch (IndexOutOfBoundsException e) {
            // Caught if the user requests an index that does not exist
            System.out.print("Error: Invalid array index!");

        } catch (ArithmeticException e) {
            // Caught if the mathematical operation involves division by zero
            System.out.print("Error: Cannot divide by zero!");

        } catch (NullPointerException e) {
            // Caught if no integers were entered before -1, leaving the list null
            System.out.print("Error: The array was never initialized. " + e.getMessage());

        } catch (Exception e) {
            // Safety net for any other unforeseen runtime exceptions
            System.out.print("An unexpected error occurred: " + e.getMessage());

        } finally {
            // Closing resource as per best practices established in your previous programs
            scanner.close();
            System.out.println("\nScanner closed. Resource released.");
        }
    }
}