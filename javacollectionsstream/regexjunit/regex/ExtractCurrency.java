/**
 * This Program implements a currency extraction system using regular expressions
 * to identify and print monetary values from a user-provided string.
 * It is designed to capture optional currency symbols followed by numeric amounts.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.Scanner;
import java.util.regex.*;

/**
 * This class handles the extraction of currency patterns from text.
 * It searches for digits that may include a leading dollar sign
 * and a decimal point for fractional values.
 */
public class ExtractCurrency {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * [$]?        -> optional dollar sign
         * [0-9]{1,2}  -> one or two digits
         * \\.?        -> optional decimal point
         * [0-9]{1,2}  -> one or two digits for cents/remaining value
         */
        String regex = "[$]?[0-9]{1,2}\\.?[0-9]{1,2}";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // iterating through all currency matches found
        while(matcher.find()){
            // printing each matched currency value
            System.out.println(matcher.group());
        }
    }
}