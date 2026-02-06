/**
 * This Program implements a credit card validation system using regular expressions.
 * It specifically checks for 16-digit numbers that begin with either 4 or 5,
 * which typically represent Visa and Mastercard networks.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class validates the structure of a credit card number.
 * It uses a anchor-based regex to ensure the entire input string
 * conforms to the specified numeric requirements.
 */
public class ValidateCreditCardNumber {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number want to validate: ");

        // reading the input string
        String ipAddress = scanner.nextLine();

        /* * regex pattern:
         * ^        -> matches the start of the string
         * ([4]|[5])-> matches either the number 4 or 5 as the first digit
         * [\\d]{15}-> matches exactly fifteen digits following the first
         * $        -> matches the end of the string
         */
        String regex = "^([4]|[5])[\\d]{15}$";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation to check the entire input against the pattern
        Matcher matcher = pattern.matcher(ipAddress);

        // condition to check if the full input matches the regex
        if(matcher.matches()){
            System.out.println("It is a valid credit card number");
            return;
        }

        // output if the pattern does not match
        System.out.println("It is an Invalid credit card number");
    }
}