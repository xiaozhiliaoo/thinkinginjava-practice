package initialization;

//: initialization/MethodInit3.java
public class MethodInit3 {
    //! int j = g(i); // Illegal forward reference

    //int j = g(j);//Illegal self reference

    int i = f();

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
} ///:~
