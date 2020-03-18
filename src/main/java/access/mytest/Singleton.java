package access.mytest;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	private Singleton(){};
	public static Singleton getSingleton(){
		return singleton;
	}

	/**
	 *HappyBoyLi
	 *2017-1-21 ����6:44:54
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		Singleton s3 = Singleton.getSingleton();
		Singleton s4 = Singleton.getSingleton();
		System.out.println(s1+"---"+s2+"---"+s3+"---"+s4);
	}

}
