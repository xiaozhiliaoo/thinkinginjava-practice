package initialization.test;

public class DynamicArray {

	/**
	 *HappyBoyLi
	 *2017-1-21 обнГ5:15:52
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Other.main(new String[]{"ddd1","ddd2","ddd3"});
	}

}

class Other{
	public static void main(String args[]){
		for(String s: args){
			System.out.println(s+" ");
		}
	}
}
