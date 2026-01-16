package String.Level1;

import java.util.Scanner;
public class ConvertToLower {
    public String customToLowerCase(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result[i] = (char) (ch + 32);
            } else {
                result[i] = ch;
            }
        }
        return new String(result);
    }
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
        String manualLower = obj.customToLowerCase(input);
        String builtInLower = input.toLowerCase();
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
