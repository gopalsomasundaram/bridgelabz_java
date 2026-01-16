package methods.Level1;

import java.util.Scanner;
/*
 * This class calculates the Wind Chill index using an instance method.
 * Formula: 35.74 + 0.6215T + (0.4275T - 35.75) * V^0.16
 * Where T is temperature (°F) and V is wind speed (mph).
 */
public class WindChill {
    public double calcWindChill(double temperature, double windSpeed){
        // We use Math.pow to raise windSpeed to the power of 0.16
        return (35.74+0.6215*temperature+(0.4275*temperature-35.75)*Math.pow(windSpeed,0.16));
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        WindChill obj = new WindChill();

        System.out.println("Enter the temperature:");
        double temp = scanner.nextDouble();

        System.out.println("Enter the wind speed:");
        double windSpeed = scanner.nextDouble();
        // Call the method and store the result
        double result = obj.calcWindChill(temp,windSpeed);
        System.out.println("The windchill is "+result);
        scanner.close();
    }
}
