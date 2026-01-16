package ClassAndObject.Level2;

public class PalindromeChecker {
    String text = "kanak";

    boolean checkPalindrome() {
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }
        return text.equals(reverse);
    }

    void displayResult() {
        if (checkPalindrome())
            System.out.println(text + " is a Palindrome");
        else
            System.out.println(text + " is not a Palindrome");
    }

    public static void main(String[] args) {
        PalindromeChecker obj = new PalindromeChecker();
        obj.displayResult();
    }
}
