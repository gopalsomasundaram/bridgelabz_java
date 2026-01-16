package starterproblems;

import java.util.Scanner;

/*
 * Program: AddTwoNumbers
 * Description: takes two floating-point inputs from the user
 * and outputs their sum formatted to two decimal places.
 */

public class AddTwoNumbers{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number");
    // Converts the input string to a float
    float a = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter the second number");
    float b = Float.parseFloat(scanner.nextLine());
    // Performs addition and formats the result to two decimal places
    System.out.printf("Sum of two numbers is: %.2f",a+b);
    scanner.close();
  }
}
