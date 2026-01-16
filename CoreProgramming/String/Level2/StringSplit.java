package String.Level2;
import java.util.Scanner;
import java.util.Arrays;
/*
 * This class demonstrates manual string splitting without using .split().
 * It uses a two-pass approach: counting spaces to size the array,
 * then extracting substrings based on those space locations.
 */
public class StringSplit {
    // Manual length calculation using the 'Probe and Exception' strategy
    public int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    // Custom split implementation
    public String[] customSplit(String text) {
        int len = findLength(text);
        int wordCount = 0;
        if (len > 0) {
            wordCount = 1;
            for (int i = 0; i < len; i++) {
                if (text.charAt(i) == ' ') {
                    wordCount++;
                }
            }
        }
        int[] spaceIndices = new int[wordCount - 1];
        int spaceIdx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndices[spaceIdx++] = i;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end;
            if(i < wordCount - 1){
                end = spaceIndices[i];
            }else{
                end = len;
            }
            char[] wordChars = new char[end - start];
            for (int j = 0; j < (end - start); j++) {
                wordChars[j] = text.charAt(start + j);
            }
            words[i] = new String(wordChars);
            start = end + 1; // skip the space
        }
        return words;
    }
    // Deep comparison of two String arrays
    public boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringSplit obj = new StringSplit();
        System.out.println("Enter a sentence to split:");
        String input = scanner.nextLine();
        String[] customWords = obj.customSplit(input);
        String[] builtInWords = input.split(" ");
        boolean match = obj.compareArrays(customWords, builtInWords);
        // Print and Validate
        System.out.println("Custom Split:   " + Arrays.toString(customWords));
        System.out.println("Built-in Split: " + Arrays.toString(builtInWords));
        if (match) {
            System.out.println("Result: Both methods are the same.");
        } else {
            System.out.println("Result: The methods produced different results.");
        }
        scanner.close();
    }
}
