//: arrays/ParameterizedArrayType.java
package arrays;

/*class Demo1{
    public  T fun(T t){
		return t;
	}
}

class Demo2{
	public <T> T fun(T t){
		return t;
	}
}

class Demo3{
	public static <T> T fun(T t){
		return t;
	}
}

class Demo4{
	public static T fun(T t){
		return t;
	}
}

class Demo5<T>{
	public  T fun(T t){
		return t;
	}
}

class Demo6<T>{
	
	public  <T> T fun(T t){
		return t;
	}
}

class Demo7<T>{
	public static <T> T fun(T t){
		return t;
	}
}

class Demo8<T>{
	public static  T fun(T t){
		return t;
	}
}*/

//Peel<Banana>[] peels = new Peel<Banana>[10]  错误！！！

/**
 * 类参数可以这样传入
 */
class ClassParameter<T> {

    public T[] f(T[] arg) {
        return arg;
    }
}

/**
 * 方法参数可以这样传入
 */
class MethodParameter {

    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {

        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};


        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        System.out.println(ints2);
        System.out.println(doubles2);

        ints2 = MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
        System.out.println(ints2);
        System.out.println(doubles2);

    }
}

///:~
