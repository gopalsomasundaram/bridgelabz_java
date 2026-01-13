package Methods.Level3;

import java.util.Scanner;
import java.lang.Math;
public class NumberCheckerQ2 extends NumberCheckerBase{
    boolean isDuckNumber(int[] arr){
        for(int i = 0;i<arr.length;++i){
            System.out.println("checking "+arr[i]);
            if(i==0&&arr[i]==0){
                return false;
            }
            if(arr[i] == 0){
                return true;
            }
        }
        return false;
    }
    boolean isArmstrong(int[] arr, int n){
        int sum = 0;
        for(int i : arr){
            sum+= (int)(Math.pow(i,arr.length));
        }
        return sum == n;
    }
    int[] largestAndSecond(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;++i){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] <largest && arr[i] > secondLargest){
                secondLargest = arr[i] ;
            }
        }
        return new int[] {largest,secondLargest};
    }
    int[] smallestAndSecond(int[] arr){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int i : arr){
            if(i<smallest){
                secondSmallest = smallest;
                smallest = i;
            }else if(i > smallest && i < secondSmallest){
                secondSmallest =i;
            }
        }
        return new int[] {smallest,secondSmallest};
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = scanner.nextInt();
        NumberCheckerQ2 obj = new NumberCheckerQ2();
        int[] arr = obj.getDigits(n, obj.countDigits(n));
        boolean result = obj.isArmstrong(arr,n);
        if(result) System.out.println("yes");
        else System.out.println("no");
        int[] one = obj.largestAndSecond(arr);
        int[] two = obj.smallestAndSecond(arr);
        System.out.println("largest is "+one[0]+" and second largest is "+one[1]);
        System.out.println("smallest is "+two[0]+" and second smallest is "+two[1]);
        scanner.close();
    }
}
