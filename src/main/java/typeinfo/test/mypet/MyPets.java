package typeinfo.test.mypet;

import java.util.ArrayList;


public class MyPets {
	public static final MyPetCreator creator = new MyLiteralPetCreator();
	public static MyPet randomPet(){
		return creator.randomPet();
	}
	public static MyPet[] createArray(int size){
		return creator.createArray(size);
	}
	public static ArrayList<MyPet> arrayList(int size){
		return creator.createArrayList(size);
	}

}
