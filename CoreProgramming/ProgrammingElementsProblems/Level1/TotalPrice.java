package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
public class TotalPrice{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the price per unit:");
    double unitPrice = scanner.nextDouble();
    System.out.println("Enter the total quantity:");
    int quantity = scanner.nextInt();
    System.out.printf("The total purchase price is INR %.1f if the quantity %d and unit price is INR %.1f",(unitPrice*(double)quantity),quantity,unitPrice);

  }
}
