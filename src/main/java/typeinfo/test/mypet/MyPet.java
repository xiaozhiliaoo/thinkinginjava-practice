package typeinfo.test.mypet;

public class MyPet extends MyIndividual{
	public MyPet(String name){
		super(name);
	}
	public MyPet(){
		super();
	}
}

class MyDog extends MyPet{
	public MyDog(String name){
		super(name);
	}
	public MyDog(){
		super();
	}
}

class MyMutt extends MyDog{
	public MyMutt(String name){
		super(name);
	}
	public MyMutt(){
		super();
	}
}

class MyPug extends MyDog{
	public MyPug(String name){
		super(name);
	}
	public MyPug(){
		super();
	}
}

class MyCat extends MyPet{
	public MyCat(String name){
		super(name);
	}
	public MyCat(){
		super();
	}
}

class MyEgyptianMau extends MyCat{
	public MyEgyptianMau(String name){
		super(name);
	}
	public MyEgyptianMau(){
		super();
	}
}

class MyManx extends MyCat{
	public MyManx(String name){
		super(name);
	}
	public MyManx(){
		super();
	}
}

class MyCymric extends MyCat{
	public MyCymric(String name){
		super(name);
	}
	public MyCymric(){
		super();
	}
}

class MyRodent extends MyPet{
	public MyRodent(String name){
		super(name);
	}
	public MyRodent(){
		super();
	}
}

class MyRat extends MyRodent{
	public MyRat(String name){
		super(name);
	}
	public MyRat(){
		super();
	}
}

class MyMouse extends MyRodent{
	public MyMouse(String name){
		super(name);
	}
	public MyMouse(){
		super();
	}
}

class MyHamster extends MyRodent{
	public MyHamster(String name){
		super(name);
	}
	public MyHamster(){
		super();
	}
}



