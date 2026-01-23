package linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
this class defines the individual nodes used in the linked list
to represent a social media user. it contains data members for
userId, name, and age, along with a list of friendIds to store
connections. it also contains a reference to the next user node.
*/
class UserNode {
    //method attributes storing user details and connections
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    //reference to the next user in the list
    UserNode next;

    //parameterized constructor to initialize user data
    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

/*
this class contains and implements the main functions of the social
media system. it uses a singly linked list to store users and provides
methods to manage friendships, find mutual connections, and search for
users by various criteria.
*/
class SocialList {
    //attribute (head of linked list default value null)
    private UserNode head;

    //method to add a new user node to the system
    void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        //handling case where list is empty
        if (head == null) {
            head = newNode;
            return;
        }
        //traversing to the end of the list to append new user
        UserNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //1. method to add a friend connection between two users
    void addFriendConnection(int id1, int id2) {
        //searching for both users in the list
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        //adding IDs to mutual friend lists if both users exist
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(id2)) user1.friendIds.add(id2);
            if (!user2.friendIds.contains(id1)) user2.friendIds.add(id1);
            System.out.println("Connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both User IDs not found.");
        }
    }

    //2. method to remove a friend connection between two users
    void removeFriendConnection(int id1, int id2) {
        //searching for both users in the list
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        //removing IDs from friend lists if connection exists
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(id2));
            user2.friendIds.remove(Integer.valueOf(id1));
            System.out.println("Connection removed between " + user1.name + " and " + user2.name);
        }
    }

    //3. method to find and display mutual friends between two users
    void findMutualFriends(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        //handle case where users are not found
        if (user1 == null || user2 == null) return;

        System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
        boolean found = false;
        //comparing friend lists to find common IDs
        for (int fId : user1.friendIds) {
            if (user2.friendIds.contains(fId)) {
                UserNode mutual = searchById(fId);
                System.out.print(mutual.name + " ");
                found = true;
            }
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    //4. method to display all friends of a specific user
    void displayFriends(int userId) {
        UserNode user = searchById(userId);
        //handle null case
        if (user == null) return;

        System.out.print(user.name + "'s Friends: ");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends found.");
            return;
        }
        //iterating through friend IDs and printing names
        for (int fId : user.friendIds) {
            UserNode friend = searchById(fId);
            if (friend != null) System.out.print(friend.name + " (ID: " + fId + ") ");
        }
        System.out.println();
    }

    //5. methods to search for a user by ID or Name
    UserNode searchById(int userId) {
        UserNode temp = head;
        //traverse list until ID match is found
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    UserNode searchByName(String name) {
        UserNode temp = head;
        //traverse list until name match is found ignoring case
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    //6. method to count and display friend counts for each user
    void countFriends() {
        System.out.println("\nFriend Counts:");
        UserNode temp = head;
        //iterating through all users to print their list size
        while (temp != null) {
            System.out.println(temp.name + ": " + temp.friendIds.size() + " friends");
            temp = temp.next;
        }
    }
}

/*
this class implements the main function of the system. it creates an
object of SocialList and performs the operations of adding users,
connecting friends, and searching in the specified order.
*/
public class SocialMediaConnections {
    public static void main(String[] args) {
        //object creation
        SocialList sns = new SocialList();

        //populating the social media system with users
        sns.addUser(101, "Alice", 22);
        sns.addUser(102, "Bob", 23);
        sns.addUser(103, "Charlie", 21);
        sns.addUser(104, "David", 24);

        //1. adding friend connections
        sns.addFriendConnection(101, 102); // Alice - Bob
        sns.addFriendConnection(101, 103); // Alice - Charlie
        sns.addFriendConnection(104, 102); // David - Bob
        sns.addFriendConnection(104, 103); // David - Charlie

        //2. removing a friend connection
        sns.removeFriendConnection(101, 102);

        //3. finding mutual friends
        sns.findMutualFriends(101, 104);

        //4. displaying friends of a specific user
        sns.displayFriends(104);

        //5. searching for a user by name
        UserNode found = sns.searchByName("Alice");
        if (found != null) System.out.println("Search result: Found " + found.name + ", Age " + found.age);

        //6. displaying total friend count for each user
        sns.countFriends();
    }
}