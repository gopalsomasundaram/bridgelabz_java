package Methods.Level2;

import java.awt.*;
import java.util.Scanner;
public class Factors {
    static int[] getFactorsArray(int n){
        int count = 0;
        for(int i = 1;i<n;++i){
            if(n%i == 0){
                count++;
            }
        }
        int[] arr = new int[count];
        int index = 0;
        for(int i = 1;i<n;++i){
            if(n%i==0){
                arr[index++]=i;
            }
        }
        return arr;
    }
    static int sumOfFactors(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length;++i){
            sum+=arr[i];
        }
        return sum;
    }
    static int productOfFactrs(int[] arr){
        int product = 1;
        for(int i = 0;i<arr.length;i++){
            product*=arr[i];
        }
        return product;
    }
    static int sumOfSquares(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+= (int)Math.pow(i,2);
        }
        return sum;
    }
    public static void main(String[ ] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to get factors of:");
        int n = scanner.nextInt();
        int[] arr = getFactorsArray(n);
        int sum = sumOfFactors(arr);
        int prod = productOfFactrs(arr);
        int sumSq = sumOfSquares(arr);
        System.out.printf("The sum of the factors are: %d\nThe product of factors are: %d\nThe sum of squares of squares of the factors are: %d\n",sum,prod,sumSq);
        System.out.println("The factors are:");
        for(int i : arr){
            System.out.println(i);
        }
        scanner.close();
    }
}
