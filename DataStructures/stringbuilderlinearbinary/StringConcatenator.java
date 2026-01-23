package stringbuilderlinearbinary;

/*
this class demonstrates efficient string concatenation using
StringBuffer. unlike String, StringBuffer is mutable and does
not create new objects in memory during every append operation,
making it ideal for joining multiple strings in a loop.
*/
public class StringConcatenator {

    //method to concatenate an array of strings
    public String joinStrings(String[] words) {
        //handle null array
        if (words == null) return null;

        //creating a thread-safe mutable string container
        StringBuffer sb = new StringBuffer();

        //iterate through the array and append each word
        for (String s : words) {
            sb.append(s);
        }

        return sb.toString();
    }

    //main function to test concatenation
    public static void main(String[] args) {
        StringConcatenator obj = new StringConcatenator();
        String[] input = {"Java", "Is", "Great"};
        System.out.println("Concatenated: " + obj.joinStrings(input));
    }
}