package Arrays.Level2;

import java.util.Scanner;
public class ReverseDigits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        int copy = n;
        int count= 0;
        while(copy!=0){
            count++;
            copy/=10;
        }
        int[] arr = new int[count];
        for(int i=0;i<count;++i){
            arr[i] = n%10;
            n/=10;
        }
        for(int j : arr){
            System.out.println(j);
        }
        scanner.close();
    }
}
