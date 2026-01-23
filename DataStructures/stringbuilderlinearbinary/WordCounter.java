package stringbuilderlinearbinary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
this class counts the occurrences of a specific word in a text file.
it reads the file line by line, splits each line into words using
regex, and increments a counter for matches.
*/
public class WordCounter {

    //method to count occurrences of target word
    public int countWord(String fileName, String target) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                //splitting line by whitespace and punctuation
                String[] words = line.split("\\W+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(target)) count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        System.out.println("Count: " + wc.countWord("data.txt", "Java"));
    }
}