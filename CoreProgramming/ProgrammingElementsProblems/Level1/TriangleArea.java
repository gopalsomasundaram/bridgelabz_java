import java.util.Scanner;
public class TriangleArea{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter base:");
    float baseCm = scanner.nextFloat();
    System.out.println("Enter height:");
    float heightCm = scanner.nextFloat();
    float baseIn = baseCm/2.54f;
    float heightIn = heightCm/2.54f;
    float areaCm = ((1.0f/2.0f)*baseCm*heightCm);
    float areaIn = ((1.0f/2.0f)*baseIn*heightIn);
    System.out.println("The Area in CmSq is "+areaCm+" while in InSq is "+areaIn);
  }
}
