package Arrays.Level1;

import java.util.Scanner;
public class OddEvenArrays {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = scanner.nextInt();
        int[] odd = new int[(n/2)+1];
        int[] even= new int[(n/2)+1];
        int even_index = 0;
        int odd_index = 0;
        for(int i = 0;i<n;i++){
            if(i%2==0){
                even[even_index++]=i;
            }else{
                odd[odd_index++]=i;
            }
        }
        System.out.println("The Odd array is:");
        for(int i = 0;i<odd.length;++i){
            System.out.println(odd[i]);
        }
        System.out.println("The Even array is:");
        for(int i = 0;i<even.length;++i){
            System.out.println(even[i]);
        }
        scanner.close();
    }
}
