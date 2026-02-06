/**
 * This Program implements a word extraction system using regular expressions
 * to identify and print all capitalized words from a user-provided string.
 * It ensures only full words starting with an uppercase letter are captured.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class serves as the main utility for extracting capitalized words.
 * It utilizes the Pattern and Matcher classes to find sequences that
 * match the specified title-case criteria.
 */
public class ExtractCapitalizedWords {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text to extract words from: ");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * \\b     -> word boundary
         * [A-Z]   -> starts with an uppercase letter
         * [a-z]* -> followed by zero or more lowercase letters
         * \\b     -> word boundary
         */
        String regex = "\\b[A-Z][a-z]*\\b";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all matches found in the text
        while(matcher.find()){
            // printing each matched group to the console
            System.out.println(matcher.group());
        }
    }
}