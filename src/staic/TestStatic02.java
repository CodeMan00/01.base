package staic;

/**
 * static 方法:
 * <p>
 * 被static修饰的方法为静态方法，不依赖于对象就能进行访问，通过类名
 * 因此静态方法是没有this的，既然不需要对象就能进行访问，就谈不上this了
 * 在静态方法中不能访问类的非静态成员变量和非静态成员方法(因为静态方法
 * 在类被加载的时候就会进行初始化)，但是非静态成员方法中是可以访问静态
 * 成员方法或静态变量的。
 * <p>
 * <p>
 * <p>
 * 静态代码块：
 * 作用：用来优化程序性能
 * <p>
 * 可以放在类中的任意位置，可以有多个。
 * 在类加载时执行，且只执行一次。
 */
public class TestStatic02 {

    static String name = "zhangsan";
    static int age = 100;


    static {
        System.out.println("静态代码块执行了");
    }

    public static void main(String[] args) {
        test();
    }

    //静态方法中可以访问静态成员
    public static void test() {
        System.out.println(age);

        Test test = new Test();
        test.name = "zhangsan";
        System.out.println(test.name);
    }
}

class Test {

    String name;
}
