package controlflows.level1;

import java.util.Scanner;
/*
 * This class continuously sums user-provided integers until the user enters 0.
 * It uses a while loop with a sentinel value (0) to control the execution flow,
 * accumulating the total in a running sum variable.
 */
public class SumItUpTillZero {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the numbers to be added one by one, enter 0 to stop and get result");

    int sum = 0;
    int userInp = scanner.nextInt();

    // Continues the loop as long as the entered number is not the sentinel value (0)
    while(userInp!=0){
      // Adds the current input to the running total
      sum+=userInp;
      userInp = scanner.nextInt();
    }

    // Displays the final accumulated total after the loop terminates
    System.out.println("The sum is "+sum);
  }
}
