package controlflows.level2;

import java.util.Scanner;
/*
 * This class uses a while loop to find all integers between 1 and 100
 * that have a divisibility relationship with the input 'n'.
 * It checks for both factors (n % i == 0) and multiples (i % n == 0).
 */
public class MultiplesBelowHundredUsingWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find multiples of");
        int n = scanner.nextInt();

        //Ensures n is within the searchable range of 1-100
        if(n<=0 || n > 100){
            System.out.println("Invalid Input");
            return;
        }
        int i = 100;

        // Condition: Runs as long as the next value to be checked is greater than 0
        while(i-1>0){
            i--;
            // Logic A: Checks if 'i' is a factor of the input 'n'
            if(n%i==0){
                System.out.println(i);
                continue;
            }
            // Logic B: Checks if 'i' is a multiple of the input 'n'
            else if(i%n == 0){
                System.out.println(i);
                continue;
            }
        }
    }
}
