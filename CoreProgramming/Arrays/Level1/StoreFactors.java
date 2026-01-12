package Arrays.Level1;

import java.util.Scanner;
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
            if(index == maxFactors){
                int[] biggerArray = new int[maxFactors*2];
                for(int j = 0;j<maxFactors;j++){
                    biggerArray[j] = arr[j];
                }
                maxFactors*=2;
                arr=biggerArray;
            }
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
