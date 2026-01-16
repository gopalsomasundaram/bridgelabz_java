package ClassAndObject.Level1;

public class Employee {
    int id = 01;
    String name = "Adam";
    int salary = 1000;
    void displayData(){
        //display method vars
        System.out.println("Employee id : "+id);
        System.out.println("Employee salary : "+salary);
        System.out.println("Employee name : "+name);
    }
    public static void main(String[] args){
        Employee obj = new Employee();
        obj.displayData();
    }
}
