package ControlFlowProblems.Level3;
import java.util.Scanner;
import java.lang.Math;
public class CalcBMI {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight(in Kg):");
        double weight = scanner.nextDouble();
        System.out.println("Enter height(in Cm):");
        double height = scanner.nextDouble();
        height /= 100;//convert to m from cm
        double bmi = (weight/(Math.pow(height,2)));
        System.out.println("BMI is "+bmi);
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
