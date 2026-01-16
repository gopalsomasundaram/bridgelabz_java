package programmingelements.level2;

import java.util.Scanner;
/*
 * This class computes the total distance and total travel time for a journey
 * involving three cities. It collects user information (name and city names)
 * and calculates the sum of distances and times for the two legs of the trip.
 */
public class TravelComputation{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your name:");
    String name = scanner.nextLine();

    System.out.println("Enter the city you are starting from:");
    String fromCity = scanner.nextLine();

    System.out.println("Enter the city you are travelling via:");
    String viaCity = scanner.nextLine();

    System.out.println("Enter the city you are travelling to:");
    String toCity = scanner.nextLine();

    System.out.println("Enter the distance from "+fromCity+" to "+viaCity+":");
    int fromToVia = scanner.nextInt();

    System.out.println("Enter the distance from "+viaCity+" to "+toCity+":");
    int viaToFinal = scanner.nextInt();

    System.out.println("Enter the time taken from "+fromCity+" to "+viaCity+":");
    int timeFromToVia = scanner.nextInt();

    System.out.println("Enter the time taken from "+viaCity+" to "+toCity+":");
    int timeViaToFinal = scanner.nextInt();

    // Sums the distances of both travel segments to find the total distance
    int totalDistancce = fromToVia + viaToFinal;

    // Sums the time duration of both travel segments to find the total time
    int totalTime = timeFromToVia + timeViaToFinal;

    // Concatenates all journey details and calculated totals into a summary message
    System.out.println("The Total distance traveled by "+name+" from "+ fromCity + " to "+toCity+" via "+ viaCity +" is "+ totalDistancce+". The total time taken is "+totalTime+" minutes");
  }
}

