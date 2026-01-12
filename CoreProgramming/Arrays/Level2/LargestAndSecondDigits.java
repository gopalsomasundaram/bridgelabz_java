package Arrays.Level2;

import java.util.Scanner;
public class LargestAndSecondDigits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        int[] arr = new int[10];
        int i = 0;
        while(n!=0 && i<10){
            arr[i++] = n%10;
            n/=10;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = largest;
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
