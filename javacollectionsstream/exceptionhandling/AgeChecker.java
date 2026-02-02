/**
 * This program demonstrates custom exception handling in Java.
 * It defines a user-defined checked exception (InvalidAgeException)
 * to enforce business logic rules regarding age requirements.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.Scanner;

/**
 * Custom exception class that extends Exception.
 * Extending Exception makes this a "Checked Exception," meaning
 * the compiler will force us to handle or declare it.
 */
class InvalidAgeException extends Exception {
    // Constructor to pass the error message to the parent Exception class
    InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeChecker {

    /**
     * Validates the provided age against the minimum requirement.
     * * @param age The age to be validated.
     * @throws InvalidAgeException if age is less than 18.
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Manually triggering the custom exception
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted");
        }
    }

    public static void main(String[] args) {
        // Scanner is used for simple console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");

        try {
            int age = scanner.nextInt();
            // Call the method that might throw our custom checked exception
            validateAge(age);

        } catch (InvalidAgeException e) {
            // Specific catch block for our custom business logic error
            System.out.println("Validation Error: " + e.getMessage());

        } catch (Exception e) {
            // Generic catch block for other errors, such as InputMismatchException
            // if the user enters text instead of a number.
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Best practice: Close the scanner resource
            scanner.close();
        }
    }
}