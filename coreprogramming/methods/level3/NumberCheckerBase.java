package methods.level3;

/*
 * This class serves as a utility for breaking down integers.
 * It provides methods to count digits and convert a number into an array.
 */
public class NumberCheckerBase {
    // Method 1: Iteratively counts the number of digits
    int countDigits(int n){
        int count = 0;
        while(n!=0){
            count++;
            n/=10;
        }
        return count;
    }
    // Method 2: Converts an integer into an array of its digits
    int[] getDigits(int n,int count){
        int[] digits = new int[count];
        int index = 0;
        //Extract digits (they will be in reverse order)
        while(n!=0){
            digits[index++] = n%10;
            n/=10;
        }
        //Reverse the array using two pointers (left and right)
        int left = 0;
        int right = count-1;
        while(left<right){
            int temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;
            left++;
            right--;
        }
        return digits;
    }
}
