/**
 * This Program implements a Date Formatter and its unit tests using JUnit 5.
 * It focuses on converting dates from ISO format (yyyy-MM-dd) to a localized
 * format (dd-MM-yyyy) using string manipulation and parameterized testing
 * to validate multiple edge cases.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * This class provides utility methods for date string manipulation.
 * It includes basic validation to ensure input strings follow the expected
 * pattern and contain logically valid month and day values.
 */
class DateFormatter {
    /**
     * Converts yyyy-MM-dd to dd-MM-yyyy using String manipulation
     */
    public String formatDate(String inputDate) {
        // Validation for null input and regex pattern matching
        if (inputDate == null || !inputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid format. Use yyyy-MM-dd");
        }

        // Splitting the string by hyphen to extract date components
        String[] parts = inputDate.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];

        // Basic validation for "Invalid Date" requirement
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);

        // Range checking for months and days
        if (m < 1 || m > 12 || d < 1 || d > 31) {
            throw new IllegalArgumentException("Date values are out of range");
        }

        // Returning the reconstructed string in dd-MM-yyyy format
        return day + "-" + month + "-" + year;
    }
}

/**
 * This class provides a test suite for the DateFormatter.
 * It demonstrates standard test cases and @ParameterizedTest to efficiently
 * verify that various invalid inputs trigger the correct exceptions.
 */
public class DateFormatterTest {
    // Instance of the formatter to be tested
    private DateFormatter formatter;

    /**
     * Setup method to initialize the formatter before each test execution.
     */
    @BeforeEach
    void setUp() {
        formatter = new DateFormatter();
    }

    /**
     * Verifies the successful conversion of a valid ISO date.
     */
    @Test
    void testValidDateConversion() {
        // Happy path: yyyy-MM-dd -> dd-MM-yyyy
        String input = "2023-12-31";
        String expected = "31-12-2023";
        Assertions.assertEquals(expected, formatter.formatDate(input));
    }

    /**
     * Verifies that leap year dates are handled correctly.
     */
    @Test
    void testLeapYearDate() {
        Assertions.assertEquals("29-02-2024", formatter.formatDate("2024-02-29"));
    }

    /**
     * Parameterized test to check various failure scenarios.
     * @param invalidInput Strings that represent incorrectly formatted or logicaly invalid dates.
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "2023-13-01", // Invalid Month
            "2023-12-32", // Invalid Day
            "abc-de-fg",  // Not numbers
            "2023/12/31", // Wrong separator
            "31-12-2023"  // Already swapped
    })
    void testInvalidDates(String invalidInput) {
        // Verify that invalid formats or logical errors throw IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(invalidInput);
        });
    }
}