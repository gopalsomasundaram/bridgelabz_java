package methods.Level1;

import java.util.Scanner;
/*
 * This class calculates Simple Interest using an instance method.
 * It takes three double-precision inputs (P, R, T) and returns
 * the calculated interest amount.
 */
public class SimpleInterest {
    double calcInterest(double principal, double rate, double time){
        // Formula: (P * R * T) / 100
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

        //Create an object to call the non-static method
        SimpleInterest myObj = new SimpleInterest();

        //Call the method and store the returned value
        double result = myObj.calcInterest(principal,rate,time);

        System.out.println("The Simple Interest is "+result+" for Principal "+principal+", Rate of Interest "+rate+" and Time "+time);
        scanner.close();
    }
}
