package ClassAndObject.Level1;
/*
 * This class models a Mobile Phone entity.
 * It demonstrates how real-world objects are represented in code.
 */
public class MobilePhone {
    //Attributes
    String brand = "Samsung";
    String model = "Galaxy S21";
    int price = 60000;
    //Methods
    void displayData() {
        System.out.println("Mobile Brand : " + brand);
        System.out.println("Mobile Model : " + model);
        System.out.println("Mobile Price : " + price);
    }

    public static void main(String[] args) {
        //Object Creation
        MobilePhone obj = new MobilePhone();
        obj.displayData();
    }
}
