/**
 * This program demonstrates the simultaneous handling of checked and
 * unchecked exceptions. It reads numerical data from a file and performs
 * division, managing both environmental failures (missing files) and
 * logical/runtime failures (division by zero or bad data format).
 *
 * @author gopal;
 */
package exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HandleCheckedAndUncheckedExceptions {

    /**
     * Reads a file line-by-line and divides a given number by the value
     * found in the file.
     * * @param fileName The path to the source data file.
     * @param dividend The numerator for the division operation.
     * @throws IOException (Checked) Must be declared because FileReader
     * and readLine() are used.
     */
    public static void processData(String fileName, int dividend) throws IOException {
        // Try-with-resources handles the automatic closing of the file stream
        try (BufferedReader fileInput = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = fileInput.readLine()) != null) {
                try {
                    // Potential NumberFormatException (Unchecked) if line isn't a valid integer
                    int val = Integer.parseInt(line.trim());

                    // Potential ArithmeticException (Unchecked) if val is 0
                    System.out.println("Result of " + dividend + " / " + val + " = " + (dividend / val));

                } catch (ArithmeticException e) {
                    System.err.println("Math Error: Cannot divide by zero found in file.");
                } catch (NumberFormatException e) {
                    System.err.println("Data Error: Could not parse '" + line + "' as an integer.");
                }
            }
        }
    }

    public static void main(String[] args) {
        String targetFile = "xyz.txt";

        try {
            // Initiating data processing
            processData(targetFile, 23);

        } catch (IOException e) {
            // Handling the Checked Exception declared in the method signature
            System.err.println("Critical IO Error: The file '" + targetFile + "' could not be accessed.");
            System.err.println("Reason: " + e.getMessage());

        } catch (Exception e) {
            // Safety net for any other unforeseen issues
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}