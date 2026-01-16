package strings.level1;

import java.util.Scanner;
import java.util.Arrays;
/*
 * This class compares a manual string-to-character-array conversion
 * with Java's built-in .toCharArray() method.
 */
public class CompareCharArray {
    // Method 1: Manually extracting characters from a String
    char[] customToCharArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
    // Method 2: Comparing two character arrays element-by-element
    boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompareCharArray obj = new CompareCharArray();
        System.out.println("Enter a string to convert to a character array:");
        String input = scanner.next();
        // 1. Convert manually using custom method
        char[] manualArray = obj.customToCharArray(input);
        // 2. Convert using the built-in Java library method
        char[] builtInArray = input.toCharArray();
        boolean isEqual = obj.compareArrays(manualArray, builtInArray);
        System.out.println("Manual Array: " + Arrays.toString(manualArray));
        System.out.println("Built-in Array: " + Arrays.toString(builtInArray));
        if (isEqual) {
            System.out.println("The result for both methods are the same.");
        } else {
            System.out.println("The result for both methods are NOT the same.");
        }
        scanner.close();
    }
}
