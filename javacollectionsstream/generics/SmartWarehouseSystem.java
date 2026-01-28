package generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    abstract void printType();

    void printWareHouseNumber(){
        System.out.println("123");
    }
}

class Electronics extends  WarehouseItem{
    @Override
    void printType() {
        System.out.println("Electronics");
    }
}
class Groceries extends  WarehouseItem{
    @Override
    void printType() {
        System.out.println("Groceries");
    }
}
class Furniture extends  WarehouseItem{
    @Override
    void printType() {
        System.out.println("Furniture");
    }
}

class Storage<T extends WarehouseItem>{
    private List<T> itemArray = new ArrayList<>();

    void printItemsInStorage(List<? extends WarehouseItem> itemArray){
        System.out.println("There are "+itemArray.size()+" items in storage");
        for(WarehouseItem item: itemArray){
            item.printType();
        }
    }

    List<T> getItemArray(){
        return itemArray;
    }

    void setItemArray(List<T> itemArray){
        this.itemArray = itemArray;
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args){
        Storage<WarehouseItem> storage = new Storage<>();
        List<WarehouseItem> itemArray = storage.getItemArray();
        WarehouseItem elec1 = new Electronics();
        WarehouseItem elec2 = new Electronics();
        WarehouseItem groc1 = new Groceries();
        WarehouseItem groc2 = new Groceries();
        WarehouseItem furn1 = new Furniture();
        WarehouseItem furn2 = new Furniture();
        itemArray.add(elec1);
        itemArray.add(elec2);
        itemArray.add(groc1);
        itemArray.add(groc2);
        itemArray.add(furn1);
        itemArray.add(furn2);
        storage.printItemsInStorage(itemArray);
    }
}
