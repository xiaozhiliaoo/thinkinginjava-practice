package exceptions;

/**
 * @packgeName: exceptions
 * @ClassName: Test
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/8/19-16:29
 * @version: 1.0
 * @since: JDK 1.8
 */

class A extends Exception{};
class B extends Exception{};


public class Test {

    public static  void f() throws A{
        throw new A();
    }

//    public static void main(String[] args) {
//        try {
//            try {
//                f();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }catch (A a){
//            a.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            f();
        } catch (A a) {

        }
    }
}
