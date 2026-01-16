package programmingelements.level1;

import java.lang.Math;
/*
 * This class calculates the volume of the Earth in cubic kilometers and cubic miles.
 * It uses the sphere volume formula (4/3 * π * r³) and the Math library for
 * PI and power functions, with a conversion factor of 1.6 to convert kilometers to miles.
 */
public class VolumeEarth{
  public static void main(String[] args){
    double radiusEarthKm = 6378f;

    // Calculates the volume in cubic km using the formula (4/3) * PI * r^3
    double volEarthKm = ((4/3)*Math.PI*Math.pow(radiusEarthKm,3));

    // Converts the radius from kilometers to miles using the 1.6 conversion factor
    double radiusEarthMi = radiusEarthKm/1.6;

    // Calculates the volume in cubic miles using the converted radius
    double volEarthMi = ((4/3)*Math.PI*Math.pow(radiusEarthMi,3));

    // Displays the calculated volumes for both units using string concatenation
    System.out.println("The volume of earth in cubic kilometers is "+volEarthKm+" and cubic miles is "+volEarthMi);
  }
}
