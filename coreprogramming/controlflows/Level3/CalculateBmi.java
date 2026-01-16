package controlflows.Level3;
import java.util.Scanner;
import java.lang.Math;
/*
 * This class calculates the Body Mass Index (BMI) using weight and height.
 * It converts height from centimeters to meters and applies the formula:
 * BMI = weight (kg) / height^2 (m^2).
 * Finally, it categorizes the BMI value into Underweight, Normal, Overweight, or Obese.
 */
public class CalculateBmi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight(in Kg):");
        double weight = scanner.nextDouble();

        System.out.println("Enter height(in Cm):");
        double height = scanner.nextDouble();

        // The standard BMI formula requires height in meters.
        height /= 100;

        // Math.pow(height, 2) is used to square the height value.
        double bmi = (weight/(Math.pow(height,2)));
        System.out.println("BMI is "+bmi);

        //Multi-way Branching for Classification
        if(bmi <= 18.4){
            System.out.println("Underweight");
        }
        else if(bmi >= 18.5 && bmi < 25.0)
        {
            System.out.println("Normal");
        }
        else if(bmi >= 25.0 && bmi < 40.0){
            System.out.println("Overweight");
        }else
        {
            System.out.println("Obese");
        }
    }
}
