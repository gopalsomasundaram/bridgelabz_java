/**
 * This program counts the frequency of words in a string using a HashMap.
 * It normalizes the text by converting it to lowercase and removing
 * punctuation to ensure accurate counting.
 *
 * @author gopal
 */
package collections.mapinterface;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    /**
     * Counts occurrences of each word in the input string.
     *
     * @param text The input string to analyze.
     * @return A map containing words as keys and their counts as values.
     */
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Remove punctuation and split by whitespace
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                // If word exists, increment count; otherwise, start at 1
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println("Input: " + input);
        System.out.println("Output: " + countWords(input));
    }
}