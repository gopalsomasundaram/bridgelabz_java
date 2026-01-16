package programmingelements.Level1;
/*
 * This class calculates the profit and profit percentage for a transaction.
 * It uses a hardcoded cost price and selling price, determines the
 * difference to find profit, and calculates the percentage relative
 * to the cost price.
 */
public class ProfitLoss{
  public static void main(String[] args){
    int costPrice = 129;
    int sellingPrice = 191;

    // Calculates the raw profit by subtracting cost price from selling price
    int profit = sellingPrice - costPrice;

    // Calculates the profit percentage by casting to float for decimal precision
    float profitPercentage = (((float)profit/(float) costPrice)*100);

    // Displays financial details using formatted output for the currency and percentage
    System.out.printf("The Cost Price is INR %d and Selling Price is INR %d\nThe Profit is INR %d an dthe Profit Percentage is %.2f",costPrice,sellingPrice,profit,profitPercentage);
  }
}
