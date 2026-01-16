package Methods.Level2;

import java.util.Scanner;
import java.lang.Math;
/*
 * This class calculates BMI for 10 people using a 2D array.
 * It separates the logic into two distinct methods:
 * 1. One to calculate the values (modifying the array in place).
 * 2. One to determine the health status (returning a new array).
 */
public class CalculateBmi {
    void calcBmi(double[][] arr){
        // Column [0]: Weight, Column [1]: Height, Column [2]: BMI (to be filled)
        for(int i = 0;i<10;++i){
            // BMI Formula: weight / height^2
            arr[i][2] = (arr[i][0]/(Math.pow(arr[i][1],2)));
        }

    }
    //Returns a 1D String array containing categories
    String[] getStatus(double[][] arr){
        String[] statuses = new String[10];
        for(int i = 0;i<10;++i){
            if(arr[i][2] <=18.5){
                statuses[i] = "Underweight";
            }else if(arr[i][2] < 25.0){
                statuses[i] = "Normal";
            }
            else if(arr[i][2] < 40.0){
                statuses[i] = "Overweight";
            }else{
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the weight of 10 people(Kg):");

        // Rows = 10 People, Columns = 3 (Weight, Height, BMI)
        double[][] data = new double[10][3];
        for(int i = 0;i<10;++i){
            data[i][0] = scanner.nextDouble();
        }
        System.out.println("Enter the height of 10 people(Cm):");
        for(int i = 0;i<10;++i){
            data[i][1] = scanner.nextDouble();
            data[i][1] *= 0.01;
        }
        CalculateBmi obj = new CalculateBmi();
        obj.calcBmi(data);

        // Getting the status array
        String[] arr = obj.getStatus(data);

        // Final output
        for(int i = 0;i<10;++i){
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}
