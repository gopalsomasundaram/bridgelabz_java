package ClassAndObject.Level1;

public class MobilePhone {
    String brand = "Samsung";
    String model = "Galaxy S21";
    int price = 60000;

    void displayData() {
        System.out.println("Mobile Brand : " + brand);
        System.out.println("Mobile Model : " + model);
        System.out.println("Mobile Price : " + price);
    }

    public static void main(String[] args) {
        MobilePhone obj = new MobilePhone();
        obj.displayData();
    }
}
