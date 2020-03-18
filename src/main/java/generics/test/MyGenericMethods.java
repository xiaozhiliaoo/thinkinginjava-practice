package generics.test;

public class MyGenericMethods {

	public static <T> void f(T x){
		System.out.println(x.getClass().getName());
	}
	/**
	 *HappyBoyLi
	 *2017-1-26 обнГ8:24:55
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(1);
		f("String");
	}

}
