/**
 * This program simulates a basic banking transaction system.
 * It demonstrates the use of custom checked exceptions for business logic
 * (Insufficient Balance) and standard unchecked exceptions for input
 * validation (Illegal Argument).
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.Scanner;

/**
 * Custom checked exception for handling scenarios where a withdrawal
 * exceeds the available account balance.
 */
class InsufficientBalanceException extends Exception {
    // Passes the error message to the parent Exception class
    InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankTransactionSystem {
    // Initial static balance representing account funds
    static double balance = 45000;

    /**
     * Processes a withdrawal request.
     * * @param amount The value to be withdrawn.
     * @throws IllegalArgumentException (Unchecked) if the amount is negative.
     * @throws InsufficientBalanceException (Checked) if amount exceeds balance.
     */
    public static void withdraw(double amount) throws IllegalArgumentException, InsufficientBalanceException {
        // Business Rule: Cannot withdraw more than what is available
        if (amount > balance) {
            throw new InsufficientBalanceException("Error: Insufficient balance! Current balance: " + balance);
        }

        // Validation Rule: Withdrawal amount must be a positive number
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Invalid Amount. You cannot withdraw a negative value.");
        }

        // Updating the balance after successful validation
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the amount to be withdrawn: ");

            // Standard console input for the withdrawal amount
            if (scanner.hasNextDouble()) {
                double amt = scanner.nextDouble();
                withdraw(amt);
            } else {
                System.out.println("Error: Please enter a valid numerical amount.");
            }

        } catch (InsufficientBalanceException e) {
            // Specific handling for business logic failures
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            // Handling for invalid input parameters
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // General safety net for unexpected errors
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            // Ensuring the scanner resource is closed regardless of success or failure
            scanner.close();
            System.out.println("Transaction session ended.");
        }
    }
}