package ClassAndObject.Level1;
/*
 * This class models a simple Employee record.
 * It demonstrates data members (fields) and member functions (methods).
 */
public class Employee {
    //Data Members
    int id = 01;
    String name = "Adam";
    int salary = 1000;
    void displayData(){
        //Instance Method
        System.out.println("Employee id : "+id);
        System.out.println("Employee salary : "+salary);
        System.out.println("Employee name : "+name);
    }
    public static void main(String[] args){
        //Instantiation
        Employee obj = new Employee();
        obj.displayData();
    }
}
