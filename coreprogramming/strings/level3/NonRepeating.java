package strings.level3;

import java.util.Scanner;
/*
 * This class identifies the first character in a string that appears exactly once.
 * It uses a frequency array (hashing) for O(N) time complexity.
 */
public class NonRepeating {
    // Logic: Identify the first character with a frequency count of exactly 1
    public char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        //Scan the original string again to find the first char with count 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        // Return null character if no unique character exists
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NonRepeating obj = new NonRepeating();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input is empty.");
        } else {
            char result = obj.findFirstNonRepeating(input);

            if (result != '\0') {
                System.out.println("The first non-repeating character is: '" + result + "'");
            } else {
                System.out.println("All characters in the string are repeating.");
            }
        }

        scanner.close();
    }
}
