/**
 * This program reads a text file and writes its contents to a new file
 * while converting all characters to uppercase. It uses Buffered
 * streams for efficiency and explicitly handles UTF-8 encoding.
 *
 * @author gopal;
 */
package streams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CaseConverter {
    public static void main(String[] args) {
        String inputPath = "Input.txt";
        String outputPath = "output_uppercase.txt";

        // Step 1: Create a dummy file for testing if it doesn't exist
        createDummyFile(inputPath);

        // Using try-with-resources to ensure all bridge and buffered streams are closed
        try (
                // InputStreamReader converts bytes from FileInputStream into characters using UTF-8
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8));

                // OutputStreamWriter converts characters back to bytes for FileOutputStream
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8))
        ) {
            String line;
            System.out.println("Processing file and converting to uppercase...");

            // readLine() reads text until a newline is encountered
            while ((line = reader.readLine()) != null) {
                // Convert the string to uppercase and write to the buffer
                writer.write(line.toUpperCase());

                // readLine() consumes the newline character, so we must add it back manually
                writer.newLine();
            }

            System.out.println("Success! Uppercase content saved to: " + outputPath);

        } catch (FileNotFoundException e) {
            System.out.println("The source file was not found.");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred during the conversion process.");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Helper method to generate a test file if one is not present.
     * * @param path The filename to create.
     */
    private static void createDummyFile(String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write("java file i/o is powerful!\nthis is a test file.");
        } catch (IOException ignored) {
            // Failure to create a dummy file is not fatal to the demonstration
        }
    }
}