package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.EgyptianMau;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

class Pets{
	public static final PetCreator creator = new LiteralPetCreator();
	public static Pet randomPet(){
		return creator.randomPet();
	}
	public static Pet[] createArray(int size){
		return creator.createArray(size);
	}
	public static ArrayList<Pet> arrayList(int size){
		return creator.arrayList(size);
	}
	
}

abstract class PetCreator{
	private Random rand = new Random(47);
	
	public abstract List<Class<? extends Pet>> types();
	
	public Pet randomPet(){
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public Pet[] createArray(int size){
		Pet[] result = new Pet[size];
		for(int i=0; i<size;i++){
			result[i] = randomPet();
		}
		return result;
	}
	
	public ArrayList<Pet> arrayList(int size){
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}

class LiteralPetCreator extends PetCreator{

	 @SuppressWarnings("unchecked")
	public static final List<Class<? extends Pet>> allTypes =
			    Collections.unmodifiableList(Arrays.asList(
			      Pet.class, Dog.class, Cat.class,  Rodent.class,
			      Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
			      Cymric.class, Rat.class, Mouse.class,Hamster.class));	
	 
	public static final List<Class<? extends Pet>> types = 
			allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}	
}



public class MyPet {

	
	public static void main(String args[]){
		List<Pet> pets = Pets.arrayList(61);
		System.out.println(pets);
	}
}
