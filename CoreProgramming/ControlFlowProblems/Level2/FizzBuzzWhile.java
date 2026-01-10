package ControlFlowProblems.Level2;

import java.util.Scanner;
public class FizzBuzzWhile{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number:");
    int n = scanner.nextInt();
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    int i = 0;
    while(i<n){
      i++;
      if((i%3==0)&&(i%5==0)){
        System.out.println("FizzBuzz");
        continue;
      }else if(i%3==0){
        System.out.println("Fizz");
        continue;
      }else if(i%5==0){
        System.out.println("Buzz");
        continue;
      }else{
        System.out.println(i);
      }
    }
  }
}
