package controlflows.level2;

import java.util.Scanner;
/*
 * This class iterates through all natural numbers from 0 up to a user-defined limit 'n'.
 * For each number, it determines if the value is even or odd by checking
 * the remainder of division by 2.
 */
public class PrintOddOrEven{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter natural number:");
    int n = scanner.nextInt();
    //Ensures the input follows the definition of a natural number
    if(n<0){
      System.out.println("Invalid Input");
      return;
    }
    // Iterates from 0 through n inclusive
    for(int i = 0;i<=n;++i){
      // Logic: If i divided by 2 has a remainder of 0, it is even
      if(i%2==0){
        System.out.println("Even");
      }
      // If there is any other remainder (which will always be 1 for integers), it is odd
      else{
        System.out.println("Odd");
      }
    }
  }
}
