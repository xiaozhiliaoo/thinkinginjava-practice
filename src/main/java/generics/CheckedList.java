package generics;//: generics/CheckedList.java
// Using Collection.checkedList().

import typeinfo.pets.*;
import typeinfo.pets.Cat;

import java.util.*;

public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        //放狗却放入了猫
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {

        List<Dog> dogs1 = new ArrayList<Dog>();
//        dogs1.add(new Cat());
        //放入猫也可以
        oldStyleMethod(dogs1); // Quietly accepts a Cat


        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println(e);
        }

        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);

        pets.add(new Dog());
        pets.add(new Cat());

    }
} /* Output:
java.lang.ClassCastException: Attempt to insert class typeinfo.pets.Cat element into collection with element type class typeinfo.pets.Dog
*///:~
