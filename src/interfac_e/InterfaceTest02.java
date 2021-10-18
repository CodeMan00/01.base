package interfac_e;

/**
 * java 8中，接口中允许定义默认方法
 * <p>
 * 如果多个类对接口进行了实现，档我们对接口进行扩展的时候，比如添加抽象类
 * 那么实现这个接口的所有类就要对新添加的抽象方法进行实现，为了避免这种情况，
 * 我们通过设置默认方法解决这种问题，在接口中定义默认方法，对其实现的子类无需对
 * 默认方法重写。
 * <p>
 * <p>
 * 默认方法的规则：
 * 1.默认方法使用default关键字，一个接口可以有多个默认方法
 * 2.默认方法不是抽象方法
 * 3.子类实现接口时，可以直接调用接口中的默认方法
 * 4.默认方法可以被实现类重写覆盖
 * <p>
 * <p>
 * 接口中同时还可以定义静态方法，静态方法通过接口名调用
 */

public interface InterfaceTest02 {

    void test();

    public default void learn() {
        System.out.println("我正在学习java");
    }
}

class Test1 implements InterfaceTest02 {

    @Override
    public void test() {
        System.out.println("实现类中的方法执行了");
    }

    public void learn() {
        System.out.println("实现类中的learn方法执行了");
    }
}


class Main {

    public static void main(String[] args) {

        Test1 test1 = new Test1();
        test1.learn();
    }
}
