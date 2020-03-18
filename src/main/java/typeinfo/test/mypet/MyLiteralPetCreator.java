package typeinfo.test.mypet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MyLiteralPetCreator extends MyPetCreator{
	@SuppressWarnings("unchecked")
	public static final List<Class<? extends MyPet>> allTypes= 
		Collections.unmodifiableList(Arrays.asList(
				MyPet.class, MyDog.class, MyCat.class,  MyRodent.class,
			      MyMutt.class, MyPug.class, MyEgyptianMau.class, MyManx.class,
			      MyCymric.class, MyRat.class, MyMouse.class,MyHamster.class
		));
	
	private static final List<Class<? extends MyPet>> types = 
			allTypes.subList(allTypes.indexOf(MyMutt.class), allTypes.size());
	
	@Override
	public List<Class<? extends MyPet>> types() {
		// TODO Auto-generated method stub
		return types;
	}
}
