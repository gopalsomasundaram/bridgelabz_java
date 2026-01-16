package controlflows.Level1;

import java.util.Scanner;
/*
 * This class determines the largest of three user-provided integers.
 * It uses nested if-else statements to perform a step-by-step comparison,
 * first comparing two numbers and then comparing the winner against the third.
 */
public class LargestInteger {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number");
    int n1 = scanner.nextInt();
    System.out.println("Enter the second number");
    int n2 = scanner.nextInt();
    System.out.println("Enter the third number");
    int n3 = scanner.nextInt();

    // Step 1: Compare the first and second numbers
    if(n1>n2){
      // Step 2a: If n1 is bigger than n2, check if it's also bigger than n3
      if(n1>n3){
        System.out.println("The first number is the largest");
      }
      else{
        // If n1 was bigger than n2 but smaller than n3, n3 is the winner
        System.out.println("The third number is the largest");
      }
    }
    else{
      // Step 2b: If n2 is bigger than (or equal to) n1, check if n2 is bigger than n3
      if(n2>n3){
        System.out.println("The second number is the largest");
      }
      else{
        // If n2 was bigger than n1 but smaller than n3, n3 is the winner
        System.out.println("The third number is the largest");
      }
    }
  }
}
