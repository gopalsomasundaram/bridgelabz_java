package Methods.Level1;

import java.util.Scanner;
public class SimpleInterest {
    double calcInterest(double principal, double rate, double time){
        return ((principal*rate*time)/100);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the principal:");
        double principal = scanner.nextDouble();
        System.out.println("Enter the rate:");
        double rate = scanner.nextDouble();
        System.out.println("Enter the time:");
        double time = scanner.nextDouble();
        SimpleInterest myObj = new SimpleInterest();
        double result = myObj.calcInterest(principal,rate,time);
        System.out.println("The Simple Interest is "+result+" for Principal "+principal+", Rate of Interest "+rate+" and Time "+time);
        scanner.close();
    }
}
