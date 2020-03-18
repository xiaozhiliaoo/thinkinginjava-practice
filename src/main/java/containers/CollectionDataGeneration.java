//: containers/CollectionDataGeneration.java
// Using the Generators defined in the Arrays chapter.
package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {
    public static void main(String[] args) {
        // Convenience method
        System.out.println(
                //默认7位
                new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9), 10))
        );
        // No Convenience method
        System.out.println(
                new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(), 10))
        );
    }
} /* Output:
[YNzbrnyGc, FOWZnTcQr, GseGZMmJM, RoEsuEcUO, neOEdLsmw, HLGEahKcx, rEqUCBbkI, naMesbtWH, kjUrUkZPg, wsqPzDyCy]
[573, 4779, 871, 4367, 6090, 7882, 2017, 8037, 3455, 299]
*///:~
