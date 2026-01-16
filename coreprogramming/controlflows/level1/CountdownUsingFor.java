package controlflows.level1;

import java.util.Scanner;
/*
 * This class performs a countdown from a user-provided integer down to 1.
 * It utilizes a for loop where the counter is initialized to the input value
 * and decremented in each iteration until the stop condition is met.
 */
public class CountdownUsingFor {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number to countdown from:");
    int n = scanner.nextInt();

    // Initializes i at n; continues as long as i is not 1; decreases i by 1 each time
    for(int i = n;i!=1;i--){
      System.out.println(i);
    }
  }
}
