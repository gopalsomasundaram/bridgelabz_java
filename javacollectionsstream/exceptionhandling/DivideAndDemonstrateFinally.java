/**
 * This program demonstrates the behavior of the 'finally' block in Java.
 * It performs a division operation and ensures that the scanner resource
 * is closed and a final message is printed, regardless of whether an
 * ArithmeticException or any other exception is thrown.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.Scanner;

public class DivideAndDemonstrateFinally {
    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denom = scanner.nextInt();

            // This operation will throw ArithmeticException if denom is 0
            int result = num / denom;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Specific handling for mathematical errors like division by zero
            System.out.println("Error: Division by 0 Attempted!");

        } catch (Exception e) {
            // Safety net for other errors (e.g., InputMismatchException if text is entered)
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            /*
             * The finally block is the "guaranteed" execution zone.
             * It is the ideal place for cleanup code, such as closing resources.
             */
            System.out.println("\n--- Entering Finally Block ---");
            scanner.close();
            System.out.println("Scanner resource has been safely closed.");
            System.out.println("Execution of the try-catch-finally sequence is complete.");
        }
    }
}