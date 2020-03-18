package typeinfo.test.mypet;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.HashMap;

public class MyPetCount {

	static class MyPetCounter extends HashMap<String, Integer>{
		public void count(String type){
			Integer quantity = get(type);
			if(quantity == null){
				put(type, 1);
			}else{
				put(type, quantity +1);
			}
		}
	}
	
	public static void countPets(MyPetCreator creator){
		MyPetCounter counter = new MyPetCounter();
		for(MyPet pet : creator.createArray(20)){
			printnb(pet.getClass().getSimpleName() + " ");
		      if(pet instanceof MyPet)
		        counter.count("MyPet");
		      if(pet instanceof MyDog)
		        counter.count("MyDog");
		      if(pet instanceof MyMutt)
		        counter.count("Mutt");
		      if(pet instanceof MyPug)
		        counter.count("MyPug");
		      if(pet instanceof MyCat)
		        counter.count("MyCat");
		      if(pet instanceof MyManx)
		        counter.count("MyEgyptianMau");
		      if(pet instanceof MyManx)
		        counter.count("MyManx");
		      if(pet instanceof MyManx)
		        counter.count("MyCymric");
		      if(pet instanceof MyRodent)
		        counter.count("Rodent");
		      if(pet instanceof MyRat)
		        counter.count("MyRat");
		      if(pet instanceof MyMouse)
		        counter.count("MyMouse");
		      if(pet instanceof MyHamster)
		        counter.count("MyHamster");
		    }
		    // Show the counts:
		    print();
		    print(counter);
		  }	
	/**
	 *HappyBoyLi
	 *2017-1-26 ÏÂÎç12:50:35
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPets(new MyForNameCreator());
	}

}
