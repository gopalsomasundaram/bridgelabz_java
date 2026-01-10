package ProgrammingElementsProblems.Level2;

import java.util.Scanner;

public class NumberSwap{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int num1 = scanner.nextInt();
    System.out.println("Enter the second number:");
    int num2 = scanner.nextInt();
    int temp = num1;
    num1 = num2;
    num2 = temp;
    System.out.println("The swapped numbers are "+num1+" and "+num2);
  }
}
