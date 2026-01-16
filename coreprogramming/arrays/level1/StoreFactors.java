package arrays.level1;

import java.util.Scanner;
/*
 * This class finds the proper factors of a number and stores them in an array.
 * If the number of factors exceeds the initial array size, it dynamically
 * doubles the array's capacity to accommodate more data.
 */
public class StoreFactors {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int maxFactors = 10;
        int[] arr = new int[maxFactors];
        System.out.println("Enter number whose factors need to be found:");
        int n = scanner.nextInt();
        if(n<= 0){
            System.err.println("Invalid Input");
            System.exit(-1);
        }
        int index = 0;
        for(int i = 1;i<n;++i){
            //If the array is full, expand it
            if(index == maxFactors){
                //Create a larger array
                int[] biggerArray = new int[maxFactors*2];
                //Copy elements from the old array to the new one
                for(int j = 0;j<maxFactors;j++){
                    biggerArray[j] = arr[j];
                }
                //Update the tracking variables
                maxFactors*=2;
                //Point the original 'arr' reference to the new 'biggerArray'
                arr=biggerArray;
            }
            // Check for divisibility
            if(n%i==0)
            {
                arr[index++]=i;
            }
        }
        //finally display the array
        for(int i = 0;i<arr.length;++i){
            System.out.println(arr[i]);
        }
        scanner.close();
    }
}
