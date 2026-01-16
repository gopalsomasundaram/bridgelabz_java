package String.Level1;

import java.util.Scanner;
import java.util.Arrays;

public class CompareCharArray {
    char[] customToCharArray(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
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
        char[] manualArray = obj.customToCharArray(input);
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
