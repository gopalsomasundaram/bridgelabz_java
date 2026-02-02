/**
 * This program compares the performance of unbuffered byte-by-byte
 * file copying versus buffered chunk-based file copying. It measures
 * execution time using System.nanoTime() to demonstrate efficiency gains.
 *
 * @author gopal;
 */
package streams;

import java.io.*;

public class EfficientFileCopy {

    /**
     * Copies a file byte-by-byte using raw FileInputStream and FileOutputStream.
     * This method is generally slower due to frequent system calls for single bytes.
     */
    public static long copyUnBuffered(File source, File out) {
        long start = System.nanoTime();
        // try-with-resources ensures raw streams are closed to prevent memory leaks
        try (FileInputStream fileIn = new FileInputStream(source);
             FileOutputStream fileOut = new FileOutputStream(out)) {

            int byteData;
            // Read and write one byte at a time until EOF (-1)
            while ((byteData = fileIn.read()) != -1) {
                fileOut.write(byteData);
            }
        } catch (IOException e) {
            System.err.println("Error in Unbuffered Copy: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }

    /**
     * Copies a file using Buffered streams and a byte array (4KB).
     * This significantly reduces disk I/O overhead by processing data in chunks.
     */
    public static long copyBuffered(File source, File out) {
        long start = System.nanoTime();
        // Wrapping raw streams in Buffered wrappers for high-speed I/O
        try (BufferedInputStream bufferIn = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(out))) {

            // 4KB buffer size aligns with most modern disk sector sizes
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read chunks of data into the array; returns actual number of bytes read
            while ((bytesRead = bufferIn.read(buffer)) != -1) {
                // Write only the portion of the buffer that contains actual data
                bufferOut.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error in Buffered Copy: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        File source = new File("Input.txt");
        File unbufferedOut = new File("UnbufferedInput.txt");
        File bufferedOut = new File("BufferedInput.txt");

        // Verify source exists before starting benchmark
        if (!source.exists()) {
            System.out.println("Source file 'Input.txt' not found. Please create it first.");
            return;
        }

        System.out.println("Starting performance comparison...");

        long timeUnBuffered = copyUnBuffered(source, unbufferedOut);
        long timeBuffered = copyBuffered(source, bufferedOut);

        // Convert nanoseconds to milliseconds for readability
        System.out.println("Unbuffered time: " + (timeUnBuffered / 1_000_000) + " ms");
        System.out.println("Buffered time:   " + (timeBuffered / 1_000_000) + " ms");

        if (timeBuffered > 0) {
            System.out.println("Performance improvement: " + (timeUnBuffered / timeBuffered) + "x faster");
        }
    }
}