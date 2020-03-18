//: annotations/UseCase.java
package annotations;

import java.lang.annotation.*;

//多目标的写法
//@Target(value = {ElementType.FIELD,ElementType.METHOD})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    public int id();

    public String description() default "no description";

} ///:~
