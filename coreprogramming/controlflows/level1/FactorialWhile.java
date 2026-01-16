package controlflows.level1;

import java.util.Scanner;
/*
 * This class calculates the factorial of a number using a 'while' loop.
 * It uses a decreasing iteration strategy, multiplying the current
 * number and then decrementing it until it reaches zero.
 */
public class FactorialWhile{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number whose factorial needs to be found:");
    int n = scanner.nextInt();

    // Guard Clause: Ensures the input is non-negative to avoid infinite loops or errors
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    int result = 1;
    // Executes as long as n is greater than 0, effectively counting down
    while(n>0){
      result*=n;
      n--;
    }

    // Concatenates the final result for display
    System.out.println("The factorial of given number is "+result);
  }
}
