package strings.level3;

import java.util.Scanner;
/*
 * This class identifies and extracts all unique characters from a string.
 * It manually calculates length and performs a nested-loop duplicate check.
 */
public class UniqueChar {
    // Manual length calculation using the 'Boundary Violation' strategy
    public int findLength(String text) {
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
    //Filters out characters that have appeared earlier in the string
    public char[] findUniqueChars(String text) {
        int len = findLength(text);
        char[] tempArray = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char currentChar = text.charAt(i);
            boolean isDuplicate = false;

            // Inner Loop: Look back at all characters from index 0 to i-1
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            // If the character was never seen before, add it to our unique set
            if (!isDuplicate) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        //Array Trimming
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = tempArray[i];
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniqueChar obj = new UniqueChar();

        System.out.print("Enter a string to find unique characters: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The input string is empty.");
        } else {
            char[] uniqueChars = obj.findUniqueChars(input);
            System.out.println("\n--- Unique Characters Found ---");
            System.out.print("Result: ");
            for (char c : uniqueChars) {
                System.out.print(c + " ");
            }
            System.out.println("\nTotal unique count: " + uniqueChars.length);
        }
        scanner.close();
    }
}
