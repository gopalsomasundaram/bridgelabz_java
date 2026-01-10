package ControlFlowProblems.Level1;

import java.util.Scanner;
public class SumItUpTill0Break{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int sum=0;
    System.out.println("Enter the numbers to be added one by one, enter 0 to stop and get result");
    int userInp;
    while(true){
      userInp = scanner.nextInt();
      if(userInp == 0) break;
      else{
        sum+=userInp;
      }
    }
    System.out.println("The sum is "+sum);
  }
}
