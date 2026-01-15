package Methods.Level3;

import java.util.Scanner;
import java.lang.Math;
public class DisplayCalendar {
    String getName(int month){
        String[] monthStrings = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        return monthStrings[month];
    }
    boolean isLeapYear(int year){
        if((year%4==0 && year%100!=0)||year%400==0){
            return true;
        }else{
            return false;
        }
    }
    int getNumDays(int month, int year){
        int[] days = new int[]{31,0,31,30,31,30,31,31,30,31,30,31};
        if(isLeapYear(year)){
            days[1] = 29;
        }else{
            days[1] = 28;
        }
        return days[month];
    }
    int firstDayOfMonth(int d, int m,int y){
        m+=1;
        int y0 = y - (14 - m)/12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m)/12)-2;
        int d0 = (d + x + 31*m0/12 )%7;
        return d0;
    }
    void printCalendar(int d,int m,int y){
        System.out.println(getName(m)+" "+y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int n = firstDayOfMonth(d,m,y);
        for(int i = 0;i<n;++i){
            System.out.print("    ");
        }
        int numDays = getNumDays(m,y);
        for(int i = 1;i<=numDays;i++){
            System.out.printf("%3d ",i);
            if ((i + n) % 7 == 0) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day:");
        int day = scanner.nextInt();
        System.out.println("Enter the month:");
        int month= scanner.nextInt();
        System.out.println("Enter the year:");
        int year= scanner.nextInt();
        DisplayCalendar obj = new DisplayCalendar();
        obj.printCalendar(day,month,year);
        scanner.close();
    }
}
