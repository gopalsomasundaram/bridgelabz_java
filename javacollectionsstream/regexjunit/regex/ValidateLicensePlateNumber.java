/**
 * This Program implements a license plate validation system using regular expressions.
 * It identifies valid plates based on a specific format requiring two uppercase
 * letters followed exactly by four numeric digits.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class serves as a utility to validate vehicle license plate numbers.
 * It ensures the input string strictly adheres to the AA1234 format
 * using start and end anchors for exact matching.
 */
public class ValidateLicensePlateNumber {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plate number: ");

        // reading the input string
        String text = scanner.nextLine();

        /* * regex pattern:
         * ^        -> matches the start of the string
         * [A-Z]{2} -> matches exactly two uppercase alphabet characters
         * [\\d]{4} -> matches exactly four numeric digits
         * $        -> matches the end of the string
         */
        String regex = "^[A-Z]{2}[\\d]{4}$";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation to check the entire input against the pattern
        Matcher matcher = pattern.matcher(text);

        // condition to check if the full input matches the plate format
        if(matcher.matches()){
            System.out.println("It is a valid plate number");
            return;
        }

        // output if the validation fails
        System.out.println("Is is an invalid Plate number");
    }
}