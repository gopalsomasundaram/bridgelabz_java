package Methods.Level1;

import java.util.Scanner;
public class SmallAndLarge {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){
        int[] arr = new int[3];
        arr[0] = number1;
        arr[1] = number2;
        arr[2] = number3;
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
        int[] arr = findSmallestAndLargest(n1,n2,n3);
        System.out.println("smallest is "+arr[0]+" and largest is "+arr[2]);
        scanner.close();
    }
}
