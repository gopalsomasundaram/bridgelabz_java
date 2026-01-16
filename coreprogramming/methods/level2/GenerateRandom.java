package methods.level2;

import java.lang.Math;
import java.util.Scanner;
/*
 * This class generates an array of random 4-digit integers and
 * calculates their average, minimum, and maximum values.
 */
public class GenerateRandom {
    // Returns [0] = Average, [1] = Min, [2] = Max
    public double[] findAverageMinMax(int[] numbers){
        double[] arr = new double[3];
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(int i = 0;i<numbers.length;++i){
            sum+=numbers[i];
            // Using Math library for clean comparisons
            max = Math.max(max,numbers[i]);
            min= Math.min(min,numbers[i]);
        }
        // Average = Total Sum / Count
        sum /= numbers.length;
        arr[0] = sum;
        arr[1] = min;
        arr[2] = max;
        return arr;
    }
    //Creates an array filled with random 4-digit numbers (1000-9999)
    public int[] generate4DigitRandomArray(int size){
        int[] arr = new int[size];
        int min = 1000;
        int max = 9999;
        for(int i = 0;i<size;++i){
            arr[i] = (int)(Math.random()*(max-min+1)+min);
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GenerateRandom obj = new GenerateRandom();
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        //Generate Data
        int[] arr =obj.generate4DigitRandomArray(n);

        //Process Data
        double[] result = obj.findAverageMinMax(arr);

        //Output Results
        System.out.println("The average is "+result[0]+", The max is "+result[1]+", and the min is "+result[2]);
        scanner.close();
    }
}
