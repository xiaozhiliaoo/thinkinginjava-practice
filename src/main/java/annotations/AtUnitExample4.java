//: annotations/AtUnitExample4.java
package annotations;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCreate;
import net.mindview.atunit.TestProperty;
import net.mindview.util.OSExecute;

import java.util.*;

import static net.mindview.util.Print.print;

public class AtUnitExample4 {

    static String theory = "All brontosauruses " +
            "are thin at one end, much MUCH thicker in the " +
            "middle, and then thin again at the far end.";

    private String word;
    private Random rand = new Random(); // Time-based seed

    public AtUnitExample4(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String scrambleWord() {
        List<Character> chars = new ArrayList<Character>();
        for (Character c : word.toCharArray()) {
            chars.add(c);
        }
        //打乱顺序
        Collections.shuffle(chars, rand);
        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            result.append(ch);
        }
        return result.toString();
    }

    /**
     * 测试属性
     */
    @TestProperty
    static List<String> input = Arrays.asList(theory.split(" "));
    @TestProperty
    static Iterator<String> words = input.iterator();

    @TestObjectCreate
    static AtUnitExample4 create() {
        if (words.hasNext()) {
            return new AtUnitExample4(words.next());
        } else {
            return null;
        }
    }

    @Test
    boolean words() {
        print("'" + getWord() + "'");
        //每次都是失败的
        return getWord().equals("are");
    }

    @Test
    boolean scramble1() {
        // Change to a specific seed to get verifiable results:
        rand = new Random(47);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        //每次都是失败的
        return scrambled.equals("lAl");
    }

    @Test
    boolean scramble2() {
        rand = new Random(74);
        print("'" + getWord() + "'");
        String scrambled = scrambleWord();
        print(scrambled);
        //每次都是失败的
        return scrambled.equals("tsaeborornussu");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("starting");
        OSExecute.command("cd .. && cd thinkinjava\\target\\classes  && java net.mindview.atunit.AtUnit annotations\\AtUnitExample4");
    }
} /* Output:
starting
annotations.AtUnitExample4
  . scramble1 'All'
lAl

  . scramble2 'brontosauruses'
tsaeborornussu

  . words 'are'

OK (3 tests)
*///:~