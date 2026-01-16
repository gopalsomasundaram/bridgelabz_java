package string.Level2;

import java.util.Scanner;
/*
 * This class splits a sentence into individual words and maps
 * each word to its length using a 2D String array.
 * It demonstrates manual string traversal and character extraction.
 */
public class SplitText2D {
    // Manual length calculation without using .length()
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
    // Manual splitting of text based on spaces
    public String[] customSplit(String text) {
        int len = findLength(text);
        int wordCount = 0;
        if (len > 0) {
            wordCount = 1;
            for (int i = 0; i < len; i++) {
                // When a space is hit, or the end of the string is reached
                if (text.charAt(i) == ' ') wordCount++;
            }
        } else {
            return new String[0];
        }
        String[] words = new String[wordCount];
        int start = 0;
        int currentWord = 0;

        for (int i = 0; i <= len; i++) {
            if (i == len || text.charAt(i) == ' ') {
                int end = i;
                char[] wordChars = new char[end - start];
                for (int j = 0; j < (end - start); j++) {
                    wordChars[j] = text.charAt(start + j);
                }
                words[currentWord++] = new String(wordChars);
                start = i + 1;
            }
        }
        return words;
    }
    // Creates a 2D Map: Column 0 = Word, Column 1 = Length
    public String[][] generateWordLengthMap(String[] words) {
        String[][] map = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            map[i][0] = words[i];
            int len = findLength(words[i]);
            map[i][1] = String.valueOf(len);
        }
        return map;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SplitText2D obj = new SplitText2D();
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();
        String[] wordList = obj.customSplit(input);
        String[][] wordData = obj.generateWordLengthMap(wordList);
        // Displaying results in a formatted table
        System.out.printf("%-10s | %-10s\n", "Word", "Length");
        for (int i = 0; i < wordData.length; i++) {
            String word = wordData[i][0];
            int lengthValue = Integer.parseInt(wordData[i][1]);
            System.out.printf("%-10s | %-10d\n", word, lengthValue);
        }
        scanner.close();
    }
}