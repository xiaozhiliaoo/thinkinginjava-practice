package access.mytest;

public class LikeSingleton {
	
	private LikeSingleton(){};
	
	public static LikeSingleton getLikeSingleton(){
		return new LikeSingleton();
	}

	/**
	 *HappyBoyLi
	 *2017-1-21 ����6:48:06
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LikeSingleton s1 = LikeSingleton.getLikeSingleton();
		LikeSingleton s2 = LikeSingleton.getLikeSingleton();
		LikeSingleton s3 = LikeSingleton.getLikeSingleton();
		LikeSingleton s4 = LikeSingleton.getLikeSingleton();
		System.out.println(s1+"---"+s2+"---"+s3+"---"+s4);
	}

}
