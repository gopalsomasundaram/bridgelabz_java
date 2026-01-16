package arrays.level1;

import java.util.Scanner;
/*
 * This class calculates the multiplication table of a number (from 1 to 10).
 * It stores each result in an array and uses formatted printing to display
 * the table in a standard "n * i = result" format.
 */
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number you want multiplication table of:");
        int n = scanner.nextInt();
        // We create an array of size 10 to store results for 1 through 10.
        int[] arr = new int[10];
        for(int i = 0;i<arr.length;++i){
            // Logic: The multiplier is (i + 1) because indices start at 0.
            arr[i] = (i+1)*n;
            System.out.printf("%d * %d = %d\n",n,i+1,arr[i]);
        }
        scanner.close();
    }
}
