package stringbuilderlinearbinary;

/*
this class demonstrates the use of the StringBuilder class to reverse
 a string. StringBuilder is used for its mutable nature, allowing for
efficient string manipulations like reversal without creating multiple
intermediate string objects.
*/
public class StringReverser {

    //method to reverse a string using StringBuilder's built-in functionality
    public String reverseString(String input) {
        //handle case where input is null
        if (input == null) {
            return null;
        }

        //creating a new StringBuilder object with the input string
        StringBuilder sb = new StringBuilder(input);

        //using the built-in reverse() method to flip the characters
        sb.reverse();

        //converting the StringBuilder back to a standard String and returning it
        return sb.toString();
    }

    /*
    this main method serves as the entry point for the program. it
    initializes a test string, calls the reversal method, and
    displays the results.
    */
    public static void main(String[] args) {
        //object creation
        StringReverser reverser = new StringReverser();

        //test input string
        String original = "hello";

        //performing the reversal
        String result = reverser.reverseString(original);

        //displaying the original and the reversed strings
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + result);
    }
}
