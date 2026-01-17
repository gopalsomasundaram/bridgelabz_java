package ClassAndObject.Level2;
/*
 * This class models an item within a shopping cart.
 * It tracks quantity changes and ensures data integrity through logic checks.
 */
public class CartItem {
    //attributes
    String itemName = "Notebook";
    int price = 50;
    int quantity = 0;
    //Incrementing method
    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println(qty + " item(s) added to cart");
    }

    //Decrementing method
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity = quantity - qty;
            System.out.println(qty + " item(s) removed from cart");
        } else {
            System.out.println("Not enough items in cart");
        }
    }
    //method to return data members (attributes)
    void displayTotalCost() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Total Cost : " + (price * quantity));
    }

    public static void main(String[] args) {
        //instantiation
        CartItem obj = new CartItem();

        obj.addItem(3);
        obj.removeItem(1);
        obj.displayTotalCost();
    }
}
