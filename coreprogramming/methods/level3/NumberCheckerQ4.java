package methods.level3;

import java.util.Scanner;
/*
 * This class checks for Palindromes and Duck Numbers.
 * It demonstrates array reversal and deep comparison between arrays.
 */
public class NumberCheckerQ4 extends NumberCheckerBase{
    // A Duck number contains a 0 that is not at the start
    boolean isDuckNumber(int[] arr){
        for(int i = 0;i<arr.length;++i){
            if(i==0&&arr[i]==0){
                return false;
            }
            if(arr[i] == 0){
                return true;
            }
        }
        return false;
    }
    // Swaps elements from outside-in to reverse the array in place
    void reverseArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    // Performs a "Deep Comparison" of two arrays
    boolean isEqualArrays(int[] arr1, int[] arr2){
        if(arr1.length!= arr2.length) return false;
        for(int i = 0;i<arr1.length;++i){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    // Check if a number reads the same forward and backward
    boolean isPalindrome(int[] arr){
        int[] revArr = new int[arr.length];
        System.arraycopy(arr, 0, revArr, 0, arr.length);
        reverseArray(revArr);
        return isEqualArrays(revArr,arr);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        NumberCheckerQ4 obj = new NumberCheckerQ4();
        int[] digits =obj.getDigits(n, obj.countDigits(n));
        obj.reverseArray(digits);
        //display results
        for(int i : digits){
            System.out.println(i);
        }
        if(obj.isEqualArrays(digits, digits)) System.out.println("Equal arrays");
        else System.out.println("Unequal Arrays");
        if(obj.isPalindrome(digits)){
            System.out.println("It is a palindrome");
        }
        else{
            System.out.println("It is not a palindrome");
        }
        if(obj.isDuckNumber(digits)){
            System.out.println("it is a duck number");
        }else{
            System.out.println("it is not a duck number");
        }
        scanner.close();
    }
}
