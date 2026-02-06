/**
 * This Program implements a Social Security Number (SSN) validation system
 * using regular expressions. It identifies if a string contains the
 * standard nine-digit format separated by hyphens (AAA-GG-SSSS).
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.Scanner;
import java.util.regex.*;

/**
 * This class serves as a utility to validate the structure of an SSN.
 * It uses a regex pattern to ensure the input follows the three-part
 * numeric sequence required for Social Security identification.
 */
public class ValidateSocialSecurity {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the SSN:");

        // reading the input text
        String text = scanner.nextLine();

        /* * regex pattern:
         * [0-9]{3} -> matches exactly three digits (Area Number)
         * -        -> matches the literal hyphen
         * [0-9]{2} -> matches exactly two digits (Group Number)
         * -        -> matches the literal hyphen
         * [0-9]{4} -> matches exactly four digits (Serial Number)
         */
        String regex = "[0-9]{3}-[0-9]{2}-[0-9]{4}";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation for the input text
        Matcher matcher = pattern.matcher(text);

        // condition to check if the pattern is found within the input
        if(matcher.find()){
            System.out.println("It is a valid SSN");
            return;
        }

        // output if the validation fails
        System.out.println("It is an Invalid SSN");
    }
}