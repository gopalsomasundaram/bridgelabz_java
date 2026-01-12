package Arrays.Level2;

import java.util.Scanner;
public class LargestAndSecondLargestReworked {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number");
        long n = scanner.nextLong();

        int maxDigits = 10;
        int[] arr = new int[maxDigits];
        int index = 0;

        while(n!=0){
            if(index == maxDigits){
                int[] biggerArr = new int[maxDigits+10];
                for(int i  = 0;i<maxDigits;++i){
                    biggerArr[i] = arr[i];
                }
                arr = biggerArr;
                maxDigits+=10;
            }
            arr[index++] = (int)(n%10);
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
        System.out.println("The largest is "+largest+" and the second largest is "+secondLargest);
        scanner.close();
    }
}
