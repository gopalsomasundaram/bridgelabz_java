package Methods.Level1;

import java.util.Scanner;
public class AtheleteRuns {
    float getRounds(float side1, float side2, float side3){
        float perimeter = side1+side2+side3;
        return (5.0f/perimeter);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of side 1 of triangle:");
        float side1 = scanner.nextFloat();
        System.out.println("Enter length of side 2 of triangle:");
        float side2 = scanner.nextFloat();
        System.out.println("Enter length of side 3 of triangle:");
        float side3 = scanner.nextFloat();
        AtheleteRuns myObj = new AtheleteRuns();
        float result = myObj.getRounds(side1,side2,side3);
        System.out.println("The number of rounds the athelete needs to run is: "+result);
        scanner.close();
    }
}
