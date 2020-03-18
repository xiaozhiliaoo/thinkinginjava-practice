package generics;//: generics/SuperTypeWildcards.java

import java.util.*;

public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
//        apples.add(new Orange())
    }


    public static void main(String[] args) {

        List<Apple> alist = new ArrayList<Apple>();

        writeTo(alist);
        List<Fruit> flist = new ArrayList<Fruit>();

        writeTo(flist);


    }
} ///:~
