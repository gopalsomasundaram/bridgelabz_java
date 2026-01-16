package programmingelements.Level1;

import java.util.Scanner;
/*
 * This class calculates the area of a triangle in both square centimeters and square inches.
 * It takes base and height inputs in centimeters, converts them to inches using the
 * 2.54 conversion factor, and applies the area formula (1/2 * base * height) to both.
 */
public class TriangleArea{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter base:");
    float baseCm = scanner.nextFloat();


    System.out.println("Enter height:");
    float heightCm = scanner.nextFloat();

    // Converts base and height from centimeters to inches
    float baseIn = baseCm/2.54f;
    float heightIn = heightCm/2.54f;

    // Calculates the area in square centimeters using the formula: 1/2 * base * height
    float areaCm = ((1.0f/2.0f)*baseCm*heightCm);

    // Calculates the area in square inches using the converted dimensions
    float areaIn = ((1.0f/2.0f)*baseIn*heightIn);

    // Concatenates and displays the results for both unit systems
    System.out.println("The Area in CmSq is "+areaCm+" while in InSq is "+areaIn);
  }
}
