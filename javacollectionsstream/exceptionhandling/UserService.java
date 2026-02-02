/**
 * This program simulates a user management service. It defines and utilizes
 * multiple custom checked exceptions (UserAlreadyExistsException and
 * UserNotFoundException) to handle specific business logic failures
 * during registration and search operations.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom checked exception thrown when an attempt is made to register
 * a username that is already present in the system.
 */
class UserAlreadyExistsException extends Exception {
    UserAlreadyExistsException(String message) {
        super(message);
    }
}

/**
 * Custom checked exception thrown when a search operation fails to
 * find a specific username in the user list.
 */
class UserNotFoundException extends Exception {
    UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {
    // Internal storage for usernames using a dynamic ArrayList
    List<String> userList = new ArrayList<>();

    /**
     * Registers a new user in the list after checking for duplicates.
     * @param username The name to be registered.
     * @throws UserAlreadyExistsException if the name is already in userList.
     */
    public void registerUser(String username) throws UserAlreadyExistsException {
        if (userList.contains(username)) {
            // Throwing custom exception to signal a registration conflict
            throw new UserAlreadyExistsException("Registration Error: User '" + username + "' is already registered.");
        } else {
            userList.add(username);
            System.out.println("User '" + username + "' registered successfully.");
        }
    }

    /**
     * Checks if a user exists in the system.
     * @param username The name to search for.
     * @throws UserNotFoundException if the name is not found in userList.
     */
    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!userList.contains(username)) {
            // Throwing custom exception to signal a search failure
            throw new UserNotFoundException("Search Error: User '" + username + "' could not be found in the list.");
        } else {
            System.out.println("User '" + username + "' confirmed in system.");
        }
    }

    public static void main(String[] args) {
        UserService service = new UserService();

        try {
            // Step 1: Successful registrations
            service.registerUser("Adam");
            service.registerUser("Baron");
            service.registerUser("Zack");

            // Step 2: This will trigger UserAlreadyExistsException
            System.out.println("\nAttempting duplicate registration...");
            service.registerUser("Zack");

            // Step 3: This would trigger UserNotFoundException (if previous step didn't exit)
            service.checkUserExistence("Brock");

        } catch (UserAlreadyExistsException e) {
            // Specific handling for duplicate users
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            // Specific handling for missing users
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // General safety net
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}