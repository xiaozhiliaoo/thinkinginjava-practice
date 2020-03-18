package generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @packgeName: generics
 * @ClassName: Functional2
 * @copyright: CopyLeft
 * @description:<描述>  使用函数对象作为策略从而产生更加泛化的代码
 * @author: lili
 * @date: 2017/8/26-18:22
 * @version: 1.0
 * @since: JDK 1.8
 */
interface Combiner1<T> {
    T combine(T x, T y);
}

interface UnaryFunction1<R,T>{
    R function(T x);
}

interface Collector1<T> extends UnaryFunction1<T,T>{
    T result();
}

interface UnaryPredicate1<T>{
    boolean test(T x);
}

public class Functional2 {

    public static  <T> T reduce(Iterable<T> seq, Combiner1<T> combiner1){
        Iterator<T> iterator = seq.iterator();
        if(iterator.hasNext()){
            T result = iterator.next();
            while (iterator.hasNext()){
                result = combiner1.combine(result,iterator.next());
            }
            return result;
        }
        return null;
    }

    public static <T> Collector1<T> forEach(Iterable<T>seq, Collector1<T> func){
        for(T t:seq){
            func.function(t);
        }
        return func;
    }

    public static <R,T> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func){
        List<R> result = new ArrayList<R>();
        for(T t:seq){
            result.add(func.function(t));
        }
        return result;
    }

    public static <T> List<T> filter(Iterable<T> seq,UnaryPredicate1<T> pred){
        List<T> result = new ArrayList<T>();
        for(T t:seq){
            if(pred.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    static class IntegerAdder implements Combiner1<Integer>{
        public Integer combine(Integer x, Integer y) {
            return x+y;
        }
    }

    static class IntegerSubtracter implements Combiner1<Integer>{

        public Integer combine(Integer x, Integer y) {
            return x-y;
        }
    }

    static class BigDecimalAdder implements Combiner1<BigDecimal>{
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAddr implements Combiner1<BigInteger>{
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }



    public static void main(String[] args) {
        //测试整数相加器


    }























}
