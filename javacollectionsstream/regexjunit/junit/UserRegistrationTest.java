/**
 * This Program implements a user registration system and its comprehensive
 * unit tests using JUnit 5. It manages standard input validation for
 * usernames, emails, and passwords, ensuring data integrity through
 * both standard and parameterized test cases.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This class handles the business logic for registering new users.
 * It enforces constraints on field formats and lengths, throwing
 * IllegalArgumentExceptions when validation rules are violated.
 */
class UserRegistration {

    /**
     * Validates and registers a user.
     * @return A success message if all inputs pass validation.
     * @throws IllegalArgumentException if any field is null, empty, or fails format checks.
     */
    public String registerUser(String username, String email, String password) {
        // 1. Validate Username (not null or empty)
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // 2. Validate Email (simple regex check)
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // 3. Validate Password (must be at least 8 characters)
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        return "User " + username + " registered successfully!";
    }
}

/**
 * This class provides a robust test suite for UserRegistration.
 * It covers "Happy Path" scenarios, boundary conditions, and
 * multiple failure modes using parameterized data.
 */
public class UserRegistrationTest {
    // Instance of the registration service
    private UserRegistration registration;

    /**
     * Sets up a fresh instance of the registration service before each test.
     */
    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }

    /**
     * Verifies that a perfectly formatted registration request succeeds.
     */
    @Test
    void testValidRegistration() {
        String result = registration.registerUser("JohnDoe", "john@example.com", "password123");
        Assertions.assertEquals("User JohnDoe registered successfully!", result);
    }

    /**
     * Parameterized test to check various validation failures.
     * It uses a CSV source to feed different combinations of invalid data.
     * * @param username The username input
     * @param email The email input
     * @param password The password input
     * @param scenario Description of the test case for readability
     */
    @ParameterizedTest(name = "Test {index}: {3}")
    @CsvSource({
            "'', john@example.com, password123, Empty Username",
            "JohnDoe, invalid-email, password123, Invalid Email Format",
            "JohnDoe, john@example.com, 12345, Short Password",
            ", john@example.com, password123, Null Username"
    })
    void testInvalidRegistrations(String username, String email, String password, String scenario) {
        // Asserts that the validation logic correctly rejects bad data with an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(username, email, password);
        }, "Failed for scenario: " + scenario);
    }

    /**
     * Specifically tests the boundary condition for password length.
     * Ensures that exactly 8 characters are accepted without error.
     */
    @Test
    void testPasswordBoundary() {
        Assertions.assertDoesNotThrow(() -> {
            registration.registerUser("User1", "user@test.com", "12345678");
        });
    }
}