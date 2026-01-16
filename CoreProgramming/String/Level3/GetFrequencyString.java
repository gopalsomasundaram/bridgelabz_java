package String.Level3;

import java.util.Scanner;
public class GetFrequencyString {
    public String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') {
                continue;
            }

            freq[i] = 1; // Initialize frequency
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }
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
