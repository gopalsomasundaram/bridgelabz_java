package methods.level3;

import java.util.Scanner;
import java.lang.Math;
/*
 * This class simulates a payroll bonus system for Zara.
 * - Generates random employee data (Salary & Years of Service).
 * - Processes bonuses based on service years.
 * - Computes and displays company-wide totals.
 */
public class CalcBonusZara {
    // Method 1: Data Simulation - Salary
    void randomSalary(int[] arr){
        for(int i = 0;i<10;++i) {
            int min = 10000;
            int max = 99999;
            // Generates random 5 digits
            arr[i] = ((int) (Math.random() * (max - min + 1) + max));
        }
    }
    // Method 2: Data Simulation - Years of Service
    void randomYearOfService(int[] arr){
        for(int i = 0;i<10;++i) {
            int min = 0;
            int max = 10;
            arr[i] = ((int) (Math.random() * (max - min + 1) + max));
        }
    }
    // Method 3: Logic Processing
    int[][] calcBonus(int[] salary, int[] yearsOfService){
        int[][] arr = new int[10][2];
        for(int i = 0;i<10;++i){
            if(yearsOfService[i]>5){
                // 5% Bonus for seniors
                arr[i][0] = (int)((double)salary[i]*0.05);
                arr[i][1] = arr[i][0] + salary[i];
            }else{
                // 2% Bonus for juniors
                arr[i][0] = (int)((double)salary[i]*0.02);
                arr[i][1] = arr[i][0] + salary[i];
            }
        }
        return arr;
    }
    // Method 4: Output and Aggregation
    void printData(int[][] newData, int[] oldSalary){
        int totalOldSalary=0, totalNewSalary=0, totalBonus=0;
        for(int i = 0;i<10;++i){
            totalBonus+=newData[i][0];
            totalNewSalary+=newData[i][1];
            totalOldSalary += oldSalary[i];
        }
        System.out.println("old Salary\tnew Salary\ttotal bonus");
        System.out.printf("%10d\t%10d\t%11d",totalOldSalary,totalNewSalary,totalBonus);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] salary = new int[10];
        int[] yearOfService = new int[10];
        CalcBonusZara obj = new CalcBonusZara();

        // Pipeline Execution
        obj.randomSalary(salary);
        obj.randomYearOfService(yearOfService);
        int[][] newData =obj.calcBonus(salary,yearOfService);
        obj.printData(newData,salary);

        scanner.close();
    }
}
