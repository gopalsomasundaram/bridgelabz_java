package stacksqueueshashmaps;

import java.util.Stack;

/*
this class calculates the span of stock prices for each day.
the span is defined as the number of consecutive days before the
current day (including current) where the price was less than or
equal to the current price. it uses a stack for $O(N)$ efficiency.
*/
public class StockSpan {

    //method to calculate and print stock spans
    public void calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        //stack to store indices of prices
        Stack<Integer> s = new Stack<>();

        //process each day's price
        for (int i = 0; i < n; i++) {
            //pop indices while current price is greater than previous prices
            while (!s.isEmpty() && prices[s.peek()] <= prices[i]) {
                s.pop();
            }
            //if stack empty, current is highest; else calculate difference
            span[i] = (s.isEmpty()) ? (i + 1) : (i - s.peek());
            //push current day's index
            s.push(i);
        }

        //display the result array
        for (int x : span) System.out.print(x + " ");
    }

    //main function to test stock span logic
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        StockSpan obj = new StockSpan();
        System.out.print("Stock Spans: ");
        obj.calculateSpan(prices);
    }
}