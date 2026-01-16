package String.Level2;

import java.util.Scanner;
/*
 * This class classifies every character in a string as a Vowel, Consonant, or Non-letter.
 * It uses a 2D String array to store and display the results in a table format.
 */
public class CharType {
    public String checkCharType(char ch) {
        // Method to classify a single character
        char originalChar = ch;
        if (ch >= 'A' && ch <= 'Z') {
            //Normalize Case (Convert Uppercase to Lowercase)
            ch = (char) (ch + 32);
        }
        //Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            //Check for Vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    // Processes the entire string and stores character-type pairs
    public String[][] analyzeString(String text) {
        String[][] results = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            results[i][0] = String.valueOf(ch);
            results[i][1] = checkCharType(ch);
        }
        return results;
    }
    // Formats and prints the 2D array as a table
    public void displayTable(String[][] data) {
        System.out.printf("%-10s | %-15s\n", "Character", "Type");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s | %-15s\n", data[i][0], data[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharType obj = new CharType();
        System.out.println("Enter text to classify characters:");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("No input provided.");
        } else {
            String[][] charData = obj.analyzeString(input);
            obj.displayTable(charData);
        }
        scanner.close();
    }
}
