//: arrays/IceCream.java


// Returning arrays from methods.
package arrays;

import java.util.*;

public class IceCream {

    private static Random rand = new Random(47);

    static final String[] FLAVORS = {
            "Chocolate",   //巧克力
            "Strawberry",  //草莓
            "Vanilla Fudge Swirl", //香草软糖旋涡
            "Mint Chip",  // 薄荷
            "Mocha Almond Fudge",  // 摩卡杏仁
            "Rum Raisin",  // 拉普葡萄
            "Praline Cream", // 果仁奶油
            "Mud Pie"  // 冰淇淋派
    };

    /**
     *
     * @param n  随机选择冰淇淋口味
     * @return
     */
    public static String[] flavorSet(int n) {

        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }

        String[] results = new String[n];
        //默认false 没有用过  true 已经用过的
        boolean[] picked = new boolean[FLAVORS.length];

        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            }
            //找没有用过的
            while (picked[t]);

            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
} /* Output:
[Rum Raisin, Mint Chip, Mocha Almond Fudge]
[Chocolate, Strawberry, Mocha Almond Fudge]
[Strawberry, Mint Chip, Mocha Almond Fudge]
[Rum Raisin, Vanilla Fudge Swirl, Mud Pie]
[Vanilla Fudge Swirl, Chocolate, Mocha Almond Fudge]
[Praline Cream, Strawberry, Mocha Almond Fudge]
[Mocha Almond Fudge, Strawberry, Mint Chip]
*///:~
