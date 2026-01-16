package programmingelements.Level1;

import java.util.Scanner;
/*
 * This class calculates the total purchase price based on user input.
 * It takes a unit price (double) and a quantity (int), multiplies them
 * to find the total, and displays a summary formatted to one decimal place.
 */
public class TotalPrice{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the price per unit:");
    double unitPrice = scanner.nextDouble();

    System.out.println("Enter the total quantity:");
    int quantity = scanner.nextInt();

    // Multiplies unit price by quantity and formats the output to one decimal place
    System.out.printf("The total purchase price is INR %.1f if the quantity %d and unit price is INR %.1f",(unitPrice*(double)quantity),quantity,unitPrice);

  }
}
