/**
 * This program implements a Shopping Cart system using various Map types.
 * It demonstrates how to store product data, maintain a specific order
 * of selection, and generate reports sorted by numerical values.
 *
 * @author gopal
 */
package collections.mapinterface;

import java.util.*;

public class ShoppingCartSystem {

    // HashMap to store the master catalog (Product Name -> Price)
    // Chosen for O(1) speed when looking up prices during checkout
    private Map<String, Double> priceCatalog = new HashMap<>();

    // LinkedHashMap to store the actual cart (Product Name -> Quantity)
    // Chosen to maintain the order in which the user added items
    private Map<String, Integer> cartItems = new LinkedHashMap<>();

    /**
     * Initializes the master catalog with some default products.
     */
    public void setupCatalog() {
        priceCatalog.put("Laptop", 1200.00);
        priceCatalog.put("Mouse", 25.50);
        priceCatalog.put("Keyboard", 45.00);
        priceCatalog.put("Monitor", 200.00);
        priceCatalog.put("HDMI Cable", 15.00);
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param productName The name of the item to add.
     * @param quantity    How many of the item to add.
     */
    public void addToCart(String productName, int quantity) {
        if (priceCatalog.containsKey(productName)) {
            cartItems.put(productName, cartItems.getOrDefault(productName, 0) + quantity);
            System.out.println("Added " + quantity + " x " + productName + " to cart.");
        } else {
            System.out.println("Error: " + productName + " is not in our catalog.");
        }
    }

    /**
     * Displays the cart items in the exact order they were added.
     */
    public void displayCartInOrder() {
        System.out.println("\n--- Your Cart (Order Added) ---");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }

    /**
     * Uses a TreeMap to display the items in the cart sorted by their unit price.
     * Note: TreeMap sorts by Key. Since we need to sort by Price (Value),
     * we use a custom comparator.
     */
    public void displaySortedByPrice() {
        System.out.println("\n--- Cart Items Sorted by Price (Low to High) ---");

        // We create a TreeMap where the key is the Price and the value is the Name
        // This naturally sorts the items by the Price (Key)
        Map<Double, String> priceSorter = new TreeMap<>();

        for (String item : cartItems.keySet()) {
            priceSorter.put(priceCatalog.get(item), item);
        }

        for (Map.Entry<Double, String> entry : priceSorter.entrySet()) {
            System.out.println("$" + entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCartSystem myCart = new ShoppingCartSystem();
        myCart.setupCatalog();

        // Adding items in a specific order
        myCart.addToCart("Monitor", 1);
        myCart.addToCart("HDMI Cable", 2);
        myCart.addToCart("Laptop", 1);
        myCart.addToCart("Mouse", 1);

        // Displaying insertion order (LinkedHashMap)
        myCart.displayCartInOrder();

        // Displaying sorted by price (TreeMap)
        myCart.displaySortedByPrice();
    }
}
