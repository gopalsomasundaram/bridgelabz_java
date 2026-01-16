package ControlFlowProblems.Level1;

import java.util.Scanner;
/*
 * This class validates if an input is a natural number (n >= 0).
 * If valid, it uses the mathematical formula (n * (n + 1)) / 2
 * to calculate the sum of the first 'n' natural numbers in constant time.
 */
public class NaturalNumber{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number to be checked and gotten sum of:");
    int n = scanner.nextInt();

    if(n>=0){

      // Applies the mathematical formula for the sum of the first n integers
      int sum = ((n*(n+1))/2);

      // Displays the calculated sum using string concatenation
      System.out.println("The sum of "+n+" natural numbers is "+sum);
    }else{

      // Executes if the input is negative, providing a clear error message
      System.out.println("The number "+n+" is not a natural number");
    }
  }
}
