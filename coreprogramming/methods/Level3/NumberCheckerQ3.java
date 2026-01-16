package methods.Level3;
import java.util.Scanner;
/*
 * This class performs advanced digit-based checks and statistical frequency.
 * Inherits from NumberCheckerBase to handle digit extraction.
 */
public class NumberCheckerQ3 extends NumberCheckerBase{
    // Sums all individual digits
    int getSum(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum;
    }
    // Sums the squares of individual digits (d1^2 + d2^2 + ...)
    int getSumSquare(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum+=(int)Math.pow(i,2);
        }
        return sum;
    }
    // Harshad Number: A number divisible by the sum of its digits
    boolean isHarshad(int[] arr,int n){
        int sum = getSum(arr);
        return n%sum == 0;
    }
    // Calculates the frequency of each digit (0-9)
    int[][] getFrequency(int[] arr){
        int[][] freq = new int[10][2];
        for(int i : arr){
            freq[i][0] = i;
            freq[i][1] ++;
        }
        return freq;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        NumberCheckerQ3 obj = new NumberCheckerQ3();
        System.out.println("Enter number: ");
        int n = scanner.nextInt();
        int[] arr = obj.getDigits(n, obj.countDigits(n));
        // Display results
        System.out.println("sum of digits: "+obj.getSum(arr));
        System.out.println("sum of squares of digits: "+obj.getSumSquare(arr));
        if(obj.isHarshad(arr,n)){
            System.out.println("It is a harshad number");
        }
        else{
            System.out.println("It is not a harshad number");
        }
        int[][] result = obj.getFrequency(arr);
        for(int i = 0;i<10;++i){
            System.out.println(result[i][0]+"->"+result[i][1]);
        }
        scanner.close();
    }
}
