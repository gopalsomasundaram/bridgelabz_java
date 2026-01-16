package Arrays.Level1;

import java.util.Scanner;
/*
 * This class demonstrates array initialization and iteration.
 * It collects 5 integers from the user and then analyzes each:
 * - Checks if the number is negative, zero, or positive.
 * - If positive, it further classifies it as even or odd.
 */
public class CheckNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];

        //standard for-loop to access each index (0 to 4).
        for(int i = 0;i<arr.length;++i){
            System.out.println("Enter number:");
            arr[i] = scanner.nextInt();
        }

        // We use an "Enhanced For-Loop" (for-each) to read values.
        for(int i : arr){
            if(i<0){
                System.out.println("Negative");
            }
            else if(i==0){
                System.out.println("Zero");
            }else{
                // Nested Logic: Executed only if the number is positive (> 0)
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
