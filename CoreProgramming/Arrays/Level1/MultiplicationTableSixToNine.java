package Arrays.Level1;

import java.util.Scanner;
/*
 * This class calculates a segment of a multiplication table (6 to 9).
 * It demonstrates manual index management to store results into
 * a small array of size 4.
 */
public class MultiplicationTableSixToNine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number who multiplication table you want from 6 to 9:");
        // We only need 4 slots (for 6, 7, 8, and 9)
        int[] arr =new int[4];
        int n = scanner.nextInt();
        int index=0;
        //Calculation Loop
        for(int i = 6;i<=9;i++){
            arr[index++] = i*n;
        }
        index = 0;
        //Display Loop
        for(int i =6;i<=9;i++){
            System.out.printf("%d * %d = %d\n",n,i,arr[index++]);
        }
    }
}
