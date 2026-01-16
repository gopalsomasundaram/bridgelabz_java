package controlflows.Level3;
import java.util.Scanner;
/*
 * This class performs basic arithmetic operations (+, -, *, /) on two numbers.
 * It runs for a fixed number of iterations (NUM_ITR) and uses a switch
 * statement to determine which mathematical operation to execute based on
 * the operator character provided by the user.
 */
public class SwitchCalc {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int NUM_ITR = 2;
        double num1;
        double num2;
        char op;

        // Loop allows the user to perform multiple calculations in one run
        for(int i = 0;i<NUM_ITR;++i){
            System.out.println("Enter first number:");
            num1 = scanner.nextDouble();
            System.out.println("Enter second number:");
            num2 = scanner.nextDouble();
            System.out.println("Enter operation to be performed(+,-,/,*):");
            op = scanner.next().charAt(0);

            // Switch structure evaluates the 'op' variable
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
                    // This block executes if 'op' is not one of the cases above
                    System.out.println("Invalid Operator");
                    break;
            }
        }
    }
}
