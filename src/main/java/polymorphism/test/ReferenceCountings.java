package polymorphism.test;

class Shared {
	private int refCount;
	private static long count;
	private final long id = count++;
	public Shared() {
		System.out.println("create "+ this);
	}
	public void addRef() {
		refCount++;
	}
	protected void dispose() {
		if(--refCount == 0){
			System.out.println("dispose "+this);
		}
	}
	public String toString() {
		return "Shared" + id;
	}
}  


class Composing {
	private Shared shared;
	private static long count;
	private final long id = count++;
	public Composing(Shared shared){
		System.out.println("create "+ this);
		this.shared = shared;
		this.shared.addRef();
	}
	protected void dispose(){
		System.out.println("dispose " + this);
		this.shared.dispose();
	}
	public String toString(){
		return "Composing " + id;
	}
	
}

public class ReferenceCountings {

	/**
	 *HappyBoyLi
	 *2017-1-23 ÏÂÎç6:14:18
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shared share = new Shared();
		Composing cps[] = new Composing[]{
			 new Composing(share),
			 new Composing(share),
			 new Composing(share),
			 new Composing(share),
			 new Composing(share)
		};
		for(Composing c: cps){
			c.dispose();
		}
		
	}

}
