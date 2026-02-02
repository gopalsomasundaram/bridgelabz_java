/**
 * This program reads and displays only the first line of a given text file.
 * It demonstrates efficient resource management using try-with-resources
 * and the specific behavior of BufferedReader's readLine() method.
 *
 * @author gopal;
 */
package exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFirstLine {
    public static void main(String[] args) {
        // We use try-with-resources to ensure the BufferedReader and its
        // underlying FileReader are closed automatically after the operation.
        try (BufferedReader fileIn = new BufferedReader(new FileReader("info.txt"))) {

            // readLine() reads a single line of text up to a newline or EOF.
            // If the file is empty, this will return null.
            String line = fileIn.readLine();

            if (line != null) {
                System.out.println("First line content: " + line);
            } else {
                System.out.println("The file is empty.");
            }

        } catch (IOException e) {
            // This block handles cases where the file "info.txt" is missing
            // or if there is a hardware interruption while reading.
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}