/**
 * This Program implements a Temperature Conversion utility and its unit tests
 * using JUnit 5. It provides methods for bidirectional conversion between
 * Celsius and Fahrenheit scales, utilizing delta-based assertions for
 * floating-point precision and parameterized testing for edge cases.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This class provides mathematical conversions between different temperature units.
 * It uses standard linear equations to transform values between the
 * Celsius and Fahrenheit scales.
 */
class TempConverter{
    // Converts Celsius to Fahrenheit: (C * 9/5) + 32
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Converts Fahrenheit to Celsius: (F - 32) * 5/9
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

/**
 * This class provides a comprehensive test suite for the TempConverter.
 * It ensures accuracy across common benchmarks (freezing/boiling) and
 * verifies the unique mathematical convergence point of the two scales.
 */
public class TempConverterTest {
    // Instance of the converter to be tested
    private TempConverter converter;

    /**
     * Initialization method that runs before each test.
     * Reinstantiates the converter to ensure test isolation.
     */
    @BeforeEach
    void init(){
        converter = new TempConverter();
    }

    /**
     * Tests conversion from Celsius to Fahrenheit.
     * Uses a delta of 0.001 to handle potential floating-point rounding errors.
     */
    @Test
    void testCelsiusToFahrenheit() {
        // Freezing point: 0°C should be 32°F
        Assertions.assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
        // Boiling point: 100°C should be 212°F
        Assertions.assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
        // Room temp: 20°C should be 68°F
        Assertions.assertEquals(68.0, converter.celsiusToFahrenheit(20), 0.001);
    }

    /**
     * Tests conversion from Fahrenheit to Celsius.
     */
    @Test
    void testFahrenheitToCelsius() {
        Assertions.assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
        Assertions.assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
    }

    /**
     * Parameterized test verifying bidirectional consistency.
     * Includes the special case -40, where both temperature scales are equal.
     * * @param celsius The value in Celsius
     * @param fahrenheit The corresponding value in Fahrenheit
     */
    @ParameterizedTest
    @CsvSource({
            "0.0, 32.0",
            "100.0, 212.0",
            "-40.0, -40.0"
    })
    void testConversions(double celsius, double fahrenheit) {
        Assertions.assertEquals(fahrenheit, converter.celsiusToFahrenheit(celsius), 0.001);
        Assertions.assertEquals(celsius, converter.fahrenheitToCelsius(fahrenheit), 0.001);
    }
}