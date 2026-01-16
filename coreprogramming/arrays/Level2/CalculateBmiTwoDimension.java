package arrays.Level2;

import java.util.Scanner;
/*
 * This class calculates BMI for 'n' people using a 2D array.
 * Each row (i) represents one person.
 * Each column (j) represents: [0] Weight, [1] Height, [2] BMI.
 */
public class CalculateBmiTwoDimension {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();

        //2D Array Initialization
        double[][] personData = new double[n][3];
        String[] status = new String[n];

        //Combined Input and Calculation Loop
        for(int i = 0;i<n;++i){
            System.out.printf("Enter the weight(Kg) of person at index %d: ",i);
            personData[i][0] = scanner.nextDouble();
            System.out.printf("Enter the height(Cm) of person at index %d: ",i);
            personData[i][1] = scanner.nextDouble();

            personData[i][1] *= 0.01;

            //Calculation and Storage of BMI
            personData[i][2] = (personData[i][0]/(Math.pow(personData[i][1],2)));
        }

        //Classification Logic
        for(int i = 0;i<n;++i){
            if(personData[i][2]<=18.4f){
                status[i] = "Underweight";
            }
            else if(personData[i][2] < 24.9){
                status[i] = "Normal";
            }else if(personData[i][2] <39.8){
                status[i] = "Overweight";
            }else{
                status[i] = "Obese";
            }
        }

        //Display results
        for(String i : status){
            System.out.println(i);
        }
    }
}
