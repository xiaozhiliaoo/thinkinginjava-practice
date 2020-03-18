//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package typeinfo.pets;

import java.util.*;

public abstract class PetCreator {

    private Random rand = new Random(47);

    //抽象方法
    // The List of the different types of Pet to create:
    public abstract List<Class<? extends Pet>> types();

    //随机创建宠物
    public Pet randomPet() { // Create one random Pet
        int n = rand.nextInt(types().size());
        try {
            //随机返回一个宠物
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //创建宠物数组
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    //返回宠物list
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }

    //数组和list之间相互转换  要么在list中，要么在collections中，要么在Arrays中
    public ArrayList<Pet> arrayList2(int size) {
        return (ArrayList<Pet>) Arrays.asList(createArray(size));
    }
} ///:~
