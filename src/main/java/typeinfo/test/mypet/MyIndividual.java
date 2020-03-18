package typeinfo.test.mypet;

public class MyIndividual implements Comparable<MyIndividual>{

	private static long counter = 0;
	private final long id = counter++;
	private String name;
	public MyIndividual(String name){
		this.name = name;
	}
	public MyIndividual(){}
	public String toString(){
		return getClass().getSimpleName() + (name==null?"":" "+name);
	}
	public long id(){
		return id;
	}
	public boolean equals(Object o){
		return o instanceof MyIndividual && id == ((MyIndividual)o).id;
	}
	public int hashCode(){
		int result = 17;
		if(name!=null){
			result = 37*result + name.hashCode();
		}
		result = 37*result + (int)id;
		return result;
	}
	
	@Override
	public int compareTo(MyIndividual o) {
		// TODO Auto-generated method stub
		String first = getClass().getSimpleName();
		String argFirst = o.getClass().getSimpleName();
		int firstCompare = first.compareTo(argFirst);
		if(firstCompare != 0){
			return firstCompare;
		}
		if(name!=null && o.name!=null){
			int secondCompare = name.compareTo(o.name);
			if(secondCompare!=0){
				return secondCompare;
			}
		}
		return (o.id < id ? -1 : (o.id == id ? 0 : 1));
	}

}
