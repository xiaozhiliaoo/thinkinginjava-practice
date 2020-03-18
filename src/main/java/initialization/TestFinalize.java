package initialization;

/**
 * @packgeName: initialization
 * @ClassName: TestFinalize
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/20-20:01
 * @version: 1.0
 * @since: JDK 1.8
 */
class ClassA{

    String name = "";

    ClassA(String name){
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        //调用父类的
        super.finalize();
        System.out.println(name + " 被销毁了!");
    }
}


public class TestFinalize {


    public static void main(String[] args) {
        TestFinalize finalize = new TestFinalize();
        finalize.Test();
//        System.gc();
    }

    public void Test(){
        //控制不了什么时候输出
        ClassA obj = new ClassA("Tom");
    }
}
