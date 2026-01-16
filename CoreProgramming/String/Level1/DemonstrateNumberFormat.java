package String.Level1;

import java.util.Scanner;
public class DemonstrateNumberFormat {
    public void generateException(String text) {
        System.out.println("Attempting to convert '" + text + "' to an integer...");
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }
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
        try {
            demo.generateException(userInput);
        } catch (NumberFormatException e) {
            System.out.println("The program would have crashed here. Main caught the error.");
        }
        demo.handleException(userInput);
        System.out.println("\nProgram execution finished.");
        scanner.close();
    }
}
