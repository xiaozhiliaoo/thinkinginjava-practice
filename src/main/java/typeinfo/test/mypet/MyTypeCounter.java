package typeinfo.test.mypet;

import java.util.HashMap;
import java.util.Map;

public class MyTypeCounter extends HashMap<Class<?>,Integer>{
	
	private Class<?> baseType;
	public MyTypeCounter(Class<?> baseType){
		this.baseType = baseType;
	}
	public void count(Object obj){
		Class<?> type = obj.getClass();
		if(!baseType.isAssignableFrom(type)){
			throw new RuntimeException(obj + " incorrect type: "+ type + ", should be type or subtype of "+ baseType);
		}
		countClass(type);
	}
	
	private void countClass(Class<?> type){
		Integer quantity = get(type);
		put(type, quantity == null?1:quantity+1);
		Class<?> superClass = type.getSuperclass();
		if(superClass != null && baseType.isAssignableFrom(superClass)){
			countClass(superClass);
		}
	}
	public String toString() {
	    StringBuilder result = new StringBuilder("{");
	    for(Entry<Class<?>,Integer> pair : entrySet()) {
	      result.append(pair.getKey().getSimpleName());
	      result.append("=");
	      result.append(pair.getValue());
	      result.append(", ");
	    }
	    result.delete(result.length()-2, result.length());
	    result.append("}");
	    return result.toString();
	  }
	/**
	 *HappyBoyLi
	 *2017-1-26 ����2:49:08
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTypeCounter my = new MyTypeCounter(Integer.class);
		my.count(Integer.class);
		System.out.println(my);
	}

}
