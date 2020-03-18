package operators.test;

public class StaticTest {

	 int i = 1;
	
	/**
	 *HappyBoyLi
	 *2017-1-21 обнГ12:32:28
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticTest s1 = new StaticTest();
		
		StaticTest s2 = new StaticTest();
		System.out.println(s1.i == s2.i);
	}

}
