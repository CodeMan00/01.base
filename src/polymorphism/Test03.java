package polymorphism;

/**
 * 向下转型：
 * 将父类对象转换为子类对象
 * <p>
 * 向上转型：
 * 将子类对象转换为父类对象
 * 该操作实际上就是多态
 * 弊端：对于子类的一些特有的方式，我们无法使用
 * <p>
 * 注意：
 * 由于一个父类可能有多个子类，在向下转型的过程中，我们要注意当前父类的
 * 子类的类型，在向下转换时，只能转换为父类对应的子类的类型
 * 例如： Animal a = new Dog();  向下转换时，我们不能把 a转换为非Dog类型。
 * <p>
 * 怎么判断父类的引用是哪个子类的对象？
 * 可以通过instanceof判断   如果是，返回true  如果不是，返回false
 */
public class Test03 {

    public static void main(String[] args) {

        //多态  也叫向上转型
        M m = new N();
        //因为子类重写了该方法，所以执行子类中的方法
        m.m();

        if (m instanceof N) {
            System.out.println("m的子类是N");
        }

        //向下转型
        N n = (N) m;
        //转型后，可以执行自己特有的方法
        n.n();


    }
}


class M {

    void m() {
        System.out.println("fu");
    }
}

class N extends M {

    void m() {
        System.out.println("zi");
    }

    void n() {
        System.out.println("子类特有的方法");
    }
}