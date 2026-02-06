/**
 * This Program implements a link extraction system using regular expressions
 * to identify and print URLs (http or https) from a user-provided string.
 * It identifies the protocol, domain, and top-level domain components.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class serves as a utility to scan text for web links.
 * It uses a regex pattern to capture standard web addresses while
 * accounting for optional secure protocols and subdomains.
 */
public class ExtractLink {
    // public main method
    public static void main(String[] args) {
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text to extract links from: ");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * http[s]? -> matches http with an optional 's'
         * ://      -> matches the literal protocol separator
         * [\\w.-]+ -> matches the domain name characters
         * [.]?     -> matches an optional literal dot
         * [\\w]+   -> matches additional domain segments
         * \\.      -> matches the literal dot before the TLD
         * [a-z]{2,} -> matches the TLD (at least two lowercase letters)
         */
        String regex = "http[s]?://[\\w.-]+[.]?[\\w]+\\.[a-z]{2,}";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all found URL matches
        while (matcher.find()) {
            // printing each matched link to the console
            System.out.println(matcher.group());
        }
    }
}