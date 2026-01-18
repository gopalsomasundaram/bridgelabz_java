package ConstructorsAccessModifiers.Level2;
/*
This is the super class that contains attributes that will be used to
depict the use of access modifiers, it also contains a private
attribute that can only be changed or read through the getter and
setter methods
*/
class Employee{
    //Attributes
    private int salary;
    protected String department;
    public int employeeId;

    //default constructor
    Employee(){
        salary = 5000;
        department = "sales";
        employeeId = 1234;
    }

    //parameterized constructor
    Employee(int employeeId,String department, int salary){
        this.employeeId = employeeId;
        this.salary = salary;
        this.department = department;
    }
    //getter method for salary attribute
    int getSalary(){
        return salary;
    }
    //setter method for salary attribute
    void setSalary(int salary){
        System.out.println("Salary is being changed from "+this.salary+" to "+salary);
        this.salary = salary;
    }
}

/*
this is the sub class that extends Employee class
it changes
*/
class Manager extends Employee{
    //method that demonstrates access to the super class's accessible attribute
    void chageAccessible(int employeeId, String department){
        this.employeeId = employeeId;
        this.department = department;
    }
    //method to print all the attributes
    void displayData(){
        System.out.println("employeeId: "+employeeId);
        System.out.println("departement "+department);
        System.out.println("salary "+getSalary());
    }
}

public class EmployeeRecords {
    public static void main(String[] args){
        //object creating (sublclass)
        Manager obj = new Manager();

        //data before change
        obj.displayData();

        //changing the data
        obj.chageAccessible(4545,"leadership");
        obj.setSalary(90000);
        //data after change
        obj.displayData();
    }
}
