/**
 * This Program implements a simple division operation and its corresponding
 * unit tests using JUnit 5. It specifically focuses on exception testing
 * to ensure the system correctly handles division by zero.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class provides a basic division utility.
 * It encapsulates the division of two integers, which is a standard
 * operation that requires validation for zero-value divisors.
 */
class Divide{
    // Method to perform integer division
    public int performDivision(int a, int b){
        return a/b;
    }
}

/**
 * This class provides unit tests for the Divide class.
 * It focuses on verifying the robust handling of mathematical errors
 * using the assertThrows assertion.
 */
public class DivideTest {
    // Instance of the Divide class for testing
    private Divide divObj;

    /**
     * Initialization method that runs before each test.
     * Instantiates the division object to ensure a clean state.
     */
    @BeforeEach
    void initTest(){
        divObj = new Divide();
    }

    /**
     * Tests the behavior of the division method when the divisor is zero.
     * Verifies that an ArithmeticException is thrown as expected.
     */
    @Test
    void testDivision(){
        // Assertions.assertThrows(ExceptionClass, Executable)
        Assertions.assertThrows(ArithmeticException.class,()->divObj.performDivision(10,0));
    }
}