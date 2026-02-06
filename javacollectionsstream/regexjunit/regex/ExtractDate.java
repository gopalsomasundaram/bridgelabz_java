/**
 * This Program implements a date extraction system using regular expressions
 * to identify and print dates formatted as DD/MM/YYYY from a given text.
 * It ensures that only strings following this specific numeric pattern are captured.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class serves as a utility to scan input strings for date patterns.
 * It uses the Pattern and Matcher classes to locate date substrings
 * that match the standard forward-slash delimited format.
 */
public class ExtractDate {
    // public main method
    public static void main(String[] args) {
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text to extract dates from: ");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * [\\d]{2} -> matches exactly two digits (Day)
         * /        -> matches the literal forward slash
         * [\\d]{2} -> matches exactly two digits (Month)
         * /        -> matches the literal forward slash
         * [\\d]{4} -> matches exactly four digits (Year)
         */
        String regex = "[\\d]{2}/[\\d]{2}/[\\d]{4}";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all date matches found in the text
        while (matcher.find()) {
            // printing each matched date group to the console
            System.out.println(matcher.group());
        }
    }
}