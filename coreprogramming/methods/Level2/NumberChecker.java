package methods.Level2;

import java.util.Scanner;
/*
 * This class performs various checks on a set of 5 integers.
 * It demonstrates:
 * 1. Boolean methods for parity and sign checks.
 * 2. A comparison method returning status codes.
 * 3. Nested if-statements for refined classification.
 */
public class NumberChecker {
    // Check if number is positive (includes zero)
    boolean isPositive(int n){
        if(n>=0)return true;
        else return false;
    }
    // Check if number is even
    boolean isEven(int n){
        if(n%2==0) return true;
        else return false;
    }
    // Three-way comparison: returns 0 (equal), -1 (smaller), 1 (larger)
    int comp (int n1, int n2){
        if(n1 == n2) return 0;
        else if(n1<n2) return -1;
        else return 1;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        NumberChecker obj = new NumberChecker();
        System.out.println("Enter 5 numbers: ");
        for(int i = 0;i<5;++i){
            arr[i] = scanner.nextInt();
        }
        // Processing the array
        for(int i : arr){
            if(obj.isPositive(i)){
                // If it's positive, further classify it as Even or Odd
                if(obj.isEven(i)){
                    System.out.println("Even");
                }else {
                    System.out.println("Odd");
                }
            }else{
                System.out.println("Negative");
            }
        }
        // Comparing the boundaries of the array
        int result = obj.comp(arr[0],arr[4]);
        if(result == 0){
            System.out.println("First and last element are equal");
        }else if(result == -1){
            System.out.println("First element is smaller than last element");
        }else{
            System.out.println("First element is bigger than last element");
        }
        scanner.close();
    }
}
