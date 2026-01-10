package ProgrammingElementsProblems.Level1;

public class UniversityDiscountStatic{
  public static void main(String[] args){
    int fee = 125000;
    int discountPercent = 10;
    float discount = ((float)fee/(float)discountPercent);
    System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+(fee-discount));
  }
}
