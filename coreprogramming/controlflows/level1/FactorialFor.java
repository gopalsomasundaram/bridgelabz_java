package controlflows.level1;

import java.util.Scanner;
/*
 * This class calculates the factorial of a user-provided integer using a for loop.
 * It includes a guard clause to handle invalid negative inputs and uses
 * iterative multiplication to find the product of all integers from 1 to n.
 */
public class FactorialFor{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number whose factorial needs to be found:");
    int n = scanner.nextInt();

    // Validates input: factorials are only defined for non-negative integers
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }

    int result = 1;
    // Iterates from 1 up to n, multiplying the result by the current index i
    for(int i =1;i<=n;++i){
      result*=i;
    }

    // Concatenates the final calculated factorial into a descriptive message
    System.out.println("The factorial is "+result);
  }
}
