package Methods.Level3;

import java.util.Arrays;
import java.util.Scanner;
public class NumberCheckerBase {
    int countDigits(int n){
        int count = 0;
        while(n!=0){
            count++;
            n/=10;
        }
        return count;
    }
    int[] getDigits(int n,int count){
        int[] digits = new int[count];
        int index = 0;
        while(n!=0){
            digits[index++] = n%10;
            n/=10;
        }
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
