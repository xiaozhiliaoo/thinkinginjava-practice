//: enumerated/Competitor.java
// Switching one enum on another.
package enumerated;

//我怎么可能写出这种代码.....
public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
