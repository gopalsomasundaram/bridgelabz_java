/**
 * This Program demonstrates sorting a list of custom objects
 * using a lambda expression as a Comparator.
 * * @author gopal
 */
package functional;

import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }
}

public class SortObjectsByAge {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Gopal", 21, 50000),
                new Person("Amit", 25, 60000),
                new Person("Rahul", 19, 45000)
        ));

        // Lambda (p1, p2) -> comparison logic
        // Sorts in ascending order based on the age integer
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        System.out.println("Sorted by age: " + people);
    }
}