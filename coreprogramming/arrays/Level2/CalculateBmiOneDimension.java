package arrays.Level2;
import java.util.Scanner;
import java.lang.Math;
/*
 * This class calculates BMI for 10 people using parallel arrays.
 * It demonstrates how to synchronize data across multiple arrays
 * using a single loop index.
 */
public class CalculateBmiOneDimension {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Parallel Array Initialization
        float[] weights = new float[10];
        float[] heights = new float[10];
        float[] bmis = new float[10];
        String[] status = new String[10];
        System.out.println("Enter the weight of 10 people in order(Kg):");
        for(int i = 0;i<10;i++){
            weights[i] = scanner.nextFloat();
        }
        System.out.println("Enter the heights of 10 people in order(Cm):");

        //Input Collection
        for(int i = 0;i<10;i++){
            heights[i] = scanner.nextFloat();
            // Convert cm to meters immediately
            heights[i] *= 0.01f;
        }
        //BMI Calculation
        for(int i = 0;i<10;++i){
            // Formula: weight / height^2
            bmis[i] = (weights[i]/((float)(Math.pow(heights[i],2))));
        }

        //Classification
        for(int i = 0;i<10;i++){
            if(bmis[i]<=18.4f){
                status[i] = "Underweight";
            }
            else if(bmis[i] < 24.9){
                status[i] = "Normal";
            }else if(bmis[i] <39.8){
                status[i] = "Overweight";
            }else{
                status[i] = "Obese";
            }
        }
        //Output
        System.out.println("weight statuses according to BMI:");
        for(String i : status){
            System.out.println(i);
        }
        scanner.close();
    }
}
