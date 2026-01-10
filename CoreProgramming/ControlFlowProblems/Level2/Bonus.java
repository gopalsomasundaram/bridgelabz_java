package ControlFlowProblems.Level2;

import java.util.Scanner;
public class Bonus{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the salary of the employee:");
    int salary = scanner.nextInt();
    System.out.println("Enter the years of service of the employee");
    int yos = scanner.nextInt();
    if(yos>5){
      float bonus = ((float)salary*0.05f);
      int total = salary + (int) bonus;
      System.out.println("Total salary amount = "+total);
    }else{
      System.out.println("Total salary amount = "+salary);
    }
  }
}
