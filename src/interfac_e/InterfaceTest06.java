package interfac_e;

/**
 * 接口中不能有静态代码块  和 构造方法
 * <p>
 * 一个类可以同时实现多个接口，如果实现多个接口，其中有重复的抽象方法，只需要实现一次即可
 * <p>
 * 如果一个类的直接父类当中的方法，和接口中的默认方法产生了冲突，优先用父类中的方法
 * <p>
 * 如果实现类所实现的多个接口中，存在重复的默认方法，那么实现类一定要对冲突的
 * 默认方法进行覆盖重写
 */
public class InterfaceTest06 {
}

interface Persons {

    void eat();
}

interface Animalss {

    void sleep();
}

class Student implements Persons, Animalss {

    @Override
    public void eat() {
        System.out.println("实现类中的eat方法");
    }

    @Override
    public void sleep() {
        System.out.println("实现类中的sleep方法");
    }
}