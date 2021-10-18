package interfac_e;

/**
 * 接口中可以定义static方法
 * <p>
 * 怎样调用接口中的静态方法？
 * 1.不同通过实现该接口的实现类的对象来调用接口的静态方法
 * 2.通过接口名直接调用接口的静态方法
 */
public class InterfaceTest03 {

    public static void main(String[] args) {

        Animal.test();
    }
}

interface Animal {

    public static void test() {
        System.out.println("这是接口中的静态方法！！！");
    }
}

