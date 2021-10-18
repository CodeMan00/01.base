package abstrac_t;

/**
 * 1.抽象类中可以有构造方法，是供子类创建对象时，初始化父类成员使用的，
 * 子类的构造方法中，有默认的super方法，
 * <p>
 * 2.抽象类中不一定包含抽象方法，但有抽象方法的类一定是抽象类
 * 未包含抽象方法的抽象类，目的是不想让调用者创建该类对象，通常用于某些特殊的类
 * 结构设计
 * <p>
 * 3.抽象类的子类，必须重写父类中的所有抽象方法，
 */
public class AbstractTest02 {

    public static void main(String[] args) {

        Chinese chinese = new Chinese();
        chinese.eat();
    }
}

abstract class Person {

    Person() {
        System.out.println("Person抽象类方法执行了");
    }

    abstract void eat();
}

class Chinese extends Person {

    Chinese() {
        System.out.println("Chinese构造方法执行了");
    }

    @Override
    void eat() {
        System.out.println("eat方法被实现了");
    }
}