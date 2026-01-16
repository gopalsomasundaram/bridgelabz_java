package methods.level1;

import java.util.Scanner;
/*
 * This class uses a method to calculate the number of rounds an athlete
 * must complete to cover 5km based on the perimeter of a triangular track.
 */
public class AtheleteRuns {
    float getRounds(float side1, float side2, float side3){
        //Calculate Perimeter
        float perimeter = side1+side2+side3;
        //Calculate Rounds
        // Logic: Total Distance (5000m or 5km) / Perimeter
        return (5.0f/perimeter);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //input gathering
        System.out.println("Enter length of side 1 of triangle:");
        float side1 = scanner.nextFloat();
        System.out.println("Enter length of side 2 of triangle:");
        float side2 = scanner.nextFloat();
        System.out.println("Enter length of side 3 of triangle:");
        float side3 = scanner.nextFloat();

        //Object Creation
        AtheleteRuns myObj = new AtheleteRuns();

        //Method Invocation
        float result = myObj.getRounds(side1,side2,side3);
        System.out.println("The number of rounds the athelete needs to run is: "+result);
        scanner.close();
    }
}
