package Methods.Level2;
import java.util.Scanner;
public class UnitConverter {
    //Q4
    public static double convertKmToMiles(double km){
        double km2miles = 0.621371;
        double miles = km * km2miles;
        return miles;
    }
    public static double convertMilesToKm(double miles){
        double miles2km = 1.60934;
        double km = miles * miles2km;
        return km;
    }
    public static double convertMetersToFeet(double meters){
        double meters2feet = 3.28084;
        double feet = meters * meters2feet;
        return feet;
    }
    public static double convertFeetToMeters(double feet){
        double feet2meters = 0.3048;
        double meters = feet * feet2meters;
        return meters;
    }
    //Q5
    public static double convertYardsToFeet(double yards){
        double yards2feet = 3;
        double feet = yards * yards2feet;
        return feet;
    }
    public static double convertFeetToYards(double feet){
        double feet2yards = 0.333333;
        double yards = feet * feet2yards;
        return yards;
    }
    public static double convertMeters2Inches(double meters){
        double meters2inches = 39.3701;
        double inches = meters * meters2inches;
        return inches;
    }
    public static double convertInches2Meters(double inches){
        double inches2meters = 0.0254;
        double meters = inches * inches2meters;
        return meters ;
    }
    public static double convertInches2Centimeters(double inches){
        double inches2cm= 2.54;
        double cm =inches  * inches2cm;
        return cm;
    }
    //Q6
    public static double convertFarenheitToCelsius(double farenheit){
        double celsius = (farenheit - 32) * 5 / 9;
        return celsius;
    }
    public static double convertCelsiusToFarenheit(double celsius){
        double farenheit= (celsius * 9 / 5) + 32;
        return farenheit;
    }
    public static double convertPounds2Kilogram(double pounds){
        double pounds2kilograms = 0.453592;
        double kg = pounds * pounds2kilograms;
        return kg;
    }
    public static double convertKilogram2Pounds(double kg){
        double kilograms2pounds = 2.20462;
        double pounds =kg * kilograms2pounds;
        return pounds;
    }
    public static double convertGallons2Liters(double gallons){
        double gallons2liters = 3.78541;
        double liters = gallons * gallons2liters;
        return liters;
    }
    public static double convertLiters2Gallons(double liters){
        double liters2gallons = 0.264172;
        double gallons =liters  * liters2gallons;
        return gallons;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter measurement in gallons:");
        double gallons = scanner.nextDouble();
        double result = convertGallons2Liters(gallons);
        System.out.println(gallons+" in liters is "+result);
        scanner.close();
    }
}
