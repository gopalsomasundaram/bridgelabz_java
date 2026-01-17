package strings.level3;

import java.util.Scanner;
/*
 * This class calculates character frequency by marking visited characters.
 * It uses a nested loop approach (O(N^2)) which is useful when you don't
 * want to rely on the size of the character set (like ASCII).
 */
public class GetFrequencyString {
    public String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            //Skip if this character was already processed as a duplicate
            if (chars[i] == '0') {
                continue;
            }
            //Inner loop to find all matches of chars[i] later in the string
            freq[i] = 1; // Initialize frequency
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        //Count how many unique characters remain (those not marked '0')
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }
        //Construct the final result array
        String[] result = new String[uniqueCount];
        int k = 0;
        char[] originalChars = text.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[k++] = originalChars[i] + ": " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetFrequencyString obj = new GetFrequencyString();

        System.out.print("Enter a string to calculate character frequency: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The input is empty.");
        } else {
            String[] finalResult = obj.findFrequency(input);
            for (String s : finalResult) {
                System.out.println(s);
            }
        }

        scanner.close();
    }
}
