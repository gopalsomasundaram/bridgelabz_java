package controlflows.level2;

import java.util.Scanner;
/*
 * This class implements the FizzBuzz logic using a while loop.
 * It increments the counter at the start of each iteration,
 * effectively checking numbers from 1 up to 'n' inclusive.
 */
public class FizzBuzzUsingWhile {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = scanner.nextInt();

    //Checks for negative input
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    int i = 0;

    // Continues the loop as long as i is strictly less than the user's number
    while(i<n){
      i++;

      // Multi-condition check: Divisible by 3 AND 5 (Multiple of 15)
      if((i%3==0)&&(i%5==0)){
        System.out.println("FizzBuzz");
        continue;
      }
      // Check for multiples of 3 only
      else if(i%3==0){
        System.out.println("Fizz");
        continue;
      }
      // Check for multiples of 5 only
      else if(i%5==0){
        System.out.println("Buzz");
        continue;
      }
      // Executes if none of the above conditions are true
      else{
        System.out.println(i);
      }
    }
  }
}
