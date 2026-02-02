/**
 * This program demonstrates the transition from manual resource management
 * to Automatic Resource Management (ARM). It illustrates how the
 * try-with-resources statement ensures that system resources like file
 * handles are released, preventing memory leaks.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.io.*;

public class ResourceCleanupDemo {
    public static void main(String[] args) {
        /*
         * Using try-with-resources to manage the BufferedReader.
         * The resource is declared within the parentheses and is
         * automatically closed when the try block exits, whether
         * normally or due to an exception.
         */
        try (BufferedReader fileInput = new BufferedReader(new FileReader("user_profile.txt"))) {

            String line;
            System.out.println("Reading contents of 'user_profile.txt':");

            // Iterating through the file until the end (EOF)
            while ((line = fileInput.readLine()) != null) {
                System.out.println(line);
            }

            // No explicit .close() call is needed here; Java handles it.

        } catch (FileNotFoundException e) {
            // Specific catch for a missing file to provide clear user feedback
            System.err.println("Error: The specified file 'user_profile.txt' was not found.");

        } catch (IOException e) {
            // General catch for other input/output interruptions
            System.err.println("There was an IO Exception: " + e.getMessage());
        }
    }
}