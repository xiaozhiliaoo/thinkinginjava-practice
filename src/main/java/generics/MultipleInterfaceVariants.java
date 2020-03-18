package generics;//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

interface Payable<T> {
}

class Employee2 implements Payable<Employee2> {}
class Hourly1 implements Payable<Hourly1> {}

//class Hourly2 extends Employee2 implements Payable<Hourly2> {}


///:~
