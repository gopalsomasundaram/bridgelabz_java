package Methods.Level2;

import java.util.Scanner;
public class YoungestTallest {
    public int getYoungest(int[] arr){
        int smallest = 0;
        for(int i=0;i<3;++i){
            if(arr[i] < arr[smallest]){
                smallest = i;
            }
        }
        return smallest;
    }
    public int getTallest(int[] arr){
        int tallest = 0;
        for(int i=0;i<3;++i){
            if(arr[i] > arr[tallest]){
                tallest = i;
            }
        }
        return tallest;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] age = new int[3];
        System.out.println("Enter the age of three friends:");
        age[0] = scanner.nextInt();
        age[1] = scanner.nextInt();
        age[2] = scanner.nextInt();
        int[] height = new int[3];
        System.out.println("Enter the height of three friends:");
        height[0] = scanner.nextInt();
        height[1] = scanner.nextInt();
        height[2] = scanner.nextInt();
        YoungestTallest obj = new YoungestTallest();
        int youngest = obj.getYoungest(age);
        int tallest = obj.getTallest(height);
        System.out.println("Boy with age "+age[youngest]+" is the youngest");
        System.out.println("Boy with height "+height[tallest]+" is the tallest");
        scanner.close();
    }
}
