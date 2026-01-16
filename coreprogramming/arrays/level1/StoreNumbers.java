package arrays.level1;
import java.util.Scanner;
/*
 * This class stores up to 10 positive integers in an array.
 * It uses an infinite loop with conditional breaks to handle input.
 * Finally, it calculates the sum of only the valid numbers entered.
 */
public class StoreNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Fixed-size array to hold 10 integers
        int[] arr = new int[10];
        int input;
        int index_inp=0;
        while(true){
            input = scanner.nextInt();
            // Break Conditions:
            // 1. index_inp >= 10: Array capacity reached
            // 2. input <= 0: User wants to stop or entered invalid data
            if(index_inp>=10||input<=0) break;

            // Store valid input and move to the next index
            arr[index_inp] = input;
            index_inp++;
        }
        int sum = 0;
        //Summation Logic
        for(int i = 0;i<index_inp;i++){
            sum+=arr[i];
        }
        System.out.println("The sum is "+sum);
        scanner.close();
    }
}
