package Arrays.Level1;

import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double[] arr = new double[11];
        for(int i = 0;i<arr.length;++i){
            System.out.printf("Enter the height of player at index %d: ",i+1);
            arr[i] = scanner.nextDouble();
        }
        double sum = 0.0;
        for(double i : arr){
            sum+=i;
        }
        System.out.printf("mean height of the football team is %.1f",sum/11);
        scanner.close();
    }
}
