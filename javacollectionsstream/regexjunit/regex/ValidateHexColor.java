/**
 * This Program implements a Hexadecimal color code validation system
 * using regular expressions. It ensures that the input starts with a
 * hash symbol followed by exactly six valid hexadecimal characters.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class validates the structure of a Hex color code.
 * It uses a specific regex pattern to ensure the string conforms to
 * the standard 6-digit hexadecimal format commonly used in CSS and design.
 */
public class ValidateHexColor {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the hexcode: ");

        // reading the input string
        String text = scanner.nextLine();

        /* * regex pattern:
         * ^         -> matches the start of the string
         * #         -> matches the literal hash symbol
         * [A-Fa-f0-9]{6} -> matches exactly six characters (A-F, a-f, or 0-9)
         * $         -> matches the end of the string
         */
        String regex = "^#[A-Fa-f0-9]{6}$";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation to check the entire input against the pattern
        Matcher matcher = pattern.matcher(text);

        // condition to check if the full input matches the hex format
        if(matcher.matches()){
            System.out.println("The Hex code is valid");
            return;
        }

        // output if the validation fails
        System.out.println("The Hex code is not valid");
    }
}