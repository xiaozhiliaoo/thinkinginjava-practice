//: typeinfo/GenericClassReferences.java
package typeinfo;

public class GenericClassReferences {

    public static void main(String[] args) {

        Class intClass = int.class;
        //只能存Integer
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing
        intClass = double.class;
        // genericIntClass = double.class; // Illegal
//        Class<Number> genericNumber = int.class;
    }
} ///:~
