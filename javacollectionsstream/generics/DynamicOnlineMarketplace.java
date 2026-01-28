/**
 * This program implements a dynamic online marketplace system where
 * Products of certain categories can be added without using a unique
 * class for each of them. The program uses generics and wild cards
 * to allow for maximum code reusability while maintaining type safety
 */

package generics;

/**
 * This class serves as the main blueprint for all of the different
 * product categories. It has printCategory functions that returns
 * print category of subclass to console
 */
interface Category{
    void printCategory();
}

/**
 * This class is a sub class of Category and implements PrintCategory
 */
class BooksCategory implements Category{
    @Override
    public void printCategory(){
        System.out.println("Book");
    }
}

/**
 * This class is a sub class of Category and implements PrintCategory
 */
class ClothingCategory implements Category{
    @Override
    public void printCategory(){
        System.out.println("Clothing");
    }
}

/**
 * This class is a sub class of Category and implements PrintCategory
 */
class StationaryCategory implements Category{
    @Override
    public void printCategory(){
        System.out.println("Stationary");
    }
}

/**
 * This class creates and Manages a list of products, it increases usability using
 * generics to accommodate any type class is declared with. It has getter setter functions
 * for the price of the products and contains the category of product as a private member
 * @param <T> this is the class type that class would be instantiated with allowing for
 *            reusability of this class
 */
class Product<T extends Category>{
    //data members
    private double price;
    private T category;
    //constructor
    Product(double price, T category){
        this.price = price;
        this.category = category;
    }
    //setter for price
    public void setPrice(double price){
        this.price = price;
    }
    //getter for price
    public double getPrice(){
        return price;
    }

    /**
     * This method applies discount to the given product and changes the price of the product
     * accordingly
     * @param product product to which discount needs to applied
     * @param percentage amount of discount to be applied to the product's price
     * @param <P> generics to allow for accommodation of any Product class with different generic parameter
     */
    public static<P extends Product<?>> void applyDiscount(P product, double percentage){
        double newPrice = ((product.getPrice())-(product.getPrice()*(percentage/100)));
        product.setPrice(newPrice);
    }
}
//class for main method
public class DynamicOnlineMarketplace {
    //main method
    public static void main(String[] args){
        //object creation for different categories with constructor for price:w
        Product<StationaryCategory> obj1 = new Product<>(50.0,new StationaryCategory());
        Product<ClothingCategory> obj2 = new Product<>(100.0,new ClothingCategory());
        Product<BooksCategory> obj3 = new Product<>(1000.0,new BooksCategory());

        //static method call to apply discount
        Product.applyDiscount(obj1,10);
        System.out.println(obj1.getPrice());
    }
}
