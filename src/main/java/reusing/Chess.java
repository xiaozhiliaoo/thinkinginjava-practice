//: reusing/Chess.java
// Inheritance, constructors and arguments.
package reusing;
//130
import static net.mindview.util.Print.*;

class Game {
  Game(int i) {
    print("Game constructor"+i);
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    print("BoardGame constructor"+i);
  }
}	

public class Chess extends BoardGame {
  Chess() {
    super(11);
    print("Chess constructor");
  }
  
  public static void main(String[] args) {
    Chess x = new Chess();
  }
  
} /* Output:
Game constructor 11
BoardGame constructor 11
Chess constructor
*///:~
