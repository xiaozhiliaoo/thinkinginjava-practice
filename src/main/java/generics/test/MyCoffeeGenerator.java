package generics.test;

import generics.coffee.Americano;
import generics.coffee.Breve;
import generics.coffee.Cappuccino;
import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import generics.coffee.Latte;
import generics.coffee.Mocha;
import java.util.Iterator;
import java.util.Random;


public class MyCoffeeGenerator implements MyGenerator<Coffee>,Iterable<Coffee>{
	
	private Class[] types = { Latte.class, Mocha.class,Cappuccino.class, Americano.class, Breve.class, };
	private static Random rd = new Random(47);
	private int size = 0;
	public MyCoffeeGenerator(){};
	public MyCoffeeGenerator(int size){
		this.size = size;
	}
	private class CoffeeIterator implements Iterator<Coffee>{

		int count = size;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count > 0;
		}

		@Override
		public Coffee next() {
			// TODO Auto-generated method stub
			count--;
			return MyCoffeeGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public Iterator<Coffee> iterator() {
		// TODO Auto-generated method stub
		return new CoffeeIterator();
	}

	@Override
	public Coffee next() {
		// TODO Auto-generated method stub
		try {
			return (Coffee)types[rd.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}
	

	/**
	 *HappyBoyLi
	 *2017-1-26 ÏÂÎç7:27:15
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeeGenerator cg = new CoffeeGenerator();
		
	}

}
