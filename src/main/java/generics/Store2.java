package generics;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

/**
 * @packgeName: generics
 * @ClassName: Store2
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/8/21-20:49
 * @version: 1.0
 * @since: JDK 1.8
 */
class Product2{
    private final int id;
    private String description;
    private double price;

    public Product2(int id, String description, double price) {
        this.id = id;
        this.description = description;
        System.out.println(toString());
        this.price = price;
    }

    @Override
    public String toString() {
        return id+","+description+","+price;
    }

    public static Generator<Product2> generator = new Generator<Product2>() {

        private Random random = new Random(47);

        public Product2 next() {

            return new Product2(random.nextInt(1000),
                    "Test",Math.round(random.nextDouble()));
        }
    };
}


class Shelf2 extends ArrayList<Product2>{
    public Shelf2(int nProducts){
        Generators.fill(this,Product2.generator,nProducts);
    }
}



public class Store2 {
}
