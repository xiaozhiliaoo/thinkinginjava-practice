package generics.test;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Structs(�ṹ��)
�ڱ���г���Ա����Ĳ������ǽ������ݴ��ݣ���ͳ�ķ�ʽ��JavaBean��������ʾ��

public class DataHolder {
	private String data;
	public DataHolder() {
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return this.data;
	}
}

�������ַ�ʽ���߳������˷���Դ�ģ�������ı༭���ܹ��Զ��������ִ��롣��Ϊ���������
������ѡ��ʹ��C�����Ľṹ����ʽȥ��д�����������ݣ�

public class DataHolder {
    public final String data;
    public DataHolder(String data) {
        this.data = data;
    }
}
���ַ�ʽ��������ʹ�ô�����������룬����֮�⣬�������ǲ��ɱ���࣬������ĳЩ���������
���Է��ĵ�ʹ�������������ϣ���ܹ���Map����List��Щ�ṹ��ȥ�洢�����ʹ���޸ı�ü�һ�㣬
����ʹ��ImmutableMap����ImmutableList���ⲿ�ֻ����������ۡ�
 */

class DTO2<A,B>{
	public final A a;
	public final B b;
	public DTO2(A a, B b){
		this.a = a;
		this.b = b;
	}
	public String toString(){
		return (a+"---"+b);
	}
}

class DTO3<A,B,C> extends DTO2<A,B>{
	public final C c;
	public DTO3(A a, B b, C c){
		super(a, b);
		this.c = c;
	}
	public String toString(){
		return (a+"---"+b+"----"+c);
	}
}

class DTO4<A,B,C,D> extends DTO3<A,B,C>{
	public final D d;
	public DTO4(A a, B b, C c, D d){
		super(a, b, c);
		this.d = d;
	}
	public String toString(){
		return (a+"---"+b+"----"+c+"-----"+d);
	}
}

class Person{
	private String name;
	public Person(String name){
		this.name = name;
	}
	public String toString(){
		return (this.name);
	}
}

class School{
	private String schoolName;
	public School(String schoolName){
		this.schoolName = schoolName;
	}
	public String toString(){
		return (this.schoolName);
	}
}

class Home{
	private String homeAddr;
	public Home(String homeAddr){
		this.homeAddr = homeAddr;
	}
	public String toString(){
		return (this.homeAddr);
	}
}

class Friend{
	private List<String> list = new ArrayList<String>();
	public Friend(){
		list.add("zyc");
		list.add("lili");
		list.add("njl");
		list.add("wzw");
	}
	public String toString(){
		return (this.list.toString());
	}
	
}

public class DTOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DTO4<Person, School, Home, Friend> dto4 = 
		new DTO4<Person, School, Home, Friend>(new Person("lili"), new School("XAUTSchool"), new Home("URumqi"), new Friend());
		System.out.println(dto4);
		
	}

}
