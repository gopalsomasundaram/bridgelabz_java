/**
 * This Program implements a list management utility and its unit tests
 * using JUnit 5. It provides methods for modifying and querying the
 * state of integer lists, while validating the correctness of addition,
 * removal, and size retrieval operations.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides basic operations to manipulate Java Collections.
 * It encapsulates logic for adding elements, safely removing specific
 * integers by value, and calculating the total count of elements.
 */
class ListManager{
    // Adds an integer element to the provided list
    public List<Integer> addElement(List<Integer> list, int element){
        list.add(element);
        return list;
    }

    // Removes a specific integer from the list if it exists
    public List<Integer> removeElement(List<Integer> list, int element){
        // Check for existence before attempting removal
        if(list.contains(element))
            // Explicitly wrap as Integer to avoid index-based removal
            list.remove(Integer.valueOf(element));
        else{
            System.out.println("The given element is not present in the list");
        }
        return list;
    }

    // Returns the current count of elements in the list
    public int getSize(List<Integer> list){
        return list.size();
    }
}

/**
 * This class provides unit tests for the ListManager class.
 * It uses setup methods to ensure each test operates on a fresh
 * list containing a standard set of initial values.
 */
public class ListManagerTest {
    // Instance of the manager to be tested
    private ListManager managerObj;

    // Shared list instance for testing
    private List<Integer> list;

    /**
     * Initialization method that runs before each test.
     * Reconstructs the manager and the test list to maintain isolation.
     */
    @BeforeEach
    public void initObj(){
        managerObj = new ListManager();
        list = new ArrayList<>(Arrays.asList(1,2));
    }

    /**
     * Tests adding an element to verify the list correctly reflects
     * the new value in the expected order.
     */
    @Test
    void testAddElement(){
        List<Integer> result = new ArrayList<>(Arrays.asList(1,2,3));
        Assertions.assertEquals(result,managerObj.addElement(list,3));
    }

    /**
     * Tests removing an element to ensure the target value is deleted
     * while other elements remain intact.
     */
    @Test
    void testRemoveElement(){
        List<Integer> expected = new ArrayList<>(Arrays.asList(2));
        Assertions.assertEquals(expected,managerObj.removeElement(list,1));
    }

    /**
     * Tests the size retrieval logic to ensure it accurately reflects
     * the number of elements present in the list.
     */
    @Test
    void testGetSize(){
        Assertions.assertEquals(2,managerObj.getSize(list));
    }
}