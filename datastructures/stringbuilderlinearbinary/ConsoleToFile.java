package stringbuilderlinearbinary;

import java.io.*;

/*
this class reads user input from the console and writes it to a file.
it uses InputStreamReader to bridge the byte stream (System.in) and
character stream, writing until the user types 'exit'.
*/
public class ConsoleToFile {

    public static void main(String[] args) {
        //bridging byte stream to character stream
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try (FileWriter fw = new FileWriter("output.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Enter text (type 'exit' to quit):");
            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(input);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}