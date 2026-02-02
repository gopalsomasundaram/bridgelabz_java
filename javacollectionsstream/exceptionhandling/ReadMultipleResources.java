/**
 * This program demonstrates how to manage multiple I/O resources simultaneously.
 * It reads content from two separate input files and merges them into a
 * single output file, ensuring all streams are closed automatically.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.io.*;

public class ReadMultipleResources {
    public static void main(String[] args) {
        // Declaring multiple resources within the try-with-resources statement.
        // Resources are separated by semicolons and closed in reverse order.
        try (
                BufferedReader fileIn1 = new BufferedReader(new FileReader("input1.txt"));
                BufferedReader fileIn2 = new BufferedReader(new FileReader("input2.txt"));
                BufferedWriter fileOut = new BufferedWriter(new FileWriter("output1.txt"))
        ) {
            String line;
            System.out.println("Starting file merge operation...");

            // Process first input file
            while ((line = fileIn1.readLine()) != null) {
                fileOut.write(line);
                // newLine() provides platform-independent line breaks
                fileOut.newLine();
            }

            // Explicitly flushing can be useful, but try-with-resources
            // will handle the final flush and close automatically.
            fileOut.flush();

            // Process second input file
            while ((line = fileIn2.readLine()) != null) {
                fileOut.write(line);
                fileOut.newLine();
            }

            System.out.println("Merge complete! Content saved to output1.txt");

        } catch (FileNotFoundException e) {
            // Specific handling for missing source files
            System.err.println("Error: One of the input files was not found.");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            // Catch-all for other I/O related issues
            System.err.println("An I/O exception occurred during processing.");
            System.err.println(e.getMessage());
        }
    }
}