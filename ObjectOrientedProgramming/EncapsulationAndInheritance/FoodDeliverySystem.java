package EncapsulationAndInheritance;

import java.util.ArrayList;

/*
the Discountable interface handles promotional logic.
this allows us to apply discounts to specific items in an order
based on marketing campaigns.
*/
interface Discountable {
    double applyDiscount(double total);
    String getDiscountDetails();
}

/*
the FoodItem class is abstract, serving as the blueprint for any menu item.
it uses encapsulation to protect order quantities and price integrity.
*/
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // constructor to initialize the common state of a food item
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // getters for encapsulated fields
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // abstract method: forces subclasses to define
    public abstract double calculateTotalPrice();

    // concrete method: shared logic for displaying item data
    public void getItemDetails() {
        System.out.println("Item: " + itemName + " | Qty: " + quantity + " | Price: ₹" + price);
    }
}

/*
VegItem subclass: standard pricing with a minimal packaging fee.
*/
class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double packagingFee = 10.0;
        return (getPrice() * getQuantity()) + packagingFee;
    }

    @Override
    public double applyDiscount(double total) {
        return total * 0.90; // 10% discount for Veg items
    }

    @Override
    public String getDiscountDetails() {
        return "Green-Earth Promo: 10% Off";
    }
}

/*
NonVegItem subclass: includes a surcharge for specialized handling/cooling.
*/
class NonVegItem extends FoodItem {
    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double nonVegSurcharge = 40.0;
        return (getPrice() * getQuantity()) + nonVegSurcharge;
    }
}

/*
the driver class demonstrates polymorphic order processing.
*/
public class FoodDeliverySystem {

    //polymorphic method: processes any list containing FoodItem references.
    public static void processOrder(ArrayList<FoodItem> order) {
        double grandTotal = 0;
        System.out.println("--- Processing Your Order ---");
        System.out.println();

        for (FoodItem item : order) {
            item.getItemDetails();
            double itemTotal = item.calculateTotalPrice();
            
            /* polymorphism with interfaces:
               checking if the item is eligible for a discount.
            */
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println("Discount: " + d.getDiscountDetails());
                itemTotal = d.applyDiscount(itemTotal);
            }

            System.out.println("Subtotal (incl. charges): ₹" + itemTotal);
            grandTotal += itemTotal;
            System.out.println("-----------------------------");
        }
        System.out.println("GRAND TOTAL: ₹" + grandTotal);
    }

    public static void main(String[] args) {
        ArrayList<FoodItem> myOrder = new ArrayList<>();

        // adding different food types to the same order list
        myOrder.add(new VegItem("Paneer Tikka", 250.0, 2));
        myOrder.add(new NonVegItem("Butter Chicken", 350.0, 1));
        myOrder.add(new VegItem("Garlic Naan", 40.0, 3));

        processOrder(myOrder);
    }
}
