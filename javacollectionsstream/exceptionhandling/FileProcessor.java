/**
 * This program demonstrates how to process multiple text files sequentially.
 * It uses a loop to iterate through a list of file paths and handles
 * IOExceptions locally within the loop so that a failure to read one file
 * does not stop the processing of subsequent files.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    /**
     * Iterates through a list of file paths, reading and printing the
     * contents of each file to the console.
     * * @param filePaths A list of Strings containing the paths to the files.
     */
    public static void processFiles(List<String> filePaths) {
        System.out.println("Starting batch file processing...");

        for (String path : filePaths) {
            System.out.println("\n--- Reading: " + path + " ---");

            // Try-with-resources ensures each BufferedReader is closed after the
            // current file is processed, even if an exception occurs.
            try (BufferedReader fileIn = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = fileIn.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                // Specific catch for missing files to provide clearer feedback
                System.out.println("Error: The file '" + path + "' was not found.");
            } catch (IOException e) {
                // Catch-all for other I/O related issues (permissions, interrupts, etc.)
                System.out.println("An I/O error occurred while processing: " + path);
                System.out.println("Details: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Initializing a list of file names to process
        List<String> fileList = new ArrayList<>();
        fileList.add("input1.txt");
        fileList.add("input2.txt");
        fileList.add("missing_file.txt"); // Included to test error handling

        // Initiate the batch processing
        processFiles(fileList);

        System.out.println("\nBatch processing sequence completed.");
    }
}