package arrays.level2;

import java.util.Scanner;
/*
 * This class calculates the frequency of each digit (0-9) in a given number.
 * It uses one array to store the digits of the number and a second
 * "frequency" array to tally how many times each digit appears.
 */
public class Frequency {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        int count = 0;
        int copy = n;
        while(copy!=0){
            count++;
            copy/=10;
        }
        //Find the number of digits to size the first array
        int[] digits = new int[count];
        int index = 0;
        //Store each digit in an array
        while(n!=0){
            digits[index++]  = n%10;
            n/=10;
        }
        //Use a Frequency Array
        int[] frequency = new int[10];
        for(int i = 0;i<count;++i){
            frequency[digits[i]]++;
        }
        //Display results
        for(int i = 0;i<10;i++){
            System.out.printf("Frequency of %d is: %d\n",i,frequency[i]);
        }
    }
}
