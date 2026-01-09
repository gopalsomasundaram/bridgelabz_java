public class ProfitLoss{
  public static void main(String[] args){
    int costPrice = 129;
    int sellingPrice = 191;
    int profit = sellingPrice - costPrice;
    float profitPercentage = (((float)profit/(float) costPrice)*100);
    System.out.printf("The Cost Price is INR %d and Selling Price is INR %d\nThe Profit is INR %d an dthe Profit Percentage is %.2f",costPrice,sellingPrice,profit,profitPercentage);
  }
}
