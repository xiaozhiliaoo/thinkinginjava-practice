//: annotations/UseCaseTracker.java
package annotations;

import java.lang.reflect.*;
import java.util.*;


public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {

        for (Method m : cl.getDeclaredMethods()) {
            //指定类型注解  因为一个方法上可能有很多种注解 所以注解保留策略必须到运行时
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                //找到的用例删除
                useCases.remove(new Integer(uc.id()));
            }
        }

        //没有找到的用例 比如50
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }

    }

    public static void main(String[] args) {

        List<Integer> useCases = new ArrayList<Integer>();

        Collections.addAll(useCases, 47, 48, 49, 50);

        trackUseCases(useCases, PasswordUtils.class);
    }
} /* Output:
Found Use Case:47 Passwords must contain at least one numeric
Found Use Case:48 no description
Found Use Case:49 New passwords can't equal previously used ones
Warning: Missing use case-50
*///:~
