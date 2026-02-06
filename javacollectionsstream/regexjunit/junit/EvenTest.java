/**
 * This Program implements a parity checker and its unit tests using JUnit 5.
 * It demonstrates the use of parameterized testing with CSV data sources
 * to efficiently validate multiple integer inputs against expected
 * boolean outcomes in a single test method.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This class provides a utility to check if a number is even.
 * It uses the modulus operator to determine if an integer is
 * divisible by two without a remainder.
 */
class Even{
    // Method to check if an integer is even
    public boolean isEven(int num){
        return num % 2 == 0;
    }
}

/**
 * This class provides unit tests for the Even class.
 * It utilizes the @ParameterizedTest and @CsvSource annotations to
 * run the same test logic against a variety of even and odd inputs.
 */
public class EvenTest {
    // Instance of the parity checker
    Even obj;

    /**
     * Initialization method that runs before each test.
     * Sets up a fresh instance of the Even class.
     */
    @BeforeEach
    void init(){
        obj = new Even();
    }

    /**
     * Parameterized test that verifies the isEven method.
     * @param inp The integer to be tested.
     * @param expected The expected boolean result (true for even, false for odd).
     */
    @ParameterizedTest(name = "{index} => input=''{0}'', expected=''{1}''")
    @CsvSource({
            "2, true",
            "4, true",
            "6, true",
            "7, false",
            "9, false"
    })
    void testEven(int inp, boolean expected){
        // Asserts that the actual result matches the CSV expected value
        Assertions.assertEquals(expected,obj.isEven(inp));
    }
}