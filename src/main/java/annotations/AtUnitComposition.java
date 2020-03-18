//: annotations/AtUnitComposition.java
// Creating non-embedded tests.
package annotations;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

/**
 * 通过组合来进行单元测试
 */
public class AtUnitComposition {

    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return testObject.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String[] args) throws Exception {
        //首先OSExecute.command("cd") 查看当前目录  然后根据当前目录位置来确认编译后classes目录在哪里
        //OSExecute.command("cd .. && cd thinkinjava\\target\\classes\\net\\mindview\\atunit && dir");

        OSExecute.command("cd .. && cd thinkinjava\\target\\classes  && java net.mindview.atunit.AtUnit annotations\\AtUnitComposition");
    }
} 
/* Output:
annotations.AtUnitComposition
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
