package Methods.Level3;

import java.util.Scanner;
import java.lang.Math;
/*
 * This class simulates a student grading system.
 * - generateMarks: Creates a 2D array of random subject marks.
 * - performCalculations: Processes that data into a second 2D array of statistics.
 * - main: Orchestrates the flow and prints a formatted report.
 */
public class CalcMarks {
    //Data Generation
    double[][] generateMarks(int n){
        double[][] arr = new double[n][3];
        int max = 99;
        int min = 10;
        for(int i = 0;i<n;++i){
            // Fills row i with random marks between 10 and 99
            arr[i][0] = (Math.random()*(max-min+1)+min);
            arr[i][1] = (Math.random()*(max-min+1)+min);
            arr[i][2] = (Math.random()*(max-min+1)+min);
        }
        return arr;
    }
    //Logic Processing
    double[][] performCalculations(double [][] arr,int n){
        double[][] result = new double[n][3];
        for(int i = 0;i<n;++i){
            // Total Sum
            result[i][0] = arr[i][0] + arr[i][1] + arr[i][2];
            // Rounding to 2 decimal places
            result[i][0] = Math.round(result[i][0]* 100.0) / 100.0;
            // Average (Total / 3 subjects)
            result[i][1] = result[i][0]/3;
            // Percentage (Total / 300 * 100 = Total / 3)
            result[i][2] = result[i][0]/3;
        }
        return result;
    }
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the number of students:");
       int n = scanner.nextInt();
       CalcMarks obj = new CalcMarks();
       double[][] marksData =obj.generateMarks(n);
       double[][] calculatedData = obj.performCalculations(marksData,n);
       System.out.println("Math\tPhysics\tChemistry\ttotal\taverage\tpercentage");
       // Output Loop: Accessing both 2D arrays by the same index 'i'
       for(int i = 0;i<n;++i){
           System.out.printf("%4.0f\t%7.0f\t%8.0f\t%5.0f\t%7.0f\t%10.0f\n",marksData[i][0],marksData[i][1],marksData[i][2],calculatedData[i][0],calculatedData[i][1],calculatedData[i][2]);
       }
       scanner.close();
   }
}
