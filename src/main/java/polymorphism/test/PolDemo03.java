package polymorphism.test;

class A1{					// ������A
	public void fun1(){		// ����fun1()����
		System.out.println("A --> public void fun1(){}") ;
	}
	public void fun2(){
		System.out.println("A --> public void fun2(){}") ;		// ����fun1()����
	}
};
class B1 extends A1{
	public void fun1(){		// �˷��������าд��
		System.out.println("B --> public void fun1(){}") ;
	}
	public void fun3(){
		System.out.println("B --> public void fun3(){}") ;
	}
};

public class PolDemo03{
	public static void main(String asrgs[]){
		A1 a = new B1() ;			// ����ת�͹�ϵ
//		a.fun3();
	}
};