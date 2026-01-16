package String.Level1;
import java.util.Scanner;
public class CompareStrings {
    boolean isEqualCustom(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;
        for(int i = 0;i<str1.length();++i){
            if(str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = scanner.next();
        System.out.println("Enter second string: ");
        String str2  = scanner.next();
        boolean inBuiltResult = str2.equals(str1);
        CompareStrings obj = new CompareStrings();
        boolean customResult = obj.isEqualCustom(str1,str2);
        if(inBuiltResult == customResult)
            System.out.println("The results are same");
        else
            System.out.println("The results are different");
        scanner.close();
    }
}

