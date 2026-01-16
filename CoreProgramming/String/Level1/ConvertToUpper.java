package String.Level1;

import java.util.Scanner;
public class ConvertToUpper {
    public String customToUpperCase(String text) {
        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result[i] = (char) (ch - 32);
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
        ConvertToUpper obj = new ConvertToUpper();
        System.out.println("Enter a sentence to convert to uppercase:");
        String input = scanner.nextLine();
        String manualUpper = obj.customToUpperCase(input);
        String builtInUpper = input.toUpperCase();
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
