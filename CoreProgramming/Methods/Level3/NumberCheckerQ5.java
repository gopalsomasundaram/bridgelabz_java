package Methods.Level3;
import java.util.Scanner;
public class NumberCheckerQ5 extends NumberCheckerBase{
    boolean isPrime(int n){
        for(int i = 2;i<n;++i){
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    boolean isSpyNumber(int n){
        int[] arr = getDigits(n,countDigits(n));
        int sum = 0;
        int product = 1;
        for(int i : arr){
            sum+=i;
            product *= i;
        }
        return sum == product;
    }
    boolean isNeon(int n){
        int sqrd = (int)(Math.pow(n,2));
        int[] digits = getDigits(sqrd,countDigits(sqrd));
        int sum = 0;
        for(int i : digits){
            sum+=i;
        }
        return sum == n;
    }
    boolean isAutoMorphic(int n){
        int square = (int)(Math.pow(n,2));
        if(square%10 == n){
            return true;
        }
        return false;
    }
    boolean isBuzzNumber(int n){
        return (n%7 == 0 || n %10 == 7);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = scanner.nextInt();
        NumberCheckerQ5 obj = new NumberCheckerQ5();
        if(obj.isPrime(n)) {
            System.out.println("It is a prime number");
        }
        else{
            System.out.println("It is not a prime number");
        }
        if(obj.isNeon(n)) {
            System.out.println("It is a neon number");
        }
        else{
            System.out.println("It is not a neon number");
        }
        if(obj.isSpyNumber(n)) {
            System.out.println("It is a spy number");
        }
        else{
            System.out.println("It is not a spy number");
        }
        if(obj.isAutoMorphic(n)) {
            System.out.println("It is a automorphic number");
        }
        else{
            System.out.println("It is not a automorphic number");
        }
        if(obj.isBuzzNumber(n)) {
            System.out.println("It is a buzz number");
        }
        else{
            System.out.println("It is not a buzz number");
        }
        scanner.close();
    }
}
