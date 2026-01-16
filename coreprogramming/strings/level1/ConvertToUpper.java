package strings.level1;

import java.util.Scanner;
/*
 * This class manually converts a string to uppercase by manipulating
 * character ASCII values and validates it against the built-in .toUpperCase().
 */
public class ConvertToUpper {
    // Method to convert Lowercase to Uppercase manually
    public String customToUpperCase(String text) {
        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Logic: Lowercase 'a'-'z' are 97-122. Uppercase 'A'-'Z' are 65-90.
            // Subtracting 32 shifts the value from lowercase to uppercase.
            if (ch >= 'a' && ch <= 'z') {
                result[i] = (char) (ch - 32);
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
        ConvertToUpper obj = new ConvertToUpper();
        System.out.println("Enter a sentence to convert to uppercase:");
        String input = scanner.nextLine();
        // 1. Manual logic
        String manualUpper = obj.customToUpperCase(input);
        // 2. Java built-in method
        String builtInUpper = input.toUpperCase();
        // 3. Validation
        boolean match = obj.compareStrings(manualUpper, builtInUpper);
        System.out.println("Manual Conversion:   " + manualUpper);
        System.out.println("Built-in Conversion: " + builtInUpper);

        if (match) {
            System.out.println("Comparison Result: Both strings are identical.");
        } else {
            System.out.println("Comparison Result: The strings do not match.");
        }

        scanner.close();
    }
}
