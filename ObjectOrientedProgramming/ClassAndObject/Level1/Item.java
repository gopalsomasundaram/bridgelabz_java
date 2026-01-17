package ClassAndObject.Level1;
/*
 * This class models an inventory Item and calculates the cost
 * based on a quantity provided at runtime.
 */
public class Item {
    //Attributes
    int itemCode = 101;
    String itemName = "Pen";
    int price = 10;
    //Method with Parameter
    void displayData(int quantity) {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Item Price : " + price);
        System.out.println("Quantity : " + quantity);
        // Calculation logic using both Instance and Local variables
        System.out.println("Total Cost : " + (price * quantity));
    }

    public static void main(String[] args) {
        //Object Creation
        Item obj = new Item();
        //Passing an Argument
        obj.displayData(5);
    }
}
