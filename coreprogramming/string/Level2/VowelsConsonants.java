package string.Level2;

import java.util.Scanner;
/*
 * This class calculates the total count of Vowels and Consonants in a given string.
 * It uses a helper method to classify individual characters and returns results in an array.
 */
public class VowelsConsonants {
    // Method 1: Classification Logic
    public String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    // Method 2: Aggregation Logic
    public int[] getCounts(String text) {
        int vCount = 0;
        int cCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = checkCharType(ch);
            if (type.equals("Vowel")) {
                vCount++;
            } else if (type.equals("Consonant")) {
                cCount++;
            }
        }
        return new int[]{vCount, cCount};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VowelsConsonants obj = new VowelsConsonants();
        //Display Final Report
        System.out.println("Enter a string to analyze:");
        String input = scanner.nextLine();
        int[] results = obj.getCounts(input);
        System.out.println("Total Vowels:     " + results[0]);
        System.out.println("Total Consonants: " + results[1]);
        int totalChars = input.length();
        int nonLetters = totalChars - (results[0] + results[1]);
        System.out.println("Other characters (spaces/digits): " + nonLetters);
        scanner.close();
    }
}
