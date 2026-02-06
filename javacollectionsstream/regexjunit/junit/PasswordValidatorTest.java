/**
 * This Program implements a Password Validation system along with unit tests
 * using the JUnit 5 framework. It utilizes lookahead regular expressions
 * to enforce security policies such as minimum length and the inclusion
 * of uppercase letters and numeric digits.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * This class handles the logic for verifying password strength.
 * It uses a complex regular expression to ensure that passwords meet
 * specific complexity requirements before being accepted by the system.
 */
class PasswordValidator{
    /**
     * Checks if a password meets complexity requirements.
     * @param password The string to be validated.
     * @return true if the password contains at least one uppercase letter,
     * one digit, and is at least 8 characters long; false otherwise.
     */
    public boolean isValid(String password){
        /* * regex pattern breakdown:
         * ^             -> Start of string
         * (?=.*[A-Z])   -> Positive lookahead for at least one uppercase letter
         * (?=.*[0-9])   -> Positive lookahead for at least one digit
         * [\\w]{8,20}   -> Matches 8 to 20 word characters (letters, numbers, underscores)
         * $             -> End of string
         */
        String regex = "^(?=.*[A-Z])(?=.*[0-9])[\\w]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

/**
 * This class provides unit tests for the PasswordValidator.
 * It ensures that valid passwords pass the check and provides
 * a foundation for testing various invalid password scenarios.
 */
public class PasswordValidatorTest{
    // Instance of the validator to be tested
    private PasswordValidator obj;

    /**
     * Initialization method that runs before each test case.
     * Instantiates the validator to provide a clean test environment.
     */
    @BeforeEach
    void init(){
        obj = new PasswordValidator();
    }

    /**
     * Tests a valid password scenario to ensure it is correctly identified
     * as meeting the security requirements.
     */
    @Test
    void testValidity(){
        Assertions.assertTrue(obj.isValid("TestingUsingJunit1"));
    }
}