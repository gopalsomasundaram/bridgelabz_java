package Methods.Level2;

import Methods.Level1.SumOfN;

import java.util.Scanner;
public class SumNaturalCompare {
    int sumNaturalRecursion(int n){
        if(n == 0) return 0;
        else return n+sumNaturalRecursion(n-1);
    }
    int sumNaturalLoop(int n){
        int sum = 0;
        for(int i = 0;i<=n;++i){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the natural number: ");
        int n = scanner.nextInt();
        if(n<=0){
            System.err.println("Invalid input");
            System.exit(-1);
        }
        SumNaturalCompare obj = new SumNaturalCompare();
        int result1 = obj.sumNaturalLoop(n);
        int result2 = obj.sumNaturalRecursion(n);
        if(result1==result2){
            System.out.println("results from both are same: "+result2);
        }else{
            System.out.println("results from both are not the same");
        }
        scanner.close();
    }
}
