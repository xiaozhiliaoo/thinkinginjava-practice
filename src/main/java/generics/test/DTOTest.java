package generics.test;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Structs(结构体)
在编程中程序员最常见的操作就是进行数据传递，传统的方式是JavaBean，如下所示：

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

不过这种方式是冗长并且浪费资源的，即便你的编辑器能够自动生成这种代码。作为替代方法，
我宁可选择使用C风格里的结构体样式去编写这种容器数据：

public class DataHolder {
    public final String data;
    public DataHolder(String data) {
        this.data = data;
    }
}
这种方式几乎可以使得代码的行数减半，除此之外，这种类是不可变的类，所以在某些情况下我们
可以放心的使用它。如果你是希望能够用Map或者List这些结构体去存储对象而使得修改变得简单一点，
可以使用ImmutableMap或者ImmutableList，这部分会在下面讨论。
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
