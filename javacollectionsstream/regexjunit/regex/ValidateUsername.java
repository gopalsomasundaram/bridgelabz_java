/**
 * This Program implements a username validation system using regular expressions.
 * It enforces specific naming conventions, such as starting with a letter and
 * maintaining a specific length, to ensure account security and compatibility.
 *
 * @author gopal
 */
package regexjunit.regex;

import java.util.regex.*;
import java.util.Scanner;

/**
 * This class validates the structure of a username.
 * It ensures the input string begins with an alphabetic character and
 * consists of alphanumeric characters (including underscores) with a
 * total length between 5 and 15 characters.
 */
public class ValidateUsername {
    // public main method
    public static void main(String[] args){
        // scanner initialization for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Username to be validated: ");

        // reading the input string
        String text = scanner.nextLine();

        /* * regex pattern breakdown:
         * ^         -> matches the start of the string
         * [a-zA-Z]  -> ensures the first character is a letter
         * \\w{4,14} -> matches 4 to 14 additional word characters (letters, digits, or underscores)
         * $         -> matches the end of the string
         */
        String regex = "^[a-zA-Z]\\w{4,14}$";

        // pattern compilation
        Pattern pattern = Pattern.compile(regex);

        // matcher creation to check the entire input against the pattern
        Matcher matcher = pattern.matcher(text);

        // condition to check if the full input matches the username requirements
        if(matcher.matches()){
            System.out.println("Valid username");
            return;
        }

        // output if the validation fails
        System.out.println("Invalid username");
    }
}