package typeinfo.test.mypet;

import static net.mindview.util.Print.*;

import java.util.LinkedHashMap;
import java.util.Map;

import net.mindview.util.MapData;
public class MyPetCount3 {
	
	static class MyPetCounter extends LinkedHashMap<Class<? extends MyPet>, Integer>{
		public MyPetCounter(){
			super(MapData.map(MyLiteralPetCreator.allTypes, 0));
		}
		public void count(MyPet pet){
			for(Map.Entry<Class<? extends MyPet>,Integer> pair:entrySet()){
				if(pair.getKey().isInstance(pet)){
					put(pair.getKey(), pair.getValue()+1);
				}
			}
		}
		public String toString(){
			StringBuilder result = new StringBuilder("{");
			for(Map.Entry<Class<? extends MyPet>, Integer> pair: entrySet()){
				result.append(pair.getKey().getSimpleName());
				result.append(" = ");
				result.append(pair.getValue());
				result.append(", ");
			}
			result.delete(result.length()-2, result.length());
			result.append("}");
			return result.toString();
		}
	}
	
	
	/**
	 *HappyBoyLi
	 *2017-1-26 ÏÂÎç2:05:49
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ¾²Ì¬
		MyPetCounter petCount = new MyPetCounter();
		for(MyPet pet: MyPets.createArray(20)){
			printnb(pet.getClass().getSimpleName());
			petCount.count(pet);
		}
		print();
		print(petCount);
	}

}
