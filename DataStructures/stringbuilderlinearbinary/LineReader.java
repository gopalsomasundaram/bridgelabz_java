package stringbuilderlinearbinary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
this class reads a text file line by line using FileReader and
BufferedReader. BufferedReader provides efficient reading by
buffering characters, reducing the number of I/O operations.
*/
public class LineReader {

    //method to read and print file contents
    public void readFile(String fileName) {
        //using try-with-resources to ensure file is closed
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            //read until end of file
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LineReader reader = new LineReader();
        reader.readFile("test.txt");
    }
}