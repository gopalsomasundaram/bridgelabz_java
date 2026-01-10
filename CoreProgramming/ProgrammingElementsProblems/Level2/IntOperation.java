package ProgrammingElementsProblems.Level2;

import java.util.Scanner;
public class IntOperation{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int a = scanner.nextInt();
    System.out.println("Enter the second number:");
    int b = scanner.nextInt();
    System.out.println("Enter the third number:");
    int c = scanner.nextInt();
    int result1 =a + b * c;
    int result2 = a * b + c;
    int result3 = c + a / b;
    int result4 = a % b + c;
    System.out.println("The result of int operations are "+result1+" ,"+result2+", "+result3+" and "+result4);
  }
}
