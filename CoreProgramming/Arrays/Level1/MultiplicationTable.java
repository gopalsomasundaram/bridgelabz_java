package Arrays.Level1;

import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number you want multiplication table of:");
        int n = scanner.nextInt();
        int[] arr = new int[10];
        for(int i = 0;i<arr.length;++i){
            arr[i] = (i+1)*n;
            System.out.printf("%d * %d = %d\n",n,i+1,arr[i]);
        }
        scanner.close();
    }
}
