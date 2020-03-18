package initialization;

/**
 * @packgeName: initialization
 * @ClassName: StaticCall
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/19-21:11
 * @version: 1.0
 * @since: JDK 1.8
 */
public class StaticCall {

    public static void callInstanceMethod(String s, StaticCall call){
//        instanceMethod();
//        s.compareTo()
        System.out.println("~~");
        call.instanceMethod();
    }



    public void instanceMethod(){
        System.out.println("111");
    }

    public static void main(String[] args) {
        callInstanceMethod("s",new StaticCall());
    }
}
