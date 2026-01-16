package ClassAndObject.Level1;

public class Item {
    int itemCode = 101;
    String itemName = "Pen";
    int price = 10;

    void displayData(int quantity) {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Item Price : " + price);
        System.out.println("Quantity : " + quantity);
        System.out.println("Total Cost : " + (price * quantity));
    }

    public static void main(String[] args) {
        Item obj = new Item();
        obj.displayData(5);
    }
}
