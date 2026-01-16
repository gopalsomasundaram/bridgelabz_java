package ControlFlowProblems.Level2;

import java.util.Scanner;
/*
 * This class implements the FizzBuzz logic for numbers from 0 up to 'n'.
 * - Prints "FizzBuzz" if a number is divisible by both 3 and 5.
 * - Prints "Fizz" if divisible by 3.
 * - Prints "Buzz" if divisible by 5.
 * - Otherwise, prints the number itself.
 */
public class FizzBuzzUsingFor {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = scanner.nextInt();

    //Prevents execution for negative inputs
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }

    // Iterates from 0 through n inclusive
    for(int i = 0;i<=n;++i){
      // Priority Check: Must check divisibility by both 3 and 5 first
      if((i%3==0)&&(i%5==0)){
        System.out.println("FizzBuzz");
        continue;
      }
      // Secondary Check: Divisibility by 3
      else if(i%3==0){
        System.out.println("Fizz");
        continue;
      }
      // Tertiary Check: Divisibility by 5
      else if(i % 5 == 0){
        System.out.println("Buzz");
        continue;
      }
      // Default: Prints the number if no conditions above are met
      else{
        System.out.println(i);
      }
    }
  }
}
