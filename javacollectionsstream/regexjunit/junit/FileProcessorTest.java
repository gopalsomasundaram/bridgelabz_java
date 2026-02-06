/**
 * This Program implements a file I/O processing system and its unit tests
 * using JUnit 5. It demonstrates basic file handling operations such as
 * writing and reading content, alongside validation for file existence
 * and exception handling for missing resources.
 *
 * @author gopal
 */
package regexjunit.junit;

import java.io.*;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

/**
 * This class provides methods to interact with the file system.
 * It uses BufferedWriter for efficient writing and Scanner for reading,
 * including logic to ensure files exist before attempting to access them.
 */
class FileProcessor {
    // Method to write a string content to a specified file
    public void writeToFile(String filename, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
    }

    // Method to read and return the content of a specified file
    public String readFromFile(String filename) throws IOException {
        File file = new File(filename);
        // Explicit check for file existence to trigger specific error handling
        if (!file.exists()) {
            throw new IOException("File not found");
        }
        Scanner scanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        // Read each line and append to the result string
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        scanner.close();
        return builder.toString();
    }
}

/**
 * This class provides unit tests for the FileProcessor class.
 * It verifies successful file creation and reading, while also
 * ensuring appropriate cleanup of resources post-test.
 */
public class FileProcessorTest {
    // Instance of the processor to be tested
    FileProcessor processor = new FileProcessor();

    /**
     * Tests the full lifecycle of writing to and reading from a file.
     * Verifies existence on disk and content accuracy before deleting the file.
     */
    @Test
    void testFileHandling() throws IOException {
        String filename = "test_data.txt";
        String content = "JUnit Testing";

        // Perform the write operation
        processor.writeToFile(filename, content);

        File file = new File(filename);
        // Ensure the file was actually written to the system
        Assertions.assertTrue(file.exists(), "File should be created on disk");

        // Verify that the read content matches what was written
        String result = processor.readFromFile(filename);
        Assertions.assertEquals(content, result);

        // Cleanup: remove the test file from the disk
        file.delete();
    }

    /**
     * Tests that reading a non-existent file correctly throws an IOException.
     */
    @Test
    void testException() {
        Assertions.assertThrows(IOException.class, () -> {
            processor.readFromFile("missing_file.xyz");
        });
    }
}