package strings.level3;

import java.util.Scanner;
/*
 * This class generates a visual calendar for any given month and year.
 * It calculates the starting day of the week and handles leap year variations.
 */
public class CustomCalendar {
    // Maps the integer month to its English name
    public String getMonthName(int month) {
        String[] months = {
                "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month];
    }
    // Logic: A year is leap if divisible by 4, but not 100, unless divisible by 400
    public boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    public int getNumberOfDays(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }
    //Calculates the day of the week for the 1st of the month
    public int getFirstDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0=Sun, 1=Mon, ..., 6=Sat
    }
    // Formats and prints the calendar grid
    public void printCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getNumberOfDays(month, year);
        int firstDay = getFirstDay(month, year);

        System.out.println("\n    " + monthName + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%4d", i);
            if (((i + firstDay) % 7 == 0) || (i == daysInMonth)) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12) and year (e.g., 07 2005): ");
        int month = sc.nextInt();
        int year = sc.nextInt();

        CustomCalendar cal = new CustomCalendar();
        cal.printCalendar(month, year);

        sc.close();
    }
}
