package Methods.Level1;

import java.util.Scanner;
public class WindChill {
    public double calcWindChill(double temperature, double windSpeed){
        return (35.74+0.6215*temperature+(0.4275*temperature-35.75)*Math.pow(windSpeed,0.16));
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        WindChill obj = new WindChill();
        System.out.println("Enter the temperature:");
        double temp = scanner.nextDouble();
        System.out.println("Enter the wind speed:");
        double windSpeed = scanner.nextDouble();
        double result = obj.calcWindChill(temp,windSpeed);
        System.out.println("The windchill is "+result);
        scanner.close();
    }
}
