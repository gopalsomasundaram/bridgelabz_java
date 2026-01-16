package String.Level2;

import java.util.Scanner;
public class StringLength {
    public int findCustomLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to find its length: ");
        String userInput = scanner.next();
        StringLength obj = new StringLength();
        int customLength = obj.findCustomLength(userInput);
        int builtInLength = userInput.length();
        System.out.println("Custom length (using exception logic): " + customLength);
        System.out.println("Built-in length (using .length()):     " + builtInLength);
        if (customLength == builtInLength) {
            System.out.println("Success: Both lengths match!");
        } else {
            System.out.println("Error: Lengths do not match.");
        }

        scanner.close();
    }
}
