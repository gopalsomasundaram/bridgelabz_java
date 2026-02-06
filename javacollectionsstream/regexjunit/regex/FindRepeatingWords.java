/**
 * This Program implements a repetition detection system using regular expressions
 * to identify and print words that appear twice in immediate succession.
 * It utilizes backreferencing to match a captured group against the following word.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class serves as a utility to scan text for duplicate adjacent words.
 * It employs a regex pattern that captures a word and then looks for
 * an identical sequence separated by whitespace.
 */
public class FindRepeatingWords {
    // public main method
    public static void main(String[] args) {
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * (?i)  -> case-insensitive matching
         * \\b   -> word boundary
         * (\\w+) -> capture group 1: matches one or more word characters
         * \\s+  -> matches one or more whitespace characters
         * \\1   -> backreference: matches the exact same text captured in group 1
         * \\b   -> word boundary
         */
        String regex = "(?i)\\b(\\w+)\\s+\\1\\b";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all found repeating word matches
        while (matcher.find()) {
            // printing the first instance of the repeated word
            System.out.println(matcher.group(1));
        }
    }
}