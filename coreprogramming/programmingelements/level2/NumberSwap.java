package programmingelements.level2;

import java.util.Scanner;
/*
 * This class swaps the values of two user-provided integers.
 * It uses a temporary variable to hold the value of the first number
 * while the swap is performed, ensuring no data is lost during
 * the reassignment process.
 */
public class NumberSwap{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first number:");
    int num1 = scanner.nextInt();
    System.out.println("Enter the second number:");
    int num2 = scanner.nextInt();

    // Uses a temporary variable to facilitate the swap between num1 and num2
    int temp = num1;
    num1 = num2;
    num2 = temp;

    // Concatenates the now-swapped variables into a single output string
    System.out.println("The swapped numbers are "+num1+" and "+num2);
  }
}
