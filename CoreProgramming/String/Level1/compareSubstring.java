package String.Level1;

import java.util.Scanner;
public class compareSubstring {
    String customSubstring(String str, int start, int end){
        char[] arr = new char[end-start+1];
        int index = 0;
        for(int i = start;i<=end;++i){
            arr[index++] = str.charAt(i);
        }
        arr.
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string to be split");
        String str = scanner.next();
        System.out.println("Enter the index to start substring from: ");
        int start = scanner.nextInt();
        System.out.println("Enter the index to end substring at: ");
        int end = scanner.nextInt();
        String substr = str.substring(start,end);
        scanner.close();
    }
}
