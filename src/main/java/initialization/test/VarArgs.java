package initialization.test;

class A{
	public String toString(){
		return "ss";
	}
}

public class VarArgs {
	static void printArray(Object... args){
		for(Object obj: args){
			System.out.println(obj+" ");
		}
	}
	

	/**
	 *HappyBoyLi
	 *2017-1-21 ����5:29:19
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printArray(new Object[]{new Integer(34), new Float(3.45),new Double(11.11)});
		//printArray(new Object[]{"dd","ddd"});
		//printArray(new Object[]{new A(),new A(),new A()});
//		printArray((new Integer[]{1,2,3,4,5});
	}

}
