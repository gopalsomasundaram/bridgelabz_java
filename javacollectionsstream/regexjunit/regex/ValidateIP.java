/**
 * This Program implements an IPv4 validation system using regular expressions.
 * It ensures that the input follows the standard dotted-decimal notation,
 * verifying that each of the four octets falls within the valid range of 0 to 255.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class validates the structure and numeric range of an IPv4 address.
 * It uses a complex regex pattern to handle different digit lengths (1, 2, or 3)
 * while strictly enforcing the 255 upper limit for each segment.
 */
public class ValidateIP {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IPv4 you want to validate: ");

        // reading the input IP address string
        String ipAddress = scanner.nextLine();

        /* * regex pattern breakdown:
         * ^        -> matches the start of the string
         * (        -> start of group for the first three octets
         * 25[0-5]       -> matches numbers 250-255
         * |2[0-4][0-9]  -> OR matches 200-249
         * |[1]?[0-9][0-9]? -> OR matches 0-199 (handles 1, 2, or 3 digits)
         * )
         * \\.      -> matches the literal dot separator
         * {3}      -> repeats the octet+dot pattern exactly three times
         * (25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?) -> matches the final fourth octet
         * $        -> matches the end of the string
         */
        String regex = "^((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]?)$";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation to check the entire input against the pattern
        Matcher matcher = pattern.matcher(ipAddress);

        // condition to check if the full input matches the IPv4 format
        if(matcher.matches()){
            System.out.println("It is a valid IPv4 Address");
            return;
        }

        // output if the validation fails
        System.out.println("It is an Invalid IPv4 Address");
    }
}