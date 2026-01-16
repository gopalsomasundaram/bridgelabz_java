package String.Level3;

import java.util.Scanner;
public class PalindromeCheck {
    public boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    public String reverseString(String text) {
        char[] reversed = new char[text.length()];
        int j = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed[j++] = text.charAt(i);
        }
        return new String(reversed);
    }

    public boolean isPalindromeByReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text).toCharArray();

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeCheck checker = new PalindromeCheck();
        System.out.print("Enter text to check for palindrome: ");
        String input = sc.nextLine();
        String cleanedInput = input.toLowerCase();
        System.out.println("Logic 1 (Iterative): " + (checker.isPalindromeIterative(cleanedInput) ? "yes" : "no"));
        System.out.println("Logic 2 (Recursive): " + (checker.isPalindromeRecursive(cleanedInput, 0, cleanedInput.length() - 1) ? "yes" : "no"));
        System.out.println("Logic 3 (Reversal):  " + (checker.isPalindromeByReversal(cleanedInput) ? "yes" : "no"));
        sc.close();
    }
}
