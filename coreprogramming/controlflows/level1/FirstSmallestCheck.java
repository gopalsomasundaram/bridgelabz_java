package controlflows.level1;

import java.util.Scanner;
/*
 * This class determines if the first of three user-provided integers is
 * the smallest. It uses the logical AND operator (&&) to compare the
 * first number against both the second and third numbers simultaneously.
 */
public class FirstSmallestCheck{
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the first number:");
    int n1 = scanner.nextInt();

    System.out.println("Enter the second number:");
    int n2 = scanner.nextInt();

    System.out.println("Enter the third number:");
    int n3 = scanner.nextInt();

    // Evaluates if n1 is strictly less than n2 AND strictly less than n3
    if((n1<n2)&&(n1<n3)){
      // Executes if both comparisons are true
      System.out.println("Is the first number the smallest? yes");
    }else{
      // Executes if n1 is greater than or equal to either n2 or n3
      System.out.println("Is the first number the smallest? no");
    }
  }
}
