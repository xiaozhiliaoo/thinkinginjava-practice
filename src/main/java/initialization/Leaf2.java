package initialization;

/**
 * @packgeName: initialization
 * @ClassName: Leaf2
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/19-20:46
 * @version: 1.0
 * @since: JDK 1.8
 */
public class Leaf2 {

    int i = 0;

    Leaf2 increment(int i) {
        //this.i += i;
        i+=i;
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf2 x = new Leaf2();
        x.increment(6).increment(7).increment(8).print();
    }
}
