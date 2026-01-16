package controlflows.Level3;
import java.util.Scanner;
/*
 * This class calculates the day of the week for a specific date (d, m, y).
 * It uses a formulaic approach to adjust the year and month to account for
 * the Gregorian calendar's structure, including leap year cycles.
 * Result (d0): 0 = Sunday, 1 = Monday, ..., 6 = Saturday.
 */
public class DayOfWeek {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day(d):");
        int d = scanner.nextInt();
        System.out.println("Enter the month(m):");
        int m = scanner.nextInt();
        System.out.println("Enter the year(y):");
        int y = scanner.nextInt();

        // Step 1: Adjust the year for January and February
        int y0 = y - (14-m)/12;
        // Step 2: Calculate Gregorian leap year adjustments
        int x = y0  + y0 / 4 - y0/100 + y0/400;
        // Step 3: Adjust the month
        int m0 = m + 12 * ((14-m)/12)-2;
        // Step 4: Final calculation using modulo 7
        int d0 = (d+x+31*m0/12)%7;

        System.out.println(d0);
        //0-Sunday, 1,-monday, 2-tuesday, 3-wednesday, 4-thursday, 5-friday, 6-saturday
    }
}
