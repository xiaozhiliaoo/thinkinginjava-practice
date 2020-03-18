package typeinfo.test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

interface Iface{
	int i = 47;
	void f();
}

class Base implements Iface{

	String s;
	double b;
	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("Base.f");
	}
}

class Composed{
	Base b;
}

class Drived extends Composed{
	Composed c;
	String s;
}
public class Ex_9 {

	/**
	 *HappyBoyLi
	 *2017-1-25 ÏÂÎç6:59:17
	 * @param args
	 */
	public static Set<Class<?>> alreadyDisplayed = new HashSet<Class<?>>();
	public static void printClasses(Class<?> c){
		if(c == null)return;
		System.out.println(c.getName());
		Field []fields = c.getDeclaredFields();
		if(fields.length != 0) {
			System.out.println("fileds: ");
		}
		
		for(Field f : fields){
			System.out.println(f);
		}
		
		for(Field f: fields){
			// Í¨Åä·û·ºÐÍ
			Class<?> k = f.getType();
			if(!alreadyDisplayed.contains(k)){
				printClasses(k);
				alreadyDisplayed.add(k);
			}
		}
		for(Class<?> k :c.getInterfaces()){
			System.out.println("Interface: ");
			System.out.println(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < args.length; i++) {
			System.out.println("Displaying " + args[i]);
			try {
				printClasses(Class.forName(args[i]));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i < args.length - 1)
			System.out.println("==================");
			}
		}
		
	}
