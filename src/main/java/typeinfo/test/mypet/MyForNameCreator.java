package typeinfo.test.mypet;

import java.util.ArrayList;
import java.util.List;

public class MyForNameCreator extends MyPetCreator{
	
	private static List<Class<? extends MyPet>> types = new ArrayList<Class<? extends MyPet>>();
	private static String[] typeNames = {
		"typeinfo.test.mypet.MyMutt",
	    "typeinfo.test.mypet.MyPug",
	    "typeinfo.test.mypet.MyEgyptianMau",
	    "typeinfo.test.mypet.MyManx",
	    "typeinfo.test.mypet.MyCymric",
	    "typeinfo.test.mypet.MyRat",
	    "typeinfo.test.mypet.MyMouse",
	    "typeinfo.test.mypet.MyHamster"
	};
	private static void loader(){
		for(String name: typeNames){
			try {
				types.add((Class<? extends MyPet>) Class.forName(name));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
	}
	
	static {
		loader();
	}
	
	@Override
	public List<Class<? extends MyPet>> types() {
		// TODO Auto-generated method stub
		return types;
	}

}
