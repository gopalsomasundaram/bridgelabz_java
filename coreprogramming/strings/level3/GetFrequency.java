package strings.level3;

import java.util.Scanner;
/*
 * This class calculates the frequency of each unique character in a string.
 * It uses a frequency map (hashing concept) and maintains the original order of appearance.
 */
public class GetFrequency {
    public String[][] findFrequency(String text) {
        //Use the ASCII value of characters as indices to count occurrences
        int[] freqMap = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freqMap[ch]++; // Use ASCII value as index
        }
        //Determine how many unique characters exist to size the 2D array
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freqMap[i] > 0) {
                uniqueCount++;
            }
        }
        //Populate the 2D array while tracking already-added characters
        String[][] result = new String[uniqueCount][2];
        int currentRow = 0;
        boolean[] processed = new boolean[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!processed[ch]) {
                result[currentRow][0] = String.valueOf(ch);
                result[currentRow][1] = String.valueOf(freqMap[ch]);
                processed[ch] = true; // Mark character as handled
                currentRow++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetFrequency obj = new GetFrequency();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The input is empty.");
        } else {
            String[][] frequencyData = obj.findFrequency(input);
            System.out.printf("%-12s | %-10s\n", "Character", "Frequency");

            for (int i = 0; i < frequencyData.length; i++) {
                String charDisplay = frequencyData[i][0].equals(" ") ? "[Space]" : frequencyData[i][0];
                System.out.printf("%-12s | %-10s\n", charDisplay, frequencyData[i][1]);
            }
        }

        scanner.close();
    }
}
