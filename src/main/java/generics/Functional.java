package generics;//: generics/Functional.java

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static net.mindview.util.Print.print;

// Different types of function objects:
//----------------------策略接口-----------------------------//
//组合器
interface Combiner<T> {
    T combine(T x, T y);
}

//一元函数
interface UnaryFunction<R, T> {
    R function(T x);
}

//收集器,收集结果，并输出，有点类似于JDK8的流式过滤集合最后调用java.util.stream.Collectors类
interface Collector<T> extends UnaryFunction<T, T> {
    T result(); // Extract result of collecting parameter
}

//一元断言
interface UnaryPredicate<T> {
    boolean test(T x);
}

//比较器接口，具体的比较方法传入策略 Comparable<T>,Comparator<T>
interface Compare<T>{
    int compare(T o1, T o2);
}


public class Functional {

    //从大到小,从小到大,返回排序后的list
    public static <T> List<T> sort(Iterable<T> seq,Compare<T> compare){
        Iterator<T> it = seq.iterator();
        List<T> result = new ArrayList<T>();
//        Arrays.sort();
        //实现具体的排序算法
        for(T t:seq){

        }

        return result;
    }

    // Calls the Combiner object on each element to combine
    // it with a running result, which is finally returned:
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();

        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext()) {
                result = combiner.combine(result, it.next());
            }
            return result;
        }
        // If seq is the empty list:
        return null; // Or throw exception
    }

    // Take a function object and call it on each object in
    // the list, ignoring the return value. The function
    // object may act as a collecting parameter, so it is
    // returned at the end.
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq) {
            func.function(t);
        }
        return func;
    }

    // Creates a list of results by calling a
    // function object for each object in the list:
    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<R>();
        for (T t : seq) {
            result.add(func.function(t));
        }
        return result;
    }

    // Applies a unary predicate to each item in a sequence,
    // and returns a list of items that produced "true":
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<T>();
        for (T t : seq) {
            if (pred.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    static class IntegerSort implements Compare<Integer>{

        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }

    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    //整形相加器
    static class IntegerAdder implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    //整形相减器
    static class IntegerSubtracter implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }


    //小数相加
    static class BigDecimalAdder implements Combiner<BigDecimal> {
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    //小数相减
    static class BigDicimalSubtracter implements Combiner<BigDecimal>{
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    }

    //
    static class BigIntegerAdder implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class BigIntegerSubtraacter implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.subtract(y);
        }
    }


    static class AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // Not clear whether this is meaningful:
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    // We can even make a UnaryFunction with an "ulp"
    // (Units in the last place):
    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class LessThan<T extends Comparable<T>> implements UnaryPredicate<T>{

        private T bound;

        public LessThan(T bound){
            this.bound = bound;
        }

        public boolean test(T x) {
            return x.compareTo(bound) < 0;
        }
    }

    static class Equaler<T extends Comparable<T>> implements UnaryPredicate<T>{

        private T bound;

        public Equaler(T bound) {
            this.bound = bound;
        }

        public boolean test(T x) {
            return x.compareTo(bound) == 0;
        }
    }


    static class MultiplyingIntegerCollector implements Collector<Integer> {

        private Integer val = 1;

        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        public Integer result() {

            return val;
        }

    }

    public static final Combiner<Integer> INTEGER_ADDER_COMBINER_PUBLIC = new IntegerAdder();


    private static final Combiner<Integer> INTEGER_ADDER_COMBINER_PRIVATE = new IntegerAdder();


    public static void main(String[] args) {

        // Generics, varargs & boxing working together:
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //这里也可以不加Functional.  和Arrays.sort(T[] a, Comparator<? super T> c) 很类似
        // 使用静态内部类来创建具体策略
        Integer result = Functional.reduce(li, new IntegerAdder());
        print(result);//1+2+3+4+5+6+7 = 28

        //策略类使用匿名类创建
        Integer resultAnonymous = Functional.reduce(li, new Combiner<Integer>() {
            public Integer combine(Integer x, Integer y) {
                return x+y;
            }
        });
        print(resultAnonymous);

        //策略类使用公有静态域  函数对象起了一个有意义的名字
        Integer resultPublicField = Functional.reduce(li,INTEGER_ADDER_COMBINER_PUBLIC);
        print(resultPublicField);

        //策略类使用私有静态域
        Integer resultPrivateField = Functional.reduce(li,INTEGER_ADDER_COMBINER_PRIVATE);
        print(resultPrivateField);

        //String的内部静态公有比较器也是实现了比较器
        //String.CASE_INSENSITIVE_ORDER

        result = Functional.reduce(li, new IntegerSubtracter());
        print(result);//1-2-3-4-5-6-7 = -26

        print(Functional.filter(li, new GreaterThan<Integer>(4)));  //[5,6,7]

        print(Functional.forEach(li, new MultiplyingIntegerCollector()).result());//1*2*3*4*5*6*7=5040

        print(Functional.forEach(filter(li, new GreaterThan<Integer>(4)), new MultiplyingIntegerCollector()).result()); //5*6*7

        //创建BigDecimal时候需要的参数
        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc), new BigDecimal(4.4, mc));
        BigDecimal rbd = Functional.reduce(lbd, new BigDecimalAdder());//11.00
        print(rbd);

        print(Functional.filter(lbd, new GreaterThan<BigDecimal>(new BigDecimal(3))));//3.300000   4.400000

        // Use the prime-generation facility of BigInteger:
        List<BigInteger> lbi = new ArrayList<BigInteger>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        print(lbi);   //模拟质数   [11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]


        BigInteger rbi = Functional.reduce(lbi, new BigIntegerAdder());
        print(rbi);
        // The sum of this list of primes is also prime:
        print(rbi.isProbablePrime(5));  //true

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133));
        AtomicLong ral = Functional.reduce(lal, new AtomicLongAdder());
        print(ral);  //11+47+74+133=265

        print(Functional.transform(lbd, new BigDecimalUlp()));



    }
} /* Output:
28
-26
[5, 6, 7]
5040
210
11.000000
[3.300000, 4.400000]
[11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
311
true
265
[0.000001, 0.000001, 0.000001, 0.000001]
*///:~
