package generics.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyRandomList<T> {
	private Random rd = new Random(47);
	private List<T> list = new ArrayList<T>();
	public void addItem(T t){
		list.add(t);
	}
	public T select(){
		return list.get(rd.nextInt(list.size()));
	}
	public String toString(){
		return list.toString();
	}

	/**
	 *HappyBoyLi
	 *2017-1-26 ÏÂÎç7:07:52
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRandomList<String> l = new MyRandomList<String>();
		String s = "i love lili and code";
		for(String ss:s.split(" ")){
			l.addItem(ss);
		}
		System.out.println(l);
		for(int i=0;i<100;i++){
			System.out.print(l.select()+"-");
		}
	}

}
