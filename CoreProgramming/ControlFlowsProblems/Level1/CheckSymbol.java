package ControlFlowProblems.Level1;
import java.util.Scanner;
public class CheckSymbol{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number:");
    int num = scanner.nextInt();
    if(num == 0){
      System.out.println("zero");
    }
    else if(num < 0){
      System.out.println("negative");
    }
    else{
      System.out.println("positive");
    }
  }
}
