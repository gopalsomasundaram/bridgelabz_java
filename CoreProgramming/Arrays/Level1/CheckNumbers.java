package Arrays.Level1;

import java.util.Scanner;
public class CheckNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0;i<arr.length;++i){
            System.out.println("Enter number:");
            arr[i] = scanner.nextInt();
        }
        for(int i : arr){
            if(i<0){
                System.out.println("Negative");
            }
            else if(i==0){
                System.out.println("Zero");
            }else{
                if(i%2==0){
                    System.out.println("Even");
                }else{
                    System.out.println("Odd");
                }
            }
        }
        scanner.close();
    }
}
