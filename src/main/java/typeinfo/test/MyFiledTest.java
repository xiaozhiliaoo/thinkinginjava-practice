package typeinfo.test;

import java.util.ArrayList;
import java.util.List;

class CountInteger{
	private static long count;
	private final long id = count++;
	public String toString(){
		return Long.toString(id);
	}
}

class FiledList<T>{
	private Class<T> cls;
	public FiledList(Class<T> cls){
		this.cls = cls;
	}
	public List<T> create(int elenemtNums){
		List<T> result = new ArrayList<T>();
		for(int i=0; i<elenemtNums;i++){
			try {
				result.add(cls.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}


public class MyFiledTest {

	/**
	 *HappyBoyLi
	 *2017-1-25 ÏÂÎç7:59:12
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiledList<CountInteger> fl = new FiledList<CountInteger>(CountInteger.class);
		System.out.println(fl.create(15));
	}

}
