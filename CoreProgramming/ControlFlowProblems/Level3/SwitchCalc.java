package ControlFlowProblems.Level3;
import java.util.Scanner;
public class SwitchCalc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int NUM_ITR = 2;
        double num1;
        double num2;
        char op;
        for(int i = 0;i<NUM_ITR;++i){
            System.out.println("Enter first number:");
            num1 = scanner.nextDouble();
            System.out.println("Enter second number:");
            num2 = scanner.nextDouble();
            System.out.println("Enter operation to be performed(+,-,/,*):");
            op = scanner.next().charAt(0);
            switch (op){
                case '+':
                    System.out.println("result is "+(num1+num2));
                    break;
                case '-':
                    System.out.println("result is "+(num1-num2));
                    break;
                case '*':
                    System.out.println("result is "+(num1*num2));
                    break;
                case '/':
                    System.out.println("result is "+(num1/num2));
                    break;
                default:
                    System.out.println("Invalid Operator");
                    break;
            }
        }
    }
}
