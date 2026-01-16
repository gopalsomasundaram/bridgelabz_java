package methods.Level2;

import java.util.Scanner;

public class SumNaturalCompare {
    // Logic: Sum(n) = n + Sum(n-1)
    int sumNaturalRecursion(int n){
        // Base Case: Without this, the method would call itself forever!
        if(n == 0) return 0;
        else {
            // Recursive Case: Function calls itself with a smaller problem
            return n+sumNaturalRecursion(n-1);
        }
    }
    // Logic: Simple accumulation inside a loop
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
        //for Natural Numbers
        if(n<=0){
            System.err.println("Invalid input");
            System.exit(-1);
        }
        SumNaturalCompare obj = new SumNaturalCompare();
        int result1 = obj.sumNaturalLoop(n);
        int result2 = obj.sumNaturalRecursion(n);
        // Verification logic
        if(result1==result2){
            System.out.println("results from both are same: "+result2);
        }else{
            System.out.println("results from both are not the same");
        }
        scanner.close();
    }
}
