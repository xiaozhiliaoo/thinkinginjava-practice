package exceptions;//: exceptions/CleanupIdiom.java
// Each disposable object must be followed by a try-finally

//释放资源的惯例用法
class NeedsCleanup { // Construction can't fail
    //静态计数器
    private static long counter = 1;

    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {}



class NeedsCleanup2 extends NeedsCleanup {
    // Construction can fail:
    public NeedsCleanup2() throws ConstructionException {
    }
}

public class CleanupIdiom {

    public static void main(String[] args) {
        // Section 1:方式一，可清除对象后立马清除
        NeedsCleanup nc1 = new NeedsCleanup();
        //释放资源
        try {
            // ...
        } finally {
            nc1.dispose();
        }

        // Section 2: 群组方式
        // If construction cannot fail you can group objects:
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // ...
        } finally {
            nc3.dispose(); // Reverse order of construction
            nc2.dispose();
        }

        // Section 3:  嵌套方式，构造方式抛出异常
        // If construction can fail you must guard each one:
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                //释放资源
                try {
                    // ...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) { // nc5 constructor
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) { // nc4 constructor
            System.out.println(e);
        }
    }
} /* Output:
NeedsCleanup 1 disposed
NeedsCleanup 3 disposed
NeedsCleanup 2 disposed
NeedsCleanup 5 disposed
NeedsCleanup 4 disposed
*///:~
