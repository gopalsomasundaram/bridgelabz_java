package stringbuilderlinearbinary;

import java.util.HashSet;

/*
this class implements a method to remove duplicate characters from a
string while preserving the original order. it uses a HashSet for
$O(1)$ lookup time to track visited characters and a StringBuilder
to build the result efficiently.
*/
public class DuplicateRemover {

    //method to filter out duplicate characters
    public String removeDuplicates(String input) {
        //handle empty or null input
        if (input == null || input.isEmpty()) return input;

        //StringBuilder to store the unique characters
        StringBuilder sb = new StringBuilder();
        //HashSet to track characters already added to the result
        HashSet<Character> seen = new HashSet<>();

        //iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            //if character is new, add to set and append to builder
            if (!seen.contains(curr)) {
                seen.add(curr);
                sb.append(curr);
            }
        }

        return sb.toString();
    }

    //main function to test duplicate removal
    public static void main(String[] args) {
        DuplicateRemover remover = new DuplicateRemover();
        String test = "programming";
        System.out.println("Original: " + test);
        System.out.println("Result: " + remover.removeDuplicates(test));
    }
}
