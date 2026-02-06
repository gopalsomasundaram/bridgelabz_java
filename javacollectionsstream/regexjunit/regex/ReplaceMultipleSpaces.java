/**
 * This Program implements a whitespace normalization system using regular expressions
 * to identify and replace multiple consecutive spaces with a single space.
 * It ensures the resulting text is cleaner and more consistently formatted.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.Scanner;

/**
 * This class handles the replacement of redundant whitespace in a string.
 * It uses the String.replaceAll method to identify all whitespace sequences
 * and condense them into a single space character.
 */
public class ReplaceMultipleSpaces {
    // public main method
    public static void main(String[] args) {
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text remove multiple spaces from: ");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * \\s  -> matches any whitespace character (space, tab, newline)
         * +    -> quantifier: matches one or more of the preceding element
         */
        String regex = "\\s+";

        // replacing all matched whitespace sequences with a single space
        text = text.replaceAll(regex, " ");

        System.out.println("Result after removing extra spaces: ");
        // printing the sanitized result
        System.out.println(text);
    }
}