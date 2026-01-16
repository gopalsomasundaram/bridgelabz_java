package Arrays.Level2;

import java.util.Scanner;
/*
 * This class extracts the digits of an integer and stores them in an array.
 * Because digits are extracted from right-to-left, the resulting array
 * represents the number in reverse.
 */
public class ReverseDigits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        int copy = n;
        int count= 0;

        //Count digits to determine the required array size
        while(copy!=0){
            count++;
            copy/=10;
        }

        //Extract digits and store them (naturally stores the number in reverse order)
        int[] arr = new int[count];
        for(int i=0;i<count;++i){
            arr[i] = n%10;
            n/=10;
        }

        //Display the reversed digits
        for(int j : arr){
            System.out.println(j);
        }
        scanner.close();
    }
}
