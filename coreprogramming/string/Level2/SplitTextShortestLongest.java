package string.Level2;

import java.util.Scanner;
/*
 * This class splits a sentence into words and identifies the shortest and longest words.
 * It utilizes a custom split algorithm and a 2D map to track word lengths.
 */
public class SplitTextShortestLongest {
    // Manual length calculation using the 'Boundary Violation' strategy
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
    // Custom split logic to break a sentence into an array of words
    public String[] customSplit(String text) {
        int len = findLength(text);
        int wordCount = 0;
        if (len > 0) {
            wordCount = 1;
            for (int i = 0; i < len; i++) {
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
    // Maps words to their respective lengths in a 2D String array
    public String[][] generateWordMap(String[] words) {
        String[][] map = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            map[i][0] = words[i];
            map[i][1] = String.valueOf(findLength(words[i]));
        }
        return map;
    }
    // Identifies the indices of the shortest and longest words in one pass
    public int[] findMinMaxIndices(String[][] wordMap) {
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 1; i < wordMap.length; i++) {
            int currentLen = Integer.parseInt(wordMap[i][1]);
            int minLenSoFar = Integer.parseInt(wordMap[minIdx][1]);
            int maxLenSoFar = Integer.parseInt(wordMap[maxIdx][1]);
            // Finding the minimum (Shortest)
            if (currentLen < minLenSoFar) {
                minIdx = i;
            }
            // Finding the maximum (Longest)
            if (currentLen > maxLenSoFar) {
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SplitTextShortestLongest obj = new SplitTextShortestLongest();
        System.out.println("Enter a sentence to analyze:");
        String input = scanner.nextLine();
        String[] words = obj.customSplit(input);
        String[][] wordMap = obj.generateWordMap(words);
        int[] results = obj.findMinMaxIndices(wordMap);
        int shortIdx = results[0];
        int longIdx = results[1];
        //Output Results
        System.out.println("Shortest Word: " + wordMap[shortIdx][0] + " (Length: " + wordMap[shortIdx][1] + ")");
        System.out.println("Longest Word:  " + wordMap[longIdx][0] + " (Length: " + wordMap[longIdx][1] + ")");
        scanner.close();
    }
}
