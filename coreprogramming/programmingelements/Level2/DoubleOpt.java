package programmingelements.Level2;

import java.util.Scanner;
/*
 * This class performs various mathematical operations on three double inputs.
 * It demonstrates operator precedence (PEMDAS/BODMAS) by executing
 * different combinations of addition, multiplication, division, and
 * modulo to show how Java evaluates expressions.
 */
public class DoubleOpt{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the first number:");
    double a = scanner.nextDouble();

    System.out.println("Enter the second number:");
    double b = scanner.nextDouble();

    System.out.println("Enter the third number:");
    double c = scanner.nextDouble();

    // Executes operations demonstrating that multiplication/division occur before addition
    double result1 =a + b * c;
    double result2 = a * b + c;
    double result3 = c + a / b;
    double result4 = a % b + c;

    // Concatenates the four distinct results into a single output string
    System.out.println("The result of int operations are "+result1+" ,"+result2+", "+result3+" and "+result4);
  }
}

