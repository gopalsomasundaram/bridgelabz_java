package programmingelements.Level1;
/*
 * This class calculates the average marks for a student (Sam) in
 * Physics, Chemistry, and Mathematics (PCM). It computes the
 * arithmetic mean of three float values and displays the result.
 */
public class SamsMarks{
  public static void main(String[] args){
    float math = 94f;
    float physics = 95f;
    float chemistry = 96f;

    // Calculates the average by summing the three subjects and dividing by 3
    float averagePercentage = ((math+physics+chemistry) / 3);

    // Concatenates the label with the calculated average for display
    System.out.println("Sam’s average mark in PCM is "+averagePercentage);
  }
}
