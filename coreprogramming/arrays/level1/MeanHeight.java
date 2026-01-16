package arrays.level1;

import java.util.Scanner;
/*
 * This class calculates the average height of an 11-player team.
 * It stores heights in a double array, computes the sum using a
 * for-each loop, and uses formatted output to display the result
 * rounded to one decimal place.
 */
public class MeanHeight {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Football teams (soccer) have 11 players.
        double[] arr = new double[11];
        for(int i = 0;i<arr.length;++i){
            System.out.printf("Enter the height of player at index %d: ",i+1);
            arr[i] = scanner.nextDouble();
        }
        double sum = 0.0;
        //Calculation logic
        for(double i : arr){
            sum+=i;
        }
        // Logic: Mean = Sum of Elements / Number of Elements
        System.out.printf("mean height of the football team is %.1f",sum/11);
        scanner.close();
    }
}
