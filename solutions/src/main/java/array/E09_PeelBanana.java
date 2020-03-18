package array;

import java.util.ArrayList;
/****************** Exercise 9 *****************
 * Create the classes necessary for the Peel<Banana>
 * example and show that the compiler doesn’t accept
 * it. Fix the problem using an ArrayList.
 ***********************************************/

/**
 * @packgeName: array
 * @ClassName: E09_PeelBanana
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-12:42
 * @version: 1.0
 * @since: JDK 1.8
 */
class Banana {
    private final int id;

    public Banana(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

/*
剥皮
 */
class Peel<T> {
    T fruit;

    public Peel(T fruit) {
        this.fruit = fruit;
    }

    void peel() {
        System.out.println("Peeling: " + fruit);
    }
}


public class E09_PeelBanana {

    public static void main(String[] args) {
//        Peel<Banana>[] peels = new Peel<Banana>[5];
        ArrayList<Peel<Banana>> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(new Peel<Banana>(new Banana(i)));
        }
        for (Peel<Banana> bananaPeel : a) {
            bananaPeel.peel();
        }
    }
}
