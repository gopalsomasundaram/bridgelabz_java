package Arrays.Level1;

import java.util.Scanner;
public class MultTable6To9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number who multiplication table you want from 6 to 9:");
        int[] arr =new int[4];
        int n = scanner.nextInt();
        int index=0;
        for(int i = 6;i<=9;i++){
            arr[index++] = i*n;
        }
        index = 0;
        for(int i =6;i<=9;i++){
            System.out.printf("%d * %d = %d\n",n,i,arr[index++]);
        }
    }
}
