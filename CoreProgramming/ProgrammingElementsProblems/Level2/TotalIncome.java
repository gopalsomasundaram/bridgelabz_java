package ProgrammingElementsProblems.Level2;

import java.util.Scanner;
public class TotalIncome{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the salary:");
    int salary = scanner.nextInt();
    System.out.println("Enter the bonus:");
    int bonus = scanner.nextInt();
    System.out.println("The salary is INR "+salary+" and the bonus is INR "+bonus+". Hence Total Income is INR "+(salary+bonus));
  }
}
