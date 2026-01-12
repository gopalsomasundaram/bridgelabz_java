package Arrays.Level2;

import java.util.Scanner;
public class Frequency {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        int count = 0;
        int copy = n;
        while(copy!=0){
            count++;
            copy/=10;
        }
        int[] digits = new int[count];
        int index = 0;
        while(n!=0){
            digits[index++]  = n%10;
            n/=10;
        }
        int[] frequency = new int[10];
        for(int i = 0;i<count;++i){
            frequency[digits[i]]++;
        }
        for(int i = 0;i<10;i++){
            System.out.printf("Frequency of %d is: %d\n",i,frequency[i]);
        }
    }
}
