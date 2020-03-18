//: initialization/MethodInit2.java
package initialization;

//P93
public class MethodInit2 {
    int i = f();
    int j = g(i);

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
} ///:~
