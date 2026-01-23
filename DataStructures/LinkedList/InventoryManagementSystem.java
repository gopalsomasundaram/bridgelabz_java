package LinkedList;

/*
this class defines the individual nodes used in the linked list
it contains the required data members itemName, itemId, quantity,
and price. it also contains a reference to the next node.
*/
class ItemNode {
    //method attributes storing relevant data
    String itemName;
    int itemId;
    int quantity;
    int price;
    //reference to the next node
    ItemNode next;

    //parameterized constructor
    ItemNode(String itemName, int itemId, int quantity, int price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

/*
this class contains and implements the main functions of the linked
list. it uses the node class to store inventory items and manages
the pointers to allow for addition, deletion, search, and sorting.
*/
class InventoryList {
    //attribute (head of linked list default value null)
    private ItemNode head;

    //constructor to initialize empty list
    InventoryList() {
        head = null;
    }

    //method to add node to the start of the linked list
    void addAtStart(String itemName, int itemId, int quantity, int price) {
        //creating new node
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        //handling case where list is empty
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //method for adding a node to the end of the linked list
    void addAtEnd(String itemName, int itemId, int quantity, int price) {
        //handling case where linked list is empty
        if (head == null) {
            addAtStart(itemName, itemId, quantity, price);
            return;
        }
        //creating new node and traversing to the end
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //method to add node at a particular position
    void addAtPosition(String itemName, int itemId, int quantity, int price, int position) {
        //case where position is head
        if (position == 1) {
            addAtStart(itemName, itemId, quantity, price);
            return;
        }
        //handle empty list case
        if (head == null) {
            System.out.println("list is empty, cannot add at position");
            return;
        }
        int count = 1;
        ItemNode temp = head;
        //traverse till node before target position
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        //check if position is reachable
        if (temp == null) {
            System.out.println("Given position is out of bounds");
            return;
        }
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //method to remove item using its ID
    void removeItemWithId(int itemId) {
        //handle case where linked list is empty
        if (head == null) {
            System.out.println("The linked list is empty");
            return;
        }
        //case where head is the node to be removed
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        //traverse till node preceding target ID
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        //perform deletion if found
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Item Id was not found in list");
        }
    }

    //method to search for node by ID
    ItemNode searchNode(int itemId) {
        ItemNode temp = head;
        //traverse until ID match is found
        while (temp != null) {
            if (temp.itemId == itemId) return temp;
            temp = temp.next;
        }
        System.out.println("Item ID not found");
        return null;
    }

    //method to search for node by name
    ItemNode searchNode(String itemName) {
        ItemNode temp = head;
        //traverse until name match is found
        while (temp != null) {
            if (temp.itemName.equals(itemName)) return temp;
            temp = temp.next;
        }
        System.out.println("Item Name not found");
        return null;
    }

    //method to update quantity using ID
    void updateItemQuantityWithId(int itemId, int quantity) {
        ItemNode node = searchNode(itemId);
        if (node != null) node.quantity = quantity;
    }

    //method to update quantity using Name
    void updateItemQuantityWithId(String itemName, int quantity) {
        ItemNode node = searchNode(itemName);
        if (node != null) node.quantity = quantity;
    }

    //method to calculate sum of (Price * Quantity)
    int calculateTotalValue() {
        ItemNode temp = head;
        int sum = 0;
        //traverse and accumulate total value
        while (temp != null) {
            sum += (temp.quantity * temp.price);
            temp = temp.next;
        }
        return sum;
    }

    //helper method to print a single node
    void printNode(ItemNode node) {
        System.out.println("Item: " + node.itemName + " | ID: " + node.itemId + " | Qty: " + node.quantity + " | Price: " + node.price);
    }

    //method to print entire list
    void printList() {
        ItemNode temp = head;
        while (temp != null) {
            printNode(temp);
            temp = temp.next;
        }
        System.out.println("------------------------------");
    }

    //helper method to swap data between two nodes
    void swapData(ItemNode node1, ItemNode node2) {
        String tempName = node1.itemName;
        node1.itemName = node2.itemName;
        node2.itemName = tempName;

        int tempId = node1.itemId;
        node1.itemId = node2.itemId;
        node2.itemId = tempId;

        int tempQty = node1.quantity;
        node1.quantity = node2.quantity;
        node2.quantity = tempQty;

        int tempPrice = node1.price;
        node1.price = node2.price;
        node2.price = tempPrice;
    }

    //method to sort list by Name in ascending order
    void sortAscendingName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode temp = head;
            while (temp.next != null) {
                if (temp.itemName.compareTo(temp.next.itemName) > 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Sorted by Name (Asc):");
        printList();
    }

    //method to sort list by Price in descending order
    void sortDescendingPrice() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            ItemNode temp = head;
            while (temp.next != null) {
                if (temp.price < temp.next.price) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        System.out.println("Sorted by Price (Desc):");
        printList();
    }
}

/*
this class implements the main function of the inventory system.
it creates an InventoryList object and performs the required
tasks in the order specified by the problem statement.
*/
public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryList obj = new InventoryList();

        //adding items to the list
        obj.addAtEnd("soap", 1, 40, 35);
        obj.addAtEnd("brick", 2, 140, 50);
        obj.addAtEnd("chips", 3, 75, 20);
        obj.addAtStart("shirts", 4, 5, 450);
        obj.addAtPosition("notebooks", 5, 30, 75, 2);

        //removing item and updating records
        obj.removeItemWithId(2);
        obj.updateItemQuantityWithId(1, 10);
        obj.updateItemQuantityWithId("chips", 10);

        //searching and value calculation
        obj.printNode(obj.searchNode(1));
        System.out.println("Total inventory value is: " + obj.calculateTotalValue());

        //performing sorting operations
        obj.sortAscendingName();
        obj.sortDescendingPrice();
    }
}
