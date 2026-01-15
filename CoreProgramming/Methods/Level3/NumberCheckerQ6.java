package Methods.Level3;

import java.util.Scanner;

public class NumberCheckerQ6 extends NumberCheckerBase{
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
    int getFactorial(int n){
        int prod = 1;
        for(int i = 1;i<n; ++i){
            prod*=i;
        }
        return prod;
    }
    boolean isStrongNumber(int[] arr, int n){
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
