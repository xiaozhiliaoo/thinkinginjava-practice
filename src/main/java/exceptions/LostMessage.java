package exceptions;//: exceptions/LostMessage.java
// How an exception can be lost.

//重要异常
class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

//不重要异常
class HoHumException extends Exception {
    public String toString() {
        //不重要的
        return "A trivial exception";
    }
}


public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();//抛出重要异常。但是没有捕获
            } finally {
                lm.dispose();//发生了不重要异常
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} /* Output:
A trivial exception
*///:~
