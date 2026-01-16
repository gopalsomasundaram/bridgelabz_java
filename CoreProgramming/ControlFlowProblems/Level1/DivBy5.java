package ControlFlowProblems.Level1;

import java.util.Scanner;
/*
 * This class determines if a user-provided integer is divisible by 5.
 * It uses the modulo operator to check for a remainder of zero,
 * which indicates perfect divisibility, and outputs a yes/no response.
 */
public class DivBy5{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number:");
    int n = scanner.nextInt();

    // Checks if the remainder of n divided by 5 is equal to zero
    if(n%5 == 0){
      // Executes if the condition is true, indicating perfect divisibility
      System.out.println("Is the number "+n+" divisible by 5? yes");
    }else{
      // Executes if there is any remainder other than zero
      System.out.println("Is the number "+n+" divisible by 5? no");
    }
  }
}
