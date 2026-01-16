package programmingelements.Level2;

import java.util.Scanner;
/*
 * This class calculates the distribution of chocolates among children.
 * It uses integer division to determine how many whole chocolates each child
 * receives and the modulo operator to find the remaining chocolates that
 * cannot be evenly distributed.
 */
public class ChocolatesChildren{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the number of chocolates:");
    int numberOfChocolates = scanner.nextInt();

    System.out.println("Enter the number of children:");
    int numberOfChildren= scanner.nextInt();

    // Calculates the quotient to find the chocolates per child
    int perChild = numberOfChocolates/numberOfChildren;

    // Calculates the remainder to find the leftover chocolates
    int leftover = numberOfChocolates%numberOfChildren;

    // Concatenates the results into a final message for display
    System.out.println("The number of chocolates each child gets is "+perChild+" and the number of remaining chocolates are "+leftover);
  }
}
