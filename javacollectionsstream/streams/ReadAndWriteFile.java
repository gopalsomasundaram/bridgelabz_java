/**
 * This java program reads the contents of a file and writes it to a
 * new file using FileInputStream and FileOutputStream. It also
 * manages cases where input file is not present or Input /
 * output interrupts or exceptions
 *
 * @author gopal;
 */
package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//Main class for implementation of file copy
public class ReadAndWriteFile {
    public static void main(String[] args){
        //using try with resource to close resources automatically after operation
        //File input Stream
        try(FileInputStream fileInput = new FileInputStream("Input.txt");
            //File Output stream
        FileOutputStream fileOutput = new FileOutputStream("Output.txt")){
            //variable to hold individual byte while allowing expression of -1 as EOF
            int byteData;
            //copy byte to var while not -1
            while((byteData = fileInput.read())!=-1){
                //write to new file
                fileOutput.write(byteData);
            }
            System.out.println("File Copied");
            //Exception where input file is not present
        }catch(FileNotFoundException e){
            System.out.println("File was not found");
            System.out.println(e.getMessage());
            //Exception where IO operation is interrupted
        }catch(IOException e){
            System.out.println("IO Exception");
            System.out.println(e.getMessage());
        }
    }
}
