package string.Level1;

import java.util.Scanner;
/*
 * This class demonstrates NumberFormatException.
 * It shows how the program fails when parsing non-numeric strings
 * and how to catch the error using try-catch blocks.
 */
public class DemonstrateNumberFormat {
    // This method will crash if 'text' contains letters or symbols
    public void generateException(String text) {
        System.out.println("Attempting to convert '" + text + "' to an integer...");
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }
    // This method uses a try-catch block to stay "alive" during an error
    public void handleException(String text) {
        try {
            System.out.println("Trying to parse: " + text);
            int number = Integer.parseInt(text);
            System.out.println("Success! The number is: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught Specific Exception: The input is not a valid integer.");
        } catch (RuntimeException e) {
            System.out.println("Caught Generic RuntimeException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemonstrateNumberFormat demo = new DemonstrateNumberFormat();
        System.out.print("Enter some text (try entering alphabets to cause an error): ");
        String userInput = scanner.next();
        // 1. Handling the crash from generateException
        try {
            demo.generateException(userInput);
        } catch (NumberFormatException e) {
            System.out.println("The program would have crashed here. Main caught the error.");
        }
        // 2. Running the method with its own internal handling
        demo.handleException(userInput);
        System.out.println("\nProgram execution finished.");
        scanner.close();
    }
}
