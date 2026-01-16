package methods.Level1;

import java.util.Scanner;
/*
 * This class finds the smallest and largest of three numbers.
 * It uses a sorting-based approach within a static method to
 * organize the numbers in an array before returning it.
 */
public class SmallAndLarge {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){
        //Store inputs in an array
        int[] arr = new int[3];
        arr[0] = number1;
        arr[1] = number2;
        arr[2] = number3;
        //Perform a single pass of Bubble Sort logic
        for(int i = 0;i<2;++i){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the 3 numbers");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        // Call the static method
        int[] arr = findSmallestAndLargest(n1,n2,n3);

        // After the partial sort:
        // arr[0] is likely the smallest, arr[2] is likely the largest
        System.out.println("smallest is "+arr[0]+" and largest is "+arr[2]);
        scanner.close();
    }
}
