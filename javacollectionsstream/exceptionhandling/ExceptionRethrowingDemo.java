/**
 * This program demonstrates the concept of Rethrowing Exceptions in Java.
 * It shows how a method can catch a specific exception and rethrow it
 * with a more descriptive or customized message to the caller.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.Scanner;

public class ExceptionRethrowingDemo {

    /**
     * Performs basic integer division.
     * @param numerator The number to be divided.
     * @param denominator The number to divide by.
     * @return The result of the division.
     * @throws ArithmeticException if denominator is zero.
     */
    public static int performDivision(int numerator, int denominator) throws ArithmeticException {
        // This is the source of the potential ArithmeticException
        return (numerator / denominator);
    }

    /**
     * Acts as a wrapper for performDivision. It catches the original exception
     * and rethrows a new one with a customized, informative message.
     * * @param numerator The number to be divided.
     * @param denominator The number to divide by.
     * @return The result from the division method.
     * @throws ArithmeticException A rethrown exception with custom context.
     */
    public static int calculate(int numerator, int denominator) throws ArithmeticException {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            // Rethrowing a new exception with a more descriptive message
            // that includes the specific numerator involved.
            throw new ArithmeticException("Custom Error: Attempted to divide " + numerator + " by zero.");
        }
    }

    public static void main(String[] args) {
        // Scanner initialized for potential user input expansion
        Scanner scanner = new Scanner(System.in);

        try {
            // Testing the rethrowing logic with a hardcoded zero denominator
            System.out.println("Result of division: " + calculate(10, 0));

        } catch (ArithmeticException e) {
            // The message printed here is the custom one from the calculate method
            System.out.println("Handled in main: " + e.getMessage());
        } finally {
            // Resource cleanup
            scanner.close();
        }
    }
}