package Arrays.Level1;

import java.util.Scanner;
/*
 * This class implements FizzBuzz by storing results in a String array.
 * It maps each integer from 0 to 'n' to its corresponding FizzBuzz string.
 * This demonstrates how to store mixed types (text and numbers) by
 * converting integers to Strings.
 */
public class FizzBuzz {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");

        // We create an array of size n+1 to accommodate numbers from 0 to n.
        int n = scanner.nextInt();
        String[] arr = new String[n+1];

        //Logic and Storage
        for(int i =0;i<=n;++i){
            // Check divisibility by both 3 and 5 first (Multiple of 15)
            if(i%3==0 && i%5==0){
                arr[i] = "FizzBuzz";
            }
            else if(i%3 == 0){
                arr[i] = "Fizz";
            }
            else if(i%5==0){
                arr[i] = "Buzz";
            }
            else{
                //converts the number to text
                arr[i] = Integer.toString(i);
            }
        }
        for(String i : arr){
            System.out.println(i);
        }
        scanner.close();
    }
}
