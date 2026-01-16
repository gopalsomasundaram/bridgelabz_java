package string.Level2;

import java.util.Scanner;
/*
 * This class manually implements the .trim() functionality.
 * It identifies the first and last non-space characters and
 * extracts the content between them.
 */
public class CustomTrim {
    // Method 1: Locate the boundaries of the actual text
    public int[] findTrimPoints(String text) {
        int start = 0;
        int end = text.length() - 1;
        // Move the start pointer forward until a non-space character is found
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        // Move the end pointer backward until a non-space character is found
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        // Return the valid range [start, end]
        return new int[]{start, end};
    }
    // Method 2: Extract the substring based on identified points
    public String customSubstring(String str, int start, int end) {
        if (start > end) return "";
        char[] result = new char[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            result[index++] = str.charAt(i);
        }
        return new String(result);
    }
    // Method 3: Deep equality check
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
        CustomTrim obj = new CustomTrim();
        System.out.println("Enter a string with leading and trailing spaces:");
        String input = scanner.nextLine();
        // 1. Logic Execution
        int[] points = obj.findTrimPoints(input);
        String manualTrimmed = obj.customSubstring(input, points[0], points[1]);
        // 2. Validation against built-in method
        String builtInTrimmed = input.trim();
        boolean isMatch = obj.compareStrings(manualTrimmed, builtInTrimmed);
        System.out.println("Original Length:      " + input.length());
        System.out.println("Manual Trimmed:       " + manualTrimmed );
        System.out.println("Built-in Trimmed:     " + builtInTrimmed);
        System.out.println("Trimmed Length:       " + manualTrimmed.length());
        if (isMatch) {
            System.out.println("\nResult: Both trim methods are identical.");
        } else {
            System.out.println("\nResult: The trim results do not match.");
        }
        scanner.close();
    }
}
