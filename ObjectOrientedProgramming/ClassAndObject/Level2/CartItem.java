package ClassAndObject.Level2;

public class CartItem {
    String itemName = "Notebook";
    int price = 50;
    int quantity = 0;

    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println(qty + " item(s) added to cart");
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity = quantity - qty;
            System.out.println(qty + " item(s) removed from cart");
        } else {
            System.out.println("Not enough items in cart");
        }
    }

    void displayTotalCost() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Total Cost : " + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem obj = new CartItem();

        obj.addItem(3);
        obj.removeItem(1);
        obj.displayTotalCost();
    }
}
