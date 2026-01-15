package Methods.Level3;

import java.util.Scanner;
import java.lang.Math;
public class GenerateOTP {
    int generate6Digit(){
        int min = 100000;
        int max = 999999;
        return ((int)(Math.random()*(max-min+1)+min));
    }
    int[] getRandomArray(){
        int[] arr = new int[10];
        for(int i = 0;i<10;++i){
            arr[i] = generate6Digit();
        }
        return arr;
    }
    boolean isUnique(int[] arr){
        for(int i = 0;i<9;++i){
            for(int j = i+1;j<10;++j){
                if(arr[i] == arr[j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        GenerateOTP obj = new GenerateOTP();
        int[] arr = obj.getRandomArray();
        for(int i : arr){
            System.out.println(i);
        }
        if(obj.isUnique(arr)){
            System.out.println("All OTP in array are unique");
        }
    }
}
