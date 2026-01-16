package String.Level1;

import java.util.Scanner;
public class DemonstrateIllegalArg {
    public void generateException(String text) {
        int start = 10;
        int end = 5;
        System.out.println("Attempting substring with start (" + start + ") > end (" + end + ")");
        String result = text.substring(start, end);
        System.out.println("Result: " + result);
    }
    public void handleException(String text) {
        try {
            int start = 5;
            int end = 2;

            if (start > end) {
                throw new IllegalArgumentException("Start index cannot be greater than end index");
            }

            String result = text.substring(start, end);
            System.out.println("Result: " + result);

        } catch (IllegalArgumentException e) {
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
        try {
            demo.generateException(userInput);
        } catch (Exception e) {
            System.out.println("The program would have stopped here, but main caught the: " + e);
        }
        demo.handleException(userInput);
        System.out.println("\nProgram finished successfully.");
        scanner.close();
    }
}
