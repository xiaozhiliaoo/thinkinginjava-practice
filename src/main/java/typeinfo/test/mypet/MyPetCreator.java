package typeinfo.test.mypet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public abstract class MyPetCreator {
	private Random rand = new Random(47);
	public abstract List<Class<? extends MyPet>> types();
	
	// 不加思考直接使用编译器带出来的代码有错    没有返回值.  区别在于异常处理那块
	//This method must return a result of type MyPet
	/*public MyPet randomPet1() {
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}*/
	// 书上源码正确的
	public MyPet randomPet() { 
	    int n = rand.nextInt(types().size());
	    try {
	      return types().get(n).newInstance();
	    } catch(InstantiationException e) {
	      throw new RuntimeException(e);
	    } catch(IllegalAccessException e) {
	      throw new RuntimeException(e);
	    }
	  }
	
	public MyPet[] createArray(int size){
		MyPet[] result = new MyPet[size];
		for(int i=0; i<size; i++){
			result[i] = randomPet();
		}
		return result;
	}
	
	public ArrayList<MyPet> createArrayList(int size){
		ArrayList<MyPet> result = new ArrayList<MyPet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
	
}
