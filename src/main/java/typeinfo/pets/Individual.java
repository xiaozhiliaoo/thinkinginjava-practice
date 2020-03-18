//: typeinfo/pets/Individual.java
package typeinfo.pets;

//可排序的  重写equals，重写hashcode，实现可比较接口
public class Individual implements Comparable<Individual> {
    // 计数器静态
    private static long counter = 0;
    // 每创建一个对象，就生成一个计数，并且不可改变
    private final long id = counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    // 'name' is optional:
    public Individual() {
    }

    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    public boolean equals(Object o) {
        //未使用名字做比较
        return o instanceof Individual && id == ((Individual) o).id;
    }

    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int) id;  //核心id
        return result;
    }

    public int compareTo(Individual arg) {
        //比较较为复杂
        // Compare by class name first:
        String first = this.getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        // 第一次比较结果
        int firstCompare = first.compareTo(argFirst);
        //类名不同，没必要比较了
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && arg.name != null) {
            //第二个比较结果
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0)
                return secondCompare;
        }
        //第三次直接比较id
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
} ///:~
