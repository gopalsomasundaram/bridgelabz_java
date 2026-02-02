/**
 * This program reads a text file and calculates the frequency of each word.
 * It utilizes a HashMap to store word-count pairs and uses the Java Streams
 * API to sort and display the top 5 most frequently occurring words.
 *
 * @author gopal;
 */
package streams;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Path to the file generated or used in previous examples
        String filePath = "UnbufferedInput.txt";

        // HashMap provides O(1) average time complexity for insertions and lookups
        Map<String, Integer> wordCounts = new HashMap<>();

        // --- STEP 1: Reading and Tokenizing ---
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by non-word characters (\W+ matches spaces, punctuation, etc.)
                // This ensures "Java!" and "java" are treated as the same word.
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    // Ignore empty strings resulting from multiple delimiters
                    if (!word.isEmpty()) {
                        // getOrDefault handles the initial case where a word isn't in the map yet
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // --- STEP 2: Sorting and Filtering ---
        System.out.println("--- Top 5 Most Frequent Words ---");

        // Convert map entries to a stream for advanced sorting logic
        wordCounts.entrySet().stream()
                // Sort by Map value (the count) in descending order
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                // Restrict output to the first 5 elements
                .limit(5)
                // Print the key (word) and value (count)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}