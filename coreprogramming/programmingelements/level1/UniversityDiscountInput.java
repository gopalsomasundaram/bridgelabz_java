package programmingelements.level1;

import java.util.Scanner;
/*
 * This class calculates the discount amount and the final payable fee for a student.
 * It takes the total fee and a discount percentage as input, calculates the
 * reduction in price, and displays both the discount and the remaining balance.
 */
public class UniversityDiscountInput{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter fee:");
    int fee = scanner.nextInt();

    System.out.println("Enter discountPercentage:");
    int discountPercentage = scanner.nextInt();

    // Calculates the discount amount by casting to float to ensure decimal accuracy
    float discount = ((float)fee/(float)discountPercentage);

    // Performs subtraction for the final fee and concatenates strings for the final output
    System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+(fee-discount));
  }
}
