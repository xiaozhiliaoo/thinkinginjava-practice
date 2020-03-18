//: operators/EqualsMethod2.java
// Default equals() does not compare contents.
package operators;
class Value {
  int i;
  
/*  public boolean equals(Object obj){
	  if(this == obj){
		  return true;
	  }
	  if(!(obj instanceof Value)){
		  return false;
	  }
	  Value v = (Value)obj;
	  if(v.i == this.i){
		  return true;
	  }
	  
	  return false;
  }*/
}

public class EqualsMethod2 {
  public static void main(String[] args) {
    Value v1 = new Value();
    Value v2 = new Value();
    v1.i = v2.i = 100;
    System.out.println(v1.equals(v2));
  }
} /* Output:
false
*///:~
