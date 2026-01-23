package runtimeanalysis;

import java.io.*;

/*
this class evaluates the reading efficiency of FileReader versus
InputStreamReader for large files. it demonstrates that while
FileReader is convenient for text, wrapping InputStreamReader with
a buffer is typically more efficient for high-volume data processing.
*/
public class FileReadPerformance {

    public static void main(String[] args) {
        String filePath = "large_test_file.txt";

        //measure FileReader performance
        long start = System.currentTimeMillis();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null) { /* read line */ }
        } catch (IOException e) { System.out.println("File not found"); }
        System.out.println("FileReader time: " + (System.currentTimeMillis() - start) + "ms");

        //measure InputStreamReader performance
        start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) { /* read line */ }
        } catch (IOException e) { System.out.println("File not found"); }
        System.out.println("InputStreamReader time: " + (System.currentTimeMillis() - start) + "ms");
    }
}