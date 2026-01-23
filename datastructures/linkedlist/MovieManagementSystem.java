package linkedlist;

/*
this class defines the individual nodes used in the linked list
it contains the required data members movieTitle, director
yearOfRelease and rating, it also contains references to the next and
the previous nodes.
*/
class MovieNode{
    //method attributes storing relevant data
    String movieTitle;
    String director;
    int yearOfRelease;
    float rating;
    //references to the next and the previous node
    MovieNode next ,prev;

    //parameterized constructor
    MovieNode(String movieTitle,String director,int yearOfRelease, float rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev= null;
    }
}

/*
this class contains and implements the main functions of the linked
list, it uses the node class to allow for storage data and manipulates
the references of the nodes to allow pointing to other nodes.
when object of this class is created head is declared and differenct
methods such as adding to front at a specific position or in the back
it also contains methods for removing, searching and printing nodes
 */
class MovieLinkedList{
    //attribute (head of linked list default value null)
    private MovieNode head;

    //method for adding a node to the end of the linked list
    void addAtEnd(String movieTitle,String director,int yearOfRelease, float rating){
        //creating new node
        MovieNode newNode = new MovieNode(movieTitle,director,yearOfRelease,rating);
        //handling case where linked list is empty
        if(head == null){
            head = newNode;
            return;
        }
        //traversing the linked list till the end
        MovieNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    //method to add node to the start of the linked list
    void addAtStart(String movieTitle,String director,int yearOfRelease, float rating){
        //creating new node
        MovieNode newNode = new MovieNode(movieTitle,director,yearOfRelease, rating);
        //handling case where linked list is empty
        if(head == null){
            head= newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //method to add node at a particular position
    void addAtPosition(String movieTitle,String director,int yearOfRelease, float rating,int position){
        //creating new node
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        //case where position is invalid
        if(position<1){
            System.out.println("Invalid position");
            return;
        }
        //case where position is head
        if(position == 1){
            addAtStart(movieTitle, director, yearOfRelease, rating);
            return;
        }
        int count = 1;
        MovieNode temp = head;
        //traverse linked list till before given position
        while(temp!=null && count<position-1){
            temp = temp.next;
            count++;
        }
        //if null its out of bounds
        if(temp==null){
            System.out.println("Position is out of bounds");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        if(temp.next!=null){
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    //method to remove node with particular title
    void removeByTitle(String title){
        //handle case where linked list is empty
        if(head==null){
            System.out.println("The linked list is empty already");
        }
        //traverse till title is found
        MovieNode temp = head;
        while(temp!=null){
            if(temp.movieTitle.equals(title)){
                if(temp == head){
                    head = head.next;
                }
                if(temp.prev!=null){
                    temp.prev.next = temp.next;
                }
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    //method to return function with given director name
    MovieNode searchNode(String director){
        MovieNode temp = head;
        //handle case where linked list is empty
        while(temp!=null){
            if(temp.director.equals(director)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //method to return function with given rating (overloading searchNode)
    MovieNode searchNode(float rating){
        MovieNode temp = head;
        //handling case where linked list is empty
        while(temp!=null){
            if(temp.rating == rating){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //method to print given node
    void printNode(MovieNode node){
        if(node == null){
            System.out.println("given node is null");
            return;
        }
        System.out.println("Title: "+node.movieTitle);
        System.out.println("director: "+node.director);
        System.out.println("year of Release: "+node.yearOfRelease);
        System.out.println("rating: "+node.rating);
        System.out.println("----------------------------");
    }

    //method to print all the nodes in the list forward and reverse
    void printLinkedList(){
       System.out.println("Printing all of the nodes in linked list");
       MovieNode temp = head;
       MovieNode last = null;
       while(temp!=null){
            printNode(temp);
            if(temp.next == null) last = temp;
            temp = temp.next;
       }
       System.out.println("Now print in reverse");
       while(last!= null){
           printNode(last);
           last = last.prev;
       }
    }

    //method to update rating of node with particular title
    void updateRating(String title, float rating){
        //handle case where list is empty
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        MovieNode temp = head;
        while(temp!=null){
            if(temp.movieTitle.equals(title)){
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("movie title was not found");
    }
}
/*
This class implement the main function of the file. It creates an
object of MovieLinkedList and then uses it to perform
various functions using them like adding, deleting and searching for nodes
*/
public class MovieManagementSystem {
    public static void main(String[] args){
        //object creation
        MovieLinkedList llObj = new MovieLinkedList();

        //adding objects to the linked list
        llObj.addAtEnd("Avatar","cameron",2004,1.2f);
        llObj.addAtEnd("Avatar 2","cameron",2024,4.2f);
        llObj.addAtPosition("spiderman","parker",2013,3.4f,2);
        llObj.addAtStart("spiderman 2","peter",2020,2.5f);

        //removing node using title
        llObj.removeByTitle("spiderman");

        //searching and printing node with particular director name
        llObj.printNode(llObj.searchNode("cameron"));

        //searching and printing node with particular rating name
        llObj.printNode(llObj.searchNode(2.5f));

        //print the entire linked list
        llObj.printLinkedList();

        //update the rating of node with particular title
        llObj.updateRating("Avatar",0.1f);

    }
}
