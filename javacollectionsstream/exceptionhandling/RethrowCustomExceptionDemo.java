/**
 * This program demonstrates the pattern of catching a custom exception
 * and rethrowing it with a modified, more descriptive message.
 * This is often used in multi-layered applications to provide
 * better context for errors.
 *
 * @author gopal;
 */
package exceptionhandling;

/**
 * User-defined checked exception class for handling domain-specific errors.
 */
class CustomException extends Exception {
    // Constructor to pass the custom error message to the base Exception class
    CustomException(String message) {
        super(message);
    }
}

public class RethrowCustomExceptionDemo {
    // Static account balance for transaction simulation
    static int balance = 3000;

    /**
     * Validates if a transaction can proceed based on the balance.
     * @param amount The value to be transferred.
     * @throws CustomException if the amount exceeds the current balance.
     */
    public static void processTransaction(int amount) throws CustomException {
        if (amount > balance) {
            // Throwing the base custom exception
            throw new CustomException("Base Error: Insufficient funds.");
        } else {
            System.out.println("Amount transferred successfully.");
            balance -= amount;
        }
    }

    /**
     * Attempts a withdrawal by calling the transaction logic.
     * It catches the original exception and rethrows it with specific context.
     * @param amount The value to withdraw.
     * @throws CustomException A rethrown exception with user-friendly details.
     */
    public static void withdraw(int amount) throws CustomException {
        try {
            // Hardcoded to 4000 to trigger the exception for this demo
            processTransaction(4000);
        } catch (CustomException e) {
            /* * Rethrowing: Instead of passing 'e' directly, we throw a new
             * CustomException with a message that explains the specific failure.
             */
            throw new CustomException("Transaction Failed: The amount requested to transfer is higher than the balance.");
        }
    }

    public static void main(String[] args) {
        try {
            // Initiating the withdrawal process
            withdraw(4000);
        } catch (CustomException e) {
            // This catch block receives the descriptive message from the 'withdraw' method
            System.out.print(e.getMessage());
        }
    }
}