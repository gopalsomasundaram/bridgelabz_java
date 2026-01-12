package Arrays.Level1;

import java.util.Scanner;
public class FizzBuzz {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        String[] arr = new String[n+1];
        for(int i =0;i<=n;++i){
            if(i%3==0 && i%5==0){
                arr[i] = "FizzBuzz";
            }
            else if(i%3 == 0){
                arr[i] = "Fizz";
            }
            else if(i%5==0){
                arr[i] = "Buzz";
            }
            else{
                arr[i] = Integer.toString(i);
            }
        }
        for(String i : arr){
            System.out.println(i);
        }
        scanner.close();
    }
}
