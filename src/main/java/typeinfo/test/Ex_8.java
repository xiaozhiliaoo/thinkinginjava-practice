package typeinfo.test;

public class Ex_8 {
	
	public static void printClasses(Class<?> c){
		if(c == null) return;
		System.out.println(c.getName());
		for(Class<?> cls: c.getInterfaces()){
			System.out.println("Interface: "+ cls.getName());
			printClasses(cls.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			printClasses(Class.forName("java.lang.String"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
