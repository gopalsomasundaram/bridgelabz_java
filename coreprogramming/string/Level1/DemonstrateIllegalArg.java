package string.Level1;

import java.util.Scanner;
/*
 * This class demonstrates IllegalArgumentException.
 * It shows how to manually throw and catch exceptions when
 * provided arguments violate the logic of a method.
 */
public class DemonstrateIllegalArg {
    // This method triggers a StringIndexOutOfBoundsException (a type of RuntimeException)
    // because start > end in the built-in substring method.
    public void generateException(String text) {
        int start = 10;
        int end = 5;
        System.out.println("Attempting substring with start (" + start + ") > end (" + end + ")");
        // Java's substring will throw an exception here because logic is violated
        String result = text.substring(start, end);
        System.out.println("Result: " + result);
    }
    // This method demonstrates how to manually validate arguments
    public void handleException(String text) {
        try {
            int start = 5;
            int end = 2;

            if (start > end) {
                //Manually throwing the exception with a custom message
                throw new IllegalArgumentException("Start index cannot be greater than end index");
            }

            String result = text.substring(start, end);
            System.out.println("Result: " + result);

        } catch (IllegalArgumentException e) {
            //Handling the custom error message
            System.out.println("Caught Specific Exception: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught Generic RuntimeException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemonstrateIllegalArg demo = new DemonstrateIllegalArg();
        System.out.print("Enter a string: ");
        String userInput = scanner.next();

        // Catching the built-in exception thrown by generateException
        try {
            demo.generateException(userInput);
        } catch (Exception e) {
            System.out.println("The program would have stopped here, but main caught the: " + e);
        }

        // Running the version with manual validation and internal handling
        demo.handleException(userInput);
        System.out.println("\nProgram finished successfully.");
        scanner.close();
    }
}
