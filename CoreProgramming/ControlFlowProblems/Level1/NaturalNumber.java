package ControlFlowProblems.Level1;

import java.util.Scanner;
public class NaturalNumber{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number to be checked and gotten sum of:");
    int n = scanner.nextInt();
    if(n>=0){
      int sum = ((n*(n+1))/2);
      System.out.println("The sum of "+n+" natural numbers is "+sum);
    }else{
      System.out.println("The number "+n+" is not a natural number");
    }
  }
}
