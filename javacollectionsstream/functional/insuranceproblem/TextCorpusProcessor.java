/**
 * This Program analyzes a text corpus to identify word frequencies.
 * It demonstrates tokenization, case conversion, and complex sorting
 * using Streams to find specific frequency-based results.
 * * @author gopal
 */
package functional.insuranceproblem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextCorpusProcessor {
    public static void main(String[] args) {
        String corpus = "Insurance is important. Insurance policies provide safety. Safety is a priority for every insurance holder.";

        // 1, 2 & 3: Tokenize, Lowercase, Remove Punctuation, and Count Frequency
        Map<String, Long> wordFrequencies = Arrays.stream(corpus.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 4 & 5: Find Top N (e.g., Top 3) Most Frequent Words
        int n = 3;
        System.out.println("--- Top " + n + " Frequent Words ---");
        wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 16: Find the second most repeated word
        Optional<String> secondMostRepeated = wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .skip(1) // Skip the first (most frequent)
                .findFirst();

        secondMostRepeated.ifPresent(word ->
                System.out.println("\nSecond most repeated word: " + word));
    }
}