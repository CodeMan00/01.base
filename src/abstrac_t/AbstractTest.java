package abstrac_t;

/**
 * 抽象方法：
 * 使用abstract关键字 然后去掉大括号，直接分号结束
 * <p>
 * 抽象方法：
 * 抽象方法所在的类，必须是抽象类，在class 之前写上abstract即可
 * <p>
 * <p>
 * 如何使用抽象类和抽象方法：
 * 1.抽象类不能通过new关键字创建对象
 * 2.必须需要一个子类继承父类
 * 3.子类必须覆盖重写父类当中的所有抽象方法
 */
public class AbstractTest {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.eat();
    }
}
