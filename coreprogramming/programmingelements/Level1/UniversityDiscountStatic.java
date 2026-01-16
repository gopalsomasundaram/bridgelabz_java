package programmingelements.Level1;
/*
 * This class calculates the discount and final fee for a university tuition.
 * It uses hardcoded values for the initial fee and the discount rate,
 * performing float-based division and subtraction to determine the final cost.
 */
public class UniversityDiscountStatic{
  public static void main(String[] args){
    int fee = 125000;
    int discountPercent = 10;

    // Calculates the discount amount by converting integers to floats for division
    float discount = ((float)fee/(float)discountPercent);

    // Subtracts the discount from the total fee and prints the result via string concatenation
    System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+(fee-discount));
  }
}
