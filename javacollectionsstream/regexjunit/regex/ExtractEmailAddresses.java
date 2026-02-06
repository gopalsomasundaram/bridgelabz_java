/**
 * This Program implements an email extraction system using regular expressions
 * to identify and print valid email addresses from a user-provided string.
 * It identifies the local part, the @ symbol, and the domain name.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class serves as a utility to scan text for email patterns.
 * It uses a specialized regex pattern to match common email structures
 * including those with dots, plus signs, or hyphens in the name.
 */
public class ExtractEmailAddresses {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text to extract emails from: ");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * [\\w.+-]+  -> matches the local part (letters, digits, dots, plus, hyphen)
         * @          -> matches the literal @ symbol
         * [\\w-]+    -> matches the domain name (letters, digits, hyphen)
         * \\.        -> matches the literal dot
         * [a-zA-Z]{2,} -> matches the TLD (at least two alphabet characters)
         */
        String regex = "[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all found email addresses
        while(matcher.find()){
            // printing the full matched email string
            System.out.println(matcher.group(0));
        }
    }
}