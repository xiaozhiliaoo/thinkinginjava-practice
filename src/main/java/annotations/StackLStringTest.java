//: annotations/StackLStringTest.java
// Applying @Unit to generics.
package annotations;

import net.mindview.atunit.*;
import net.mindview.util.*;

/**
 * 测试泛型类，写一个继承的方法既可以
 */
public class StackLStringTest extends StackL<String> {

    @Test
    void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void _top() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("cd .. && cd thinkinjava\\target\\classes  && java net.mindview.atunit.AtUnit annotations\\StackLStringTest");
    }
} /* Output:
annotations.StackLStringTest
  . _push
  . _pop
  . _top
OK (3 tests)
*///:~
