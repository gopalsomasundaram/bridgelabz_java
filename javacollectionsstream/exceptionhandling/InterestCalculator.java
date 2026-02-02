/**
 * This program calculates simple interest based on user input for amount,
 * rate, and duration. It demonstrates the use of IllegalArgumentException
 * to validate that input values are within logical bounds.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.Scanner;

public class InterestCalculator {

    /**
     * Calculates the interest using the formula: Amount * Rate * Years.
     * * @param amount The principal amount.
     * @param rate   The interest rate.
     * @param year   The duration in years.
     * @return The calculated interest.
     * @throws IllegalArgumentException (Unchecked) if amount or rate is negative.
     */
    public static double calculateInterest(double amount, double rate, int year) throws IllegalArgumentException {
        // Validation Rule: Financial inputs like principal and rate cannot be negative.
        if (amount < 0 || rate < 0) {
            // Throwing a standard runtime exception with a descriptive message.
            throw new IllegalArgumentException("Invalid input: Principal amount and interest rate must be positive values.");
        }

        // Logical check: While interest can be 0, negative years are typically invalid in this context.
        if (year < 0) {
            throw new IllegalArgumentException("Invalid input: Duration cannot be negative.");
        }

        return (amount * rate * year);
    }

    public static void main(String[] args) {
        // Using try-with-resources for the Scanner to ensure automatic closure.
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter the number of years: ");
            int years = scanner.nextInt();

            // Attempt to calculate and display the result.
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            // Handles the case where the business logic rules in calculateInterest were violated.
            System.out.println("Validation Error: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            // Handles the case where the user enters text instead of a number.
            System.out.println("Input Error: Please provide valid numerical values.");

        } catch (Exception e) {
            // Catch-all for any other unforeseen exceptions.
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}