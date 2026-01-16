package controlflows.level3;
import java.util.Scanner;
/*
 * This class counts the number of digits in a user-provided integer.
 * It uses a while loop to perform integer division by 10, which
 * removes the last digit of the number in each iteration.
 */
public class CountDigits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();

        int count=0;
        // Loop runs as long as there are digits left to process.
        while(n!=0)
        {
            // Increment the count for every digit removed.
            count++;
            n/=10;
        }
        System.out.println("Number of digits in given number = "+count);
    }
}
