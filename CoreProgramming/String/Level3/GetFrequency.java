package String.Level3;

import java.util.Scanner;
public class GetFrequency {
    public String[][] findFrequency(String text) {
        int[] freqMap = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freqMap[ch]++; // Use ASCII value as index
        }
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freqMap[i] > 0) {
                uniqueCount++;
            }
        }
        String[][] result = new String[uniqueCount][2];
        int currentRow = 0;
        boolean[] processed = new boolean[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!processed[ch]) {
                result[currentRow][0] = String.valueOf(ch);
                result[currentRow][1] = String.valueOf(freqMap[ch]);
                processed[ch] = true;
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
