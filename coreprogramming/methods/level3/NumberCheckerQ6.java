package methods.level3;

import java.util.Scanner;
/*
 * This class analyzes a number's divisors and digit properties.
 * It classifies numbers as Perfect, Abundant, Deficit, or Strong.
 */
public class NumberCheckerQ6 extends NumberCheckerBase{
    // Retrieves proper factors of n (excluding 1 and n)
    int[] getFactorsArray(int n){
        int count = 0;
        for(int i = 2;i<n;++i){
            if(n%i==0){
                count++;
            }
        }
        int[] arr = new int[count];
        int index = 0;
        for(int i = 2;i<n;++i){
            if(n%i==0){
                arr[index++] = i;
            }
        }
        return arr;
    }
    //get largest element in arr
    int getLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i : arr ){
            largest = Math.max(largest,i);
        }
        return largest;
    }
    //returns sum of given array
    int sumFactors(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum;
    }
    //multiplies and returns result of given array
    int prodFactors(int[] arr){
        int product = 1;
        for(int i : arr){
            product*=i;
        }
        return product;
    }
    //gets product of cube of given elements in array
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
    // Logic: Perfect, Abundant, and Deficient numbers are based on the sum of factors
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
    int getFactorial(int n){
        int prod = 1;
        for(int i = 1;i<n; ++i){
            prod*=i;
        }
        return prod;
    }
    boolean isStrongNumber(int[] arr, int n){
        // Strong Number: Sum of factorials of digits == number
        int sum = 0;
        for(int i = 0; i<arr.length;++i){
            sum+=getFactorial(arr[i]);
        }
        return sum == n;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        NumberCheckerQ6 obj = new NumberCheckerQ6();
        int[] digits = obj.getDigits(n, obj.countDigits(n));
        int[] factors = obj.getFactorsArray(n);
        System.out.println("The factors of the number are:");
        for(int i : factors)
            System.out.println(i);
        System.out.println("Greatest Factors of given number is: "+obj.getLargest(factors));
        System.out.println("Sum of factors is: "+obj.sumFactors(factors));
        System.out.println("product of factors is: "+obj.prodFactors(factors));
        System.out.println("product of cube of factors is: "+obj.prodOfCubeFactors(factors));
        if(obj.isPerfectNumber(digits,n)){
            System.out.println("It is a perfect number");
        }
        if(obj.isAbundantNumber(digits,n)){
            System.out.println("It is an abundant number");
        }
        if(obj.isDeficitNumber(digits,n)){
            System.out.println("It is a deficit number");
        }
        if(obj.isStrongNumber(digits,n)){
            System.out.println("It is a strong number");
        }
        scanner.close();
    }
}
