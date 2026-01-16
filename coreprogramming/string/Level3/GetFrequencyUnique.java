package string.Level3;
import java.util.Scanner;
public class GetFrequencyUnique {
    public char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] temp = new char[n];
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isRepeated = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isRepeated = true;
                    break;
                }
            }
            if (!isRepeated) {
                temp[uniqueCount++] = current;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }
    public String[][] findFrequency(String text) {
        int[] freqMap = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freqMap[text.charAt(i)]++;
        }
        char[] uniqueChars = uniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(freqMap[ch]);
        }

        return result;
    }

    // 3. Method to display the results in a tabular format
    public void displayResults(String[][] data) {
        System.out.printf("%-12s | %-10s\n", "Character", "Frequency");

        for (int i = 0; i < data.length; i++) {
            String charToDisplay = data[i][0];
            if (charToDisplay.equals(" ")) {
                charToDisplay = "[Space]";
            }
            System.out.printf("%-12s | %-10s\n", charToDisplay, data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetFrequencyUnique obj = new GetFrequencyUnique();

        System.out.print("Enter a string to analyze: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input cannot be empty.");
        } else {
            String[][] frequencyData = obj.findFrequency(input);
            obj.displayResults(frequencyData);
        }

        scanner.close();
    }
}
