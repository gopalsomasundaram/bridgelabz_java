package String.Level2;

import java.util.Scanner;
public class CustomTrim {
    public int[] findTrimPoints(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }
    public String customSubstring(String str, int start, int end) {
        if (start > end) return "";
        char[] result = new char[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            result[index++] = str.charAt(i);
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
        CustomTrim obj = new CustomTrim();
        System.out.println("Enter a string with leading and trailing spaces:");
        String input = scanner.nextLine();
        int[] points = obj.findTrimPoints(input);
        String manualTrimmed = obj.customSubstring(input, points[0], points[1]);
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
