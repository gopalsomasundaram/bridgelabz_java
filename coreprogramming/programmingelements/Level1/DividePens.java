package programmingelements.Level1;

/*
 * This class calculates the distribution of pens among students.
 * It determines how many pens each student receives using integer division
 * and calculates the remaining pens using the modulo operator.
 */
public class DividePens{

  public static void main(String[] args){
    int numPens = 14;
    int numStudents = 3;

    // Calculates the quotient for pens per student and the remainder for leftover pens
    System.out.println("The Pen Per Student is "+(numPens/numStudents)+" and the remaining pen not distributed is "+(numPens%numStudents));
  }
}
