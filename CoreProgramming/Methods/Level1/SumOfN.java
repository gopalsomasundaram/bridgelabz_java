package Methods.Level1;

import java.util.Scanner;
public class SumOfN {
    int sumOfNaturalNumbers(int n){
        int sum = 0;
        for(int i = 1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter natural number:");
        int n = scanner.nextInt();
        if(n<=0){
            System.err.println("Invalid Input");
            System.exit(-1);
        }
        SumOfN obj = new SumOfN();
        int result = obj.sumOfNaturalNumbers(n);
        System.out.println("The of natural numbers upto "+n+" is "+result);
        scanner.close();
    }
}
