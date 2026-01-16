package ConstructorsAccessModifiers.Level1;

public class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String n, int a) {
        name = n;
        age = a;
    }

    // Copy constructor
    Person(Person p) {
        name = p.name;
        age = p.age;
    }

    void displayData() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 22); // original object
        Person p2 = new Person(p1);          // cloned object

        p1.displayData();
        System.out.println();
        p2.displayData();
    }
}