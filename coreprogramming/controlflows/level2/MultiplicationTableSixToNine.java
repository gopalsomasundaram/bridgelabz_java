package controlflows.level2;

import java.util.Scanner;
/*
 * This class displays the multiplication table for a given number,
 * focusing specifically on the range from 6 to 9.
 * It demonstrates a for-loop with customized initialization and
 * termination expressions.
 */
public class MultiplicationTableSixToNine {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number:");
    int n = scanner.nextInt();
    // Initializes i at 6 and continues until i reaches 9
    for(int i = 6;i<=9;++i){
      // Calculates n * i and prints the result in a formatted string
      System.out.println(n+" * "+i+" = "+(n*i));
    }
  }
}
