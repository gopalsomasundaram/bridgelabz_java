package LinkedList;
/*
this is the basic node class to be used in the linked list, it contains the required data members and also
refernces to the next node which is initialized as null. the nodes also stores roll number, name, age, grade
*/
class Node{
    //data members of each attribute
    int rollNumber;
    String name;
    int age;
    char grade;
    //reference to next node
    Node next;
    //default constructor

    //parameterized constructor
    public Node(int rollNumber, String name, int age, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
/*
this class contains the main functions of the linked list
an object of this class is created when a new linked list needs to be created it contains all
the functions of a linked list such as adding nodes at start, end or any points
and searching for particular node and update the grade of a node with particular roll numbers
and deleting nodes with particular roll Number
 */
class StudentLinkedList{
    private Node head;
    //method to add node to the end of the linked list
    void addToEnd(int rollNumber, String name, int age, char grade){
        Node newNode = new Node(rollNumber,name,age,grade);
        //if linked list is empty add it to the start of the list
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        //move reference variable to you reach last node
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    //method to add data after a node with a specific roll number
    void addAfterSpecificRollNumber(int rollNumber, String name, int age, char grade,int searchRoll){
        Node node = searchByRoll(searchRoll);
        //handling case of empty linked list
        if(node == null){
            System.out.println("given roll number: "+searchRoll+" couldn't be found");
            return;
        }
        Node newNode = new Node(rollNumber,name,age,grade);
        //add to start
        newNode.next = node.next;
        node.next = newNode;
    }
    //method to add node to the start of the linked list
    void addAtBeginning(int rollNumber, String name, int age, char grade){
        Node newNode = new Node(rollNumber,name,age,grade);
        newNode.next = head;
        head = newNode;
    }
    //method to print the data in one node
    void printNodeData(Node node) {
        System.out.println("Name: "+node.name);
        System.out.println("Roll Number: "+node.rollNumber);
        System.out.println("Age: "+node.age);
        System.out.println("Grade: "+node.grade);
        System.out.println("---------------------");
    }
    //method that returns reference to a node which has a particular roll number
    Node searchByRoll(int searchRoll){
        //handle case where linked list is empty
        if(head==null){
            System.out.println("linked list is already empty so can't find node with roll number: "+searchRoll);
            return null;
        }
        //head has the desired node
        if(head.rollNumber == searchRoll){
            return head;
        }
        //search for node with the desired roll number
        Node temp = head;
        while(temp.next!=null&&temp.next.rollNumber != searchRoll){
            temp = temp.next;
        }
        if(temp.next != null){
            //return node if found
            return temp.next;
        }else{
            //else return null
            System.out.println("given roll number: "+searchRoll+" couldn't be found in the linked list");
            return null;
        }
    }
    //method that searched for node using roll number given and updates the grade for that node
    void updateGradeByRollNumber(int searchRoll, char newGrade){
        Node node = searchByRoll(searchRoll);
        //handle empty case
        if(node == null){
            System.out.println("given roll number: "+searchRoll+" couldn't be found to update grade");
            return ;
        }
        node.grade = newGrade;
        System.out.println(node.name+"'s grade has been updated");
    }
    //method that deleted node with particular roll number
    void deleteByRoll(int searchRoll){
        //handle empty case
        if(head==null){
            System.out.println("linked list is already empty so can't delete node with roll number: "+searchRoll);
            return;
        }
        //if head needs to be deleted
        if(head.rollNumber == searchRoll){
            head = head.next;
            return;
        }
        //find and delete node with roll number
        Node temp = head;
        while(temp.next!=null&&temp.next.rollNumber != searchRoll){
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        }else{
            System.out.println("given roll number: "+searchRoll+" couldn't be found in the linked list");
        }
    }
    //method to print all the data in linked list
    void printLinkedListData(){
        Node temp = head;
        System.out.println("Printing data in all nodes");
        while(temp!=null){
            System.out.println("Name: "+temp.name);
            System.out.println("Roll Number: "+temp.rollNumber);
            System.out.println("Age: "+temp.age);
            System.out.println("Grade: "+temp.grade);
            System.out.println("---------------------");
            //move to next node
            temp=temp.next;
        }
    }
}
/*
this class implements the main functions of the program
it creates an object of the SudentLinkedList class
using which different methods of the same class are used
 */
public class StudentRecordManagement {
    public static void main(String[] args){
        //object creation
        StudentLinkedList llObj = new StudentLinkedList();
        //adding elements to the linked list
        llObj.addToEnd(1,"Dev",22,'O');
        llObj.addToEnd(2,"Sunny",42,'A');
        llObj.addToEnd(3,"Adam",32,'B');
        llObj.addToEnd(4,"Bharat",12,'A');
        llObj.addToEnd(5,"David",44,'A');

        //adding node to start
        llObj.addAtBeginning(9,"Adnan",36,'C');

        //adding node after specific roll number
        llObj.addAfterSpecificRollNumber(11,"Prince",57,'O',5);

        //delete particular node with particular roll number
        llObj.deleteByRoll(3);

        //search and print node with particular roll number
        llObj.printNodeData(llObj.searchByRoll(11));

        //update grade of node with particular rollNumber
        llObj.updateGradeByRollNumber(11,'O');

        //display all nodes
        llObj.printLinkedListData();
    }
}
