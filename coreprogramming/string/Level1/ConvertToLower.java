package string.Level1;

import java.util.Scanner;
/*
 * This class manually converts a string to lowercase by manipulating
 * character ASCII values and validates it against .toLowerCase().
 */
public class ConvertToLower {
    // Method to convert Uppercase to Lowercase manually
    public String customToLowerCase(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Logic: Uppercase 'A'-'Z' have ASCII values 65-90
            // Lowercase 'a'-'z' have ASCII values 97-122
            // Difference (97 - 65) is exactly 32
            if (ch >= 'A' && ch <= 'Z') {
                result[i] = (char) (ch + 32);
            } else {
                result[i] = ch;
            }
        }
        return new String(result);
    }
    // Deep equality check for two strings
    public boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConvertToLower obj = new ConvertToLower();
        System.out.println("Enter text with UPPERCASE letters to convert:");
        String input = scanner.nextLine();

        // 1. Manual logic
        String manualLower = obj.customToLowerCase(input);

        // 2. Built-in logic
        String builtInLower = input.toLowerCase();

        // 3. Comparison
        boolean isMatch = obj.compareStrings(manualLower, builtInLower);
        System.out.println("Original Text:    " + input);
        System.out.println("Manual Lowercase: " + manualLower);
        System.out.println("Built-in Method:  " + builtInLower);
        if (isMatch) {
            System.out.println("\nSuccess: Both methods produced the same result.");
        } else {
            System.out.println("\nError: The results do not match.");
        }
        scanner.close();
    }
}
