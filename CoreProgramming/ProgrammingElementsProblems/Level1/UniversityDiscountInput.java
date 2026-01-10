package ProgrammingElementsProblems.Level1;

import java.util.Scanner;
public class UniversityDiscountInput{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter fee:");
    int fee = scanner.nextInt();
    System.out.println("Enter discountPercentage:");
    int discountPercentage = scanner.nextInt();
    float discount = ((float)fee/(float)discountPercentage);
    System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+(fee-discount));
  }
}
