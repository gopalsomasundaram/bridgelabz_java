package ControlFlowProblems.Level1;

import java.util.Scanner;
/*
 * This class performs a countdown from a user-provided integer.
 * It uses a while loop that continues to decrement and print
 * the value of 'n' until it reaches the sentinel value of 1.
 */
public class WhileCountdown{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number to start counting from");
    int n = scanner.nextInt();

    // Continues the loop as long as the current value of n is not 1
    while(n!=1){
      n--;
      // Displays the current value of n to the console
      System.out.println(n);
    }
  }
}
