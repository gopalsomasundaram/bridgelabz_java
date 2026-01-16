package arrays.Level2;

import java.util.Scanner;
/*
 * This class identifies the largest and second-largest digits in a number.
 * It uses a single loop to compare elements, ensuring the second-largest
 * is updated whenever a new largest digit is discovered.
 */
public class LargestAndSecondDigits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        //Extract digits into a fixed-size array
        int[] arr = new int[10];
        int i = 0;

        // Logic: Stop if the number is fully processed OR we hit 10 digits
        while(n!=0 && i<10){
            arr[i++] = n%10;
            n/=10;
        }

        //Initialize with the smallest possible integer value
        int largest = Integer.MIN_VALUE;
        int secondLargest = largest;

        //Find Largest and Second Largest in one pass
        for(int j : arr){
            if(j>largest){
                secondLargest = largest;
                largest = j;
            }
            else if(j< largest && j > secondLargest){
                secondLargest = j;
            }
        }
        System.out.println("The largest digit is "+largest+" and the second largest is "+secondLargest);
        scanner.close();
    }
}
