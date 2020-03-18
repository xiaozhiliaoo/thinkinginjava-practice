package polymorphism.test;

class A1{					// 定义类A
	public void fun1(){		// 定义fun1()方法
		System.out.println("A --> public void fun1(){}") ;
	}
	public void fun2(){
		System.out.println("A --> public void fun2(){}") ;		// 调用fun1()方法
	}
};
class B1 extends A1{
	public void fun1(){		// 此方法被子类覆写了
		System.out.println("B --> public void fun1(){}") ;
	}
	public void fun3(){
		System.out.println("B --> public void fun3(){}") ;
	}
};

public class PolDemo03{
	public static void main(String asrgs[]){
		A1 a = new B1() ;			// 向上转型关系
//		a.fun3();
	}
};