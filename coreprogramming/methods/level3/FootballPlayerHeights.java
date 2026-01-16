package methods.level3;

import java.util.Scanner;
import java.lang.Math;
/*
 * This class analyzes the heights of an 11-player football team.
 * It uses random data generation and statistical methods to find
 * the total height, average height, and the height range.
 */
public class FootballPlayerHeights {
    // Method 1: Total Sum (Accumulator Pattern)
    int sumOfHeights(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum;
    }
    int meanHeight(int[] arr){
        // Method 2: Mean (Average) Calculation
        int sum = sumOfHeights(arr);
        return sum/11;
    }
    // Method 3: Find Maximum (Tallest)
    int tallest(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            max = Math.max(max,i);
        }
        return max;
    }
    // Method 4: Find Minimum (Shortest)
    int shortest(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i : arr){
            min = Math.min(min,i);
        }
        return min;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Randomly generating heights for 11 players
        int[] arr = new int[11];
        int min = 150;
        int max = 250;
        for(int i = 0;i<11;++i){
            arr[i] = (int)(Math.random()*(max-min+1)+min);
        }
        FootballPlayerHeights obj = new FootballPlayerHeights();

        int sum = obj.sumOfHeights(arr);
        int mean = obj.meanHeight(arr);
        int maxHeight = obj.tallest(arr);
        int minHeight = obj.shortest(arr);

        // Print Results
        System.out.println("Sum of heights: "+sum);
        System.out.println("Mean of heights: "+mean);
        System.out.println("max of heights: "+maxHeight);
        System.out.println("min of heights: "+minHeight);
    }
}
