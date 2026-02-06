/**
 * This Program implements a specialized extraction system using regular expressions
 * to identify and print specific programming language names from a given string.
 * It uses a predefined list of languages and handles case-insensitive matching.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.Scanner;
import java.util.regex.*;

/**
 * This class serves as a utility to scan text for programming language keywords.
 * It employs a regex alternation group to match various language names
 * regardless of their case in the input text.
 */
public class ExtractProgrammingLanguages {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * (?i)  -> case-insensitive matching
         * \\b   -> word boundary to prevent matching inside other words
         * (...) -> alternation group containing the target language names
         */
        String regex = "(?i)\\b(C\\+\\+|C|Go|Rust|Ruby|Python|JavaScript|Java)";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all found language matches
        while(matcher.find()){
            // printing each matched language name
            System.out.println(matcher.group());
        }
    }
}