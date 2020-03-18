package generics;//: generics/CountedObject.java

public class CountedObject {


    private static long counter = 0;
    //id不能改
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }
} ///:~
