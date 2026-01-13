package Methods.Level2;

import java.lang.Math;
import java.util.Scanner;
public class GenerateRandom {
    public double[] findAverageMinMax(int[] numbers){
        double[] arr = new double[3];
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(int i = 0;i<numbers.length;++i){
            sum+=numbers[i];
            max = Math.max(max,numbers[i]);
            min= Math.min(min,numbers[i]);
        }
        sum /= numbers.length;
        arr[0] = sum;
        arr[1] = min;
        arr[2] = max;
        return arr;
    }
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
        int[] arr =obj.generate4DigitRandomArray(n);
        double[] result = obj.findAverageMinMax(arr);
        System.out.println("The average is "+result[0]+", The max is "+result[1]+", and the min is "+result[2]);
        scanner.close();
    }
}
