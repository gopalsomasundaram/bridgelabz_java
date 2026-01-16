package string.Level3;

import java.util.Scanner;
public class AnagramCheck {
    // Method to check if two strings are anagrams
    public boolean areAnagrams(String text1, String text2) {
        // 1. Check if the lengths are equal
        if (text1.length() != text2.length()) {
            return false;
        }

        // 2. Create arrays to store character frequencies (ASCII range 256)
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // 3. Find frequencies of characters in both texts
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // 4. Compare the frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnagramCheck checker = new AnagramCheck();
        System.out.print("Enter the first text: ");
        String input1 = scanner.nextLine();
        System.out.print("Enter the second text: ");
        String input2 = scanner.nextLine();
        String clean1 = input1.replaceAll("\\s", "").toLowerCase();
        String clean2 = input2.replaceAll("\\s", "").toLowerCase();
        boolean result = checker.areAnagrams(clean1, clean2);
        System.out.println("\nResults:");
        System.out.println("Text 1: " + input1);
        System.out.println("Text 2: " + input2);
        if (result) {
            System.out.println("Outcome: These texts ARE anagrams.");
        } else {
            System.out.println("Outcome: These texts are NOT anagrams.");
        }
        scanner.close();
    }
}
