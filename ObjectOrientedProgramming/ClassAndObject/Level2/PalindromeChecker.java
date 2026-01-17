package ClassAndObject.Level2;
/*
 * This class encapsulates palindrome checking logic within an object.
 * It demonstrates a method returning a boolean value based on internal state.
 */
public class PalindromeChecker {
    //Attribute
    String text = "kanak";

    boolean checkPalindrome() {
        // 2. Logic Behavior: Reverses the string and compares
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }
        return text.equals(reverse);
    }
    //Output Behavior: Uses the logic method to decide what to print
    void displayResult() {
        if (checkPalindrome())
            System.out.println(text + " is a Palindrome");
        else
            System.out.println(text + " is not a Palindrome");
    }

    public static void main(String[] args) {
        //Instantiation
        PalindromeChecker obj = new PalindromeChecker();
        //Execution
        obj.displayResult();
    }
}
