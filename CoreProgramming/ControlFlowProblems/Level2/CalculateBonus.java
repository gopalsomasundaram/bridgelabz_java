package ControlFlowProblems.Level2;

import java.util.Scanner;
/*
 * This class calculates the final salary of an employee including a potential bonus.
 * If the employee has served for more than 5 years, they receive a 5% bonus
 * on their base salary. Otherwise, they receive only their base salary.
 */
public class CalculateBonus {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the salary of the employee:");
    int salary = scanner.nextInt();

    System.out.println("Enter the years of service of the employee");
    int yos = scanner.nextInt();

    // Condition: Check if the employee's years of service (yos) exceeds the 5-year threshold
    if(yos>5){

      // Calculates 5% of the salary. Using 0.05f ensures floating-point precision.
      float bonus = ((float)salary*0.05f);

      // Adds the bonus to the base salary. Note the cast back to 'int' for the final total.
      int total = salary + (int) bonus;
      System.out.println("Total salary amount = "+total);
    }else{
      // Executes if service is 5 years or less; no bonus is added.
      System.out.println("Total salary amount = "+salary);
    }
  }
}
