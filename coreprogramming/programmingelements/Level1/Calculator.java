package programmingelements.Level1;

import java.util.Scanner;
/*
 * This class performs basic arithmetic operations on two user-provided integers.
 * It calculates the sum, difference, product, and quotient of the inputs
 * and displays all four results in a single summary statement.
 */
public class Calculator{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int num1 = scanner.nextInt();

    System.out.println("Enter the second number:");
    int num2 = scanner.nextInt();

    // Performs the four basic arithmetic operations
    int add = num1+num2;
    int subtract = num1-num2;
    int multiply = num1*num2;
    int divide = num1/num2;

    // Concatenates and prints the results of all calculations in one line
    System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+num1+" and "+num2+" is "+add+", "+subtract+", "+multiply+", and "+divide);
  }
}
