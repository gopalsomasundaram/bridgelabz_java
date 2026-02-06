/**
 * This Program implements a basic Calculator system along with unit tests
 * using the JUnit 5 framework. It covers fundamental arithmetic operations
 * including addition, subtraction, multiplication, and division, while
 * validating error handling for division by zero.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class provides unit tests for the Calculator class.
 * It ensures that each mathematical operation returns the correct result
 * and that illegal operations trigger the expected exceptions.
 */
public class CalculatorTest{
    // Instance of Calculator to be used for testing
    private Calculator calculator;

    /**
     * Initialization method that runs before each test case.
     * Ensures a fresh Calculator instance is available for every test.
     */
    @BeforeEach
    void initTest(){
        calculator = new Calculator();
    }

    // Tests the addition of two integers
    @Test
    void testAddition(){
        assertEquals(10,calculator.add(5,5));
    }

    // Tests the subtraction of one integer from another
    @Test
    void testSubtraction(){
        assertEquals(10,calculator.subtract(12,2));
    }

    // Tests the multiplication of two integers
    @Test
    void testMultiplication(){
        assertEquals(10,calculator.multiply(5,2));
    }

    // Tests the division of two integers
    @Test
    void testDivide(){
        assertEquals(10,calculator.divide(20,2));
    }

    /**
     * Tests that dividing by zero throws an ArithmeticException.
     * This ensures the program handles undefined mathematical operations safely.
     */
    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class,() -> calculator.divide(10,0));
    }
}

/**
 * This class implements core arithmetic logic.
 * It serves as a simple mathematical engine providing methods for
 * standard integer-based calculations.
 */
class Calculator {
    // Returns the sum of two integers
    public int add(int a, int b){
        return a+b;
    }

    // Returns the difference between two integers
    public int subtract(int a,int b){
        return a-b;
    }

    // Returns the product of two integers
    public int multiply(int a,int b){
        return a*b;
    }

    // Returns the quotient of two integers
    public int divide(int a, int b){
        return a/b;
    }
}