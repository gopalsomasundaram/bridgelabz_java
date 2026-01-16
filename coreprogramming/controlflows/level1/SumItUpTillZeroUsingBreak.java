package controlflows.level1;

import java.util.Scanner;
/*
 * This class calculates the sum of user-provided integers using an infinite loop.
 * It uses the 'break' keyword to exit the loop immediately when the sentinel
 * value (0) is detected, demonstrating a common control flow pattern.
 */
public class SumItUpTillZeroUsingBreak {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int sum=0;

    System.out.println("Enter the numbers to be added one by one, enter 0 to stop and get result");
    int userInp;

    // Starts an infinite loop that runs until an internal 'break' is triggered
    while(true){
      userInp = scanner.nextInt();

      // Evaluates the input; if it is the sentinel value, it terminates the loop
      if(userInp == 0) break;
      else{
        // Executes if the number is not zero, adding it to the running total
        sum+=userInp;
      }
    }

    // Displays the final accumulated total after exiting the loop
    System.out.println("The sum is "+sum);
  }
}
