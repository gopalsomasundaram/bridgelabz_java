package String.Level1;

import java.util.Scanner;
public class DemonstrateStringIndex {
    public void generateException(String text) {
        int invalidIndex = text.length();
        System.out.println("Attempting to access index: " + invalidIndex);

        char ch = text.charAt(invalidIndex);
        System.out.println("This will not print: " + ch);
    }
    public void handleException(String text) {
        try {
            int wayOutIndex = text.length() + 5;
            System.out.println("Attempting to access index: " + wayOutIndex);

            char ch = text.charAt(wayOutIndex);
            System.out.println("Character is: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught an Exception: You tried to access an index that doesn't exist!");
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemonstrateStringIndex demo = new DemonstrateStringIndex();
        System.out.println("Enter a string: ");
        String userInput = scanner.next();
        try {
            demo.generateException(userInput);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Main caught the crash. Moving to handled method...");
        }
        demo.handleException(userInput);
        System.out.println("\nProgram finished execution successfully.");
        scanner.close();
    }
}
