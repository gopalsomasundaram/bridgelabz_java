/**
 * This program performs a basic division operation and demonstrates multiple
 * catch blocks to handle specific runtime exceptions. It distinguishes between
 * mathematical errors and user input errors.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideNumbers {
    public static void main(String[] args) {
        // Initializing Scanner to read from standard input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Two numbers to be divided");
        System.out.print("Numerator: ");

        try {
            // Potential InputMismatchException if user enters non-integer data
            int num = scanner.nextInt();

            System.out.print("Denominator: ");
            int denom = scanner.nextInt();

            // Potential ArithmeticException if denom is zero
            int result = num / denom;
            System.out.print("Result: " + result);

        } catch (InputMismatchException e) {
            // Specifically handles cases where a String or double is provided instead of int
            System.out.print("Error: non-Integer input given when int input expected.");

        } catch (ArithmeticException e) {
            // Specifically handles mathematical impossibility (division by zero)
            System.out.print("Error: Division by 0 is not allowed.");

        } catch (Exception e) {
            // General catch block for any other unforeseen runtime exceptions
            System.out.print("An error occurred: " + e.getMessage());

        } finally {
            // Resource cleanup: closing the scanner to release system resources
            scanner.close();
        }
    }
}