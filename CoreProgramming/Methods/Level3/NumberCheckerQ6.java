package Methods.Level3;

import java.util.Scanner;

public class NumberCheckerQ6 {
    int[] getFactorsArray(int n){
        int count = 0;
        for(int i = 2;i<n;++i){
            if(n%i==0){
                count++;
            }
        }
        int[] arr = new int[count];
        for(int i = 2;i<n;++i){
            if(n%i==0){
                arr[i] = i;
            }
        }
        return arr;
    }
    int getLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i : arr ){
            largest = Math.max(largest,i);
        }
        return largest;
    }
    int sumFactors(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum;
    }
    int prodFactors(int[] arr){
        int product = 1;
        for(int i : arr){
            product*=i;
        }
        return product;
    }
    int prodOfCubeFactors(int[] arr){
        for(int i = 0;i<arr.length;++i){
            arr[i] = (int)(Math.pow(arr[i],3));
        }
        int product = 1;
        for(int i : arr){
            product*=i;
        }
        return product;
    }
    boolean isPerfectNumber(int[] arr,int n){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum == n;
    }
    boolean isAbundantNumber(int[] arr,int n){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum > n;
    }
    boolean isDeficitNumber(int[] arr, int n){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum < n;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
    }
}
