package ControlFlowProblems.Level1;

import java.util.Scanner;

public class WhichLargest{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number");
    int n1 = scanner.nextInt();
    System.out.println("Enter the second number");
    int n2 = scanner.nextInt();
    System.out.println("Enter the third number");
    int n3 = scanner.nextInt();
    if(n1>n2){
      if(n1>n3){
        System.out.println("The first number is the largest");
      }
      else{
        System.out.println("The third number is the largest");
      }
    }
    else{
      if(n2>n3){
        System.out.println("The second number is the largest");
      }
      else{
        System.out.println("The third number is the largest");
      }
    }
  }
}
