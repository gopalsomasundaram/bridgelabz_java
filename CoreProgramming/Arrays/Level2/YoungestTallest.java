package Arrays.Level2;

import java.util.Scanner;
public class YoungestTallest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        System.out.println("Enter the ages of the 3 friends in order of Aman, Akbar and Anthony:");
        for(int i = 0;i<3;++i){
            ages[i] = scanner.nextInt();
        }
        System.out.println("Enter the heights of the 3 friends order of Aman, Akbar and Anthony:");
        for(int i = 0;i<3;++i){
            heights[i] = scanner.nextInt();
        }
        int youngest = 0;
        for(int i = 0;i<3;++i){
            if(ages[i]<ages[youngest]){
                youngest = i;
            }
        }
        int tallest = 0;
        for(int i = 0;i<3;++i){
            if(heights[i]>heights[tallest]){
                tallest = i;
            }
        }

        if(youngest== 0) System.out.println("Aman is the youngest");
        if(youngest== 1) System.out.println("Akbar is the youngest");
        if(youngest== 2) System.out.println("Anthony is the youngest");

        if(tallest ==0) System.out.println("Aman is the tallest");
        if(tallest ==1) System.out.println("Akbar is the tallest");
        if(tallest ==2) System.out.println("Anthony is the tallest");
        scanner.close();
    }
}
