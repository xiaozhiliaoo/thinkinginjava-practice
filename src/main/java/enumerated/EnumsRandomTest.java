package enumerated;

/**
 * Created by lili on 2017/8/5
 */

enum ActivityTest{
    AAA,BBB,CCC,DDD,EEE,FFF,GGG
}

public class EnumsRandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(ActivityTest.class));
        }
    }
}
