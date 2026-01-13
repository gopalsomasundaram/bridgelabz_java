package Methods.Level2;

import java.util.Scanner;
import java.lang.Math;
public class BMI {
    void calcBmi(double[][] arr){
        for(int i = 0;i<10;++i){
            arr[i][2] = (arr[i][0]/(Math.pow(arr[i][1],2)));
        }

    }
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
        double[][] data = new double[10][3];
        for(int i = 0;i<10;++i){
            data[i][0] = scanner.nextDouble();
        }
        System.out.println("Enter the height of 10 people(Cm):");
        for(int i = 0;i<10;++i){
            data[i][1] = scanner.nextDouble();
            data[i][1] *= 0.01;
        }
        BMI obj = new BMI();
        obj.calcBmi(data);
        String[] arr = obj.getStatus(data);
        for(int i = 0;i<10;++i){
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}
