package ProgrammingElementsProblems.Level1;

import java.lang.Math;
public class VolumeEarth{
  public static void main(String[] args){
    double radiusEarthKm = 6378f;
    double volEarthKm = ((4/3)*Math.PI*Math.pow(radiusEarthKm,3));
    double radiusEarthMi = radiusEarthKm/1.6;
    double volEarthMi = ((4/3)*Math.PI*Math.pow(radiusEarthMi,3));
    System.out.println("The volume of earth in cubic kilometers is "+volEarthKm+" and cubic miles is "+volEarthMi);
  }
}
