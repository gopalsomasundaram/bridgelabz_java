package ControlFlowProblems.Level1;

import java.util.Scanner;
public class WhileCountdown{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number to start counting from");
    int n = scanner.nextInt();
    while(n!=1){
      n--;
      System.out.println(n);
    }
  }
}
