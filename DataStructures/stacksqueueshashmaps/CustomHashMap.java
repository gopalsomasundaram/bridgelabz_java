package stacksqueueshashmaps;

/*
this class implements a basic custom hash map using separate
chaining (array of linked lists) to handle collisions. it
provides core functionalities for inserting, retrieving, and
deleting key-value pairs.
*/
public class CustomHashMap {

    //node class for linked list entries
    class Entry {
        String key;
        int value;
        Entry next;
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //attributes for the hash map
    private Entry[] buckets;
    private int capacity = 16;

    //constructor initializing the bucket array
    public CustomHashMap() {
        buckets = new Entry[capacity];
    }

    //hash function to determine bucket index
    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    //method to insert or update a key-value pair
    public void put(String key, int value) {
        int index = getBucketIndex(key);
        Entry head = buckets[index];

        //search for existing key to update
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        //if key not found, insert new entry at head
        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
    }

    //method to retrieve value by key
    public Integer get(String key) {
        int index = getBucketIndex(key);
        Entry head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    //method to remove an entry by key
    public void remove(String key) {
        int index = getBucketIndex(key);
        Entry head = buckets[index];
        Entry prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) prev.next = head.next;
                else buckets[index] = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    //main function to demonstrate custom hash map operations
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("Alice", 25);
        map.put("Bob", 30);
        System.out.println("Alice's age: " + map.get("Alice"));
        map.remove("Alice");
        System.out.println("Alice's age after removal: " + map.get("Alice"));
    }
}