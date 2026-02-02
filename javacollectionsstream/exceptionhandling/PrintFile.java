/**
 * This program reads and displays the contents of a text file line-by-line.
 * It demonstrates the use of BufferedReader for efficient character reading
 * and the try-with-resources statement for automatic resource management.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {
    public static void main(String[] args) {
        // We use try-with-resources to ensure that both the FileReader and
        // the BufferedReader are closed automatically once the block finishes.
        try (BufferedReader fileIn = new BufferedReader(new FileReader("data.txt"))) {

            // Variable to hold each line of text as it is read from the file
            String lineData;

            // readLine() returns null when the end of the file is reached
            while ((lineData = fileIn.readLine()) != null) {
                // Display the current line to the console
                System.out.println(lineData);
            }

        } catch (IOException e) {
            // This block catches issues like missing files (FileNotFoundException)
            // or errors that occur during the reading process.
            System.out.println("Error: The file could not be read or was not found.");

            // e.getMessage() returns the specific reason for the failure
            System.out.println("Technical Details: " + e.getMessage());
        }
    }
}