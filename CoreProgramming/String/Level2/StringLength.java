package String.Level2;

import java.util.Scanner;
/*
 * This class calculates the length of a string without using the built-in .length() method.
 * It purposefully triggers a StringIndexOutOfBoundsException to identify the end of the text.
 */
public class StringLength {
    // Method to calculate length by "probing" indices
    public int findCustomLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            //When charAt(count) fails, 'count' equals the length of the string!
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to find its length: ");
        String userInput = scanner.next();
        StringLength obj = new StringLength();
        // 1. Logic via intentional exception
        int customLength = obj.findCustomLength(userInput);
        // 2. Logic via built-in Java method
        int builtInLength = userInput.length();
        System.out.println("Custom length (using exception logic): " + customLength);
        System.out.println("Built-in length (using .length()):     " + builtInLength);
        // Verification
        if (customLength == builtInLength) {
            System.out.println("Success: Both lengths match!");
        } else {
            System.out.println("Error: Lengths do not match.");
        }

        scanner.close();
    }
}
