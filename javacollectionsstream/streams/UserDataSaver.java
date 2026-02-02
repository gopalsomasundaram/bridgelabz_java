/**
 * This program captures user input from the console (System.in) and
 * writes the collected data to a text file. It utilizes BufferedReader
 * for efficient input handling and BufferedWriter for optimized file writing.
 *
 * @author gopal;
 */
package streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserDataSaver {
    public static void main(String[] args) {
        // We wrap System.in (bytes) into an InputStreamReader (characters)
        // and finally into a BufferedReader for line-by-line reading capability.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("user_profile.txt");
             BufferedWriter writer = new BufferedWriter(fw)) {

            // Collecting User Input via the console
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Formatting the data using %n for platform-independent newlines
            // This ensures the file is readable on Windows, Linux, and macOS.
            String data = String.format("Name: %s%nAge: %s%nFavorite Language: %s%n",
                    name, age, language);

            // Writing the formatted string to the buffered file writer
            writer.write(data);

            System.out.println("\nSuccess! Information saved to 'user_profile.txt'.");

        } catch (IOException e) {
            // Catching potential issues such as file permissions or hardware interrupts
            System.err.println("An error occurred while handling files or input: " + e.getMessage());
        }
    }
}