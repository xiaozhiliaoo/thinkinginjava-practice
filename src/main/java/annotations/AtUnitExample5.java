//: annotations/AtUnitExample5.java
package annotations;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCleanup;
import net.mindview.atunit.TestObjectCreate;
import net.mindview.atunit.TestProperty;
import net.mindview.util.OSExecute;

import java.io.IOException;
import java.io.PrintWriter;

public class AtUnitExample5 {
    private String text;

    public AtUnitExample5(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }

    @TestProperty
    static PrintWriter output;

    @TestProperty
    static int counter;

    @TestObjectCreate
    static AtUnitExample5 create() {
        String id = Integer.toString(counter++);
        try {
            output = new PrintWriter("Test" + id + ".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new AtUnitExample5(id);
    }

    /**
     * 基于直接的清除对象
     * @param tobj
     */
    @TestObjectCleanup
    static void cleanup(AtUnitExample5 tobj) {
        //必须静态 没有返回值的
        System.out.println("Running cleanup");
        output.close();
    }

    @Test
    boolean test1() {
        output.print("test1");
        return true;
    }

    @Test
    boolean test2() {
        output.print("test2");
        return true;
    }

    @Test
    boolean test3() {
        output.print("test3");
        return true;
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("cd .. && cd thinkinjava\\target\\classes  && java net.mindview.atunit.AtUnit annotations\\AtUnitExample5");
    }
} /* Output:
annotations.AtUnitExample5
  . test1
Running cleanup
  . test2
Running cleanup
  . test3
Running cleanup
OK (3 tests)
*///:~
