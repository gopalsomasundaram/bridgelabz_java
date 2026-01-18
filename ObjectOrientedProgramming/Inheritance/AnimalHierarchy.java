package Inheritance;

/*
 * This class represents a generic Animal
 * with common properties and behavior.
 */
class Animal {

    // Name of the animal
    String name;

    // Age of the animal
    int age;

    // Constructor to initialize animal details
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to define animal sound (to be overridden)
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

/*
 * This class represents a Dog
 * and overrides the makeSound() method.
 */
class Dog extends Animal {

    // Constructor to initialize dog details
    Dog(String name, int age) {
        super(name, age);
    }

    // Dog-specific sound
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

/*
 * This class represents a Cat
 * and overrides the makeSound() method.
 */
class Cat extends Animal {

    // Constructor to initialize cat details
    Cat(String name, int age) {
        super(name, age);
    }

    // Cat-specific sound
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

/*
 * This class represents a Bird
 * and overrides the makeSound() method.
 */
class Bird extends Animal {

    // Constructor to initialize bird details
    Bird(String name, int age) {
        super(name, age);
    }

    // Bird-specific sound
    @Override
    void makeSound() {
        System.out.println("Bird chirps");
    }
}

public class AnimalHierarchy{
    public static void main(String[] args){
        Dog obj1 = new Dog("john",2);
        obj1.makeSound();
    }
}