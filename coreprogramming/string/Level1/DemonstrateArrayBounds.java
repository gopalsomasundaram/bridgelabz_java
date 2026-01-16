package string.Level1;
import java.util.Scanner;
/*
 * This class demonstrates how Java handles array boundary errors.
 * It shows both a program crash (without local handling) and
 * a graceful recovery (using try-catch).
 */
public class DemonstrateArrayBounds {
    // This method will cause the program to "throw" an exception
    public void generateException(String[] names) {
        System.out.println("\n--- Generating ArrayIndexOutOfBoundsException ---");
        int invalidIndex = names.length;
        System.out.println("Attempting to access index: " + invalidIndex);
        // The JVM stops execution here and searches for a 'catch' block
        String name = names[invalidIndex];
        System.out.println("This will not print: " + name);
    }
    // This method catches the error internally so the program keeps running
    public void handleException(String[] names) {
        try {
            int wayOutIndex = 100;
            System.out.println("Attempting to access index: " + wayOutIndex);

            String name = names[wayOutIndex];
            System.out.println("Name found: " + name);

        } catch (ArrayIndexOutOfBoundsException e) {
            // This code runs ONLY if the specific error occurs
            System.out.println("Caught Specific Exception: Index is outside the array limits.");
        } catch (RuntimeException e) {
            // Catch-all for other runtime errors
            System.out.println("Caught Generic RuntimeException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemonstrateArrayBounds demo = new DemonstrateArrayBounds();
        System.out.println("How many names do you want to enter?");
        int size = scanner.nextInt();
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }

        // Execution Scenario 1: The error is caught in main
        try {
            demo.generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The program would have crashed, but main caught the error.");
        }
        // Execution Scenario 2: The error is handled inside the method
        demo.handleException(names);

        System.out.println("\nProgram execution finished successfully.");
        scanner.close();
    }
}
