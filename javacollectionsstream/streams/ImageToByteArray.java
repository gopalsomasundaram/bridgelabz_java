/**
 * This program demonstrates how to convert a binary image file into a byte array
 * using ByteArrayOutputStream and then reconstruct the image file from that
 * array using ByteArrayInputStream.
 * * It includes a verification step to ensure data integrity during the
 * conversion process.
 *
 * @author gopal;
 */
package streams;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImagePath = "lenna.png";
        String outputImagePath = "reconstructed_image.png";

        try {
            // STEP 1: Load image into RAM as a byte array
            byte[] imageBytes = convertImageToByteArray(sourceImagePath);
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");

            // STEP 2: Write that RAM-resident byte array back to a physical file
            writeByteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Byte array written back to: " + outputImagePath);

            // STEP 3: Binary comparison to ensure the reconstruction is 100% accurate
            verifyFiles(sourceImagePath, outputImagePath);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Source image not found. Please ensure 'lenna.png' exists.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    /**
     * Reads a file and writes its content into an expandable byte array in memory.
     */
    private static byte[] convertImageToByteArray(String path) throws IOException {
        File file = new File(path);
        // ByteArrayOutputStream grows automatically as data is written to it
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from disk and write to the memory stream
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            // convert the stream content into a primitive byte array
            return baos.toByteArray();
        }
    }

    /**
     * Takes a byte array and streams it into a FileOutputStream to recreate the file.
     */
    private static void writeByteArrayToImage(byte[] data, String path) throws IOException {
        // ByteArrayInputStream allows us to treat a byte array as an input stream
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(path)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from memory and write back to disk
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    /**
     * Compares two files byte-by-byte to verify they are identical.
     */
    private static void verifyFiles(String path1, String path2) throws IOException {
        // Files.readAllBytes is a convenient utility for small-to-medium files
        byte[] f1 = Files.readAllBytes(new File(path1).toPath());
        byte[] f2 = Files.readAllBytes(new File(path2).toPath());

        // Arrays.equals checks both length and every individual byte value
        if (Arrays.equals(f1, f2)) {
            System.out.println("Verification Success: The files are identical!");
        } else {
            System.out.println("Verification Failed: The files differ.");
        }
    }
}