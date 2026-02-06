/**
 * This program implements a simple word censoring system using Regular Expressions.
 * It identifies specific forbidden words within a user-provided string and
 * replaces them with asterisks while maintaining case-insensitivity and
 * word boundaries.
 * @author gopal
 */

package regexjunit.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 * This class handles the input scanning and regex replacement logic
 * to mask "bad" words from a sentence.
 */
public class CensorBadWords {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // List creation to store forbidden words
        List<String> badWords = new ArrayList<>(Arrays.asList("damn","stupid"));
        System.out.println("Enter the Sentence that needs to be censored: ");
        // Reading the full sentence from user
        String sentence = scanner.nextLine();
        // Loop through the list to apply censorship for each word
        for(String word : badWords){
            // Regex pattern creation with case-insensitivity and word boundaries
            String regex = "(?i)\\b"+word+"\\b";
            // Replacing the identified word with asterisks of the same length
            sentence = sentence.replaceAll(regex,"*".repeat(word.length()));
        }
        System.out.println(sentence);
    }
}
