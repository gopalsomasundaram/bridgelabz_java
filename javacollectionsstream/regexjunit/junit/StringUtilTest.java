/**
 * This Program implements a suite of string manipulation utilities and their
 * corresponding unit tests using JUnit 5. It covers essential algorithms
 * such as string reversal, palindrome detection, and case conversion,
 * ensuring logical correctness through automated assertions.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class provides common utility methods for processing strings.
 * It utilizes manual character array manipulation and StringBuilder
 * to perform operations efficiently.
 */
class StringUtil{
    // Reverses a given string using a character array and StringBuilder
    public String reverse(String input){
        StringBuilder result = new StringBuilder();
        char[] arr = input.toCharArray();
        for(int i = arr.length-1;i>=0;--i){
            result.append(arr[i]);
        }
        return result.toString();
    }

    /**
     * Checks if a string reads the same forwards and backwards.
     * Uses a two-pointer approach for optimal O(n) performance.
     */
    public boolean isPalindrome(String input){
        int left = 0;
        int right = input.length()-1;
        char[] arr = input.toCharArray();
        while(left<right){
            if(arr[left]!=arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Converts all characters in a string to uppercase
    public String toUpperCase(String str){
        char[] arr = str.toCharArray();
        for(int i = 0;i<arr.length;++i){
            arr[i] = Character.toUpperCase(arr[i]);
        }
        return new String(arr);
    }
}

/**
 * This class provides unit tests for the StringUtil class.
 * It verifies that string transformations and boolean checks return
 * the expected results for various input cases.
 */
public class StringUtilTest {
    // Instance of the utility class to be tested
    private StringUtil stringUtilObject;

    /**
     * Initialization method that runs before each test.
     * Recreates the utility object to ensure test independence.
     */
    @BeforeEach
    void initObj(){
        stringUtilObject = new StringUtil();
    }

    // Verifies that the reverse method correctly flips the string order
    @Test
    void testReverse(){
        assertEquals("tset",stringUtilObject.reverse("test"));
    }

    // Verifies that the palindrome logic correctly identifies symmetrical strings
    @Test
    void testPalindrome(){
        assertTrue(stringUtilObject.isPalindrome("kanak"));
    }

    // Verifies that characters are correctly mapped to their uppercase counterparts
    @Test
    void testUppercase(){
        assertEquals("TEST",stringUtilObject.toUpperCase("test"));
    }
}