package staic;

public class TestStatic03 {
}


/**
 * 执行过程：
 * <p>
 * main方法是程序的入口，在main方法执行之前，先回加载Test类，加载Test类
 * 时，发现Test继承于Base类，因此就会转去先加载Base类，在加载Base类时，
 * 有静态代码块，先执行静态代码块，在Base类加载完成后，便继续加载Test类，
 * 执行Test类中的静态方法，加载完Test类后，就会执行main方法，开始创建Test对象
 * ，先调用父类的构造器，然后在调用自身的构造器。
 */

class Test1 extends Base {
    static {
        System.out.println("test static");
    }

    public Test1() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {

        new Test1();
    }

}

class Base {
    static {
        System.out.println("base static");
    }

    public Base() {

        System.out.println("base constructor");
    }
}
