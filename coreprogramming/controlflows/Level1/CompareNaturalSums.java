package controlflows.Level1;

import java.util.Scanner;
/*
 * This class compares two methods of calculating the sum of the first 'n'
 * natural numbers: the mathematical formula (n * (n + 1)) / 2 and a
 * manual for-loop. It serves as a verification tool to ensure both
 * logic paths yield the same result.
 */
public class CompareNaturalSums{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the natural number:");
    int n = scanner.nextInt();

    // Checks if the number is valid; if negative, exits the program early
    if(n < 0){
      System.out.println("Not a natural number");
      return;
    }

    // Calculates the sum using the mathematical formula: n * (n + 1) / 2
    int formula = ((n*(n+1))/2);
    int manual = 0;

    // Iterates from 0 up to n, adding each value to the manual sum variable
    for(int i = 0;i<=n;i++){
      manual+=i;
    }

    // Compares the two results and displays the outcome based on the equality check
    if(manual == formula){
      System.out.println("both the results are same "+manual);
    }else{
      System.out.println("both the results are different, manual="+manual+" and formula="+formula);
    }
  }
}
