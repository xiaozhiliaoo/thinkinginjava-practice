package arrays;

/**
 * @packgeName: arrays
 * @ClassName: TestInterface
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-18:49
 * @version: 1.0
 * @since: JDK 1.8
 */
interface A<T>{
    boolean equals(Object obj);

    int compare(T o1, T o2);


}


public class TestInterface implements A<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }

    //接口中方法不用必须实现，如果是Object方法，则隐式实现。
}
