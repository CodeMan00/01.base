package interfac_e;

/**
 * 接口：  就是多个类的公共规范； 是一种引用数据类型，最重要的内容就是其中的抽象方法
 * <p>
 * class关键字换成了interface，编译生成的字节码文件仍是 .java---> .class
 * <p>
 * <p>
 * 抽象方法：
 * 接口中的抽象方法，修饰符必须有两个固定的关键字 public abstract ，其实也可以
 * 省去，
 * <p>
 * <p>
 * 接口的使用：
 * 1. 接口不能直接使用，必须有一个 “实现类 “ 来实现该接口
 * 2.接口的实现类必须覆盖重写接口中的所有抽象方法
 * 3.如果一个类没有全部实现接口的所有抽象方法，那么这个类就必须是抽象类
 */
public class InterfaceTest implements Test {
    @Override
    public void test() {
        System.out.println("test1");
    }

    @Override
    public void test03() {
        System.out.println("test2");
    }

    @Override
    public void test01() {
        System.out.println("test3");
    }

    @Override
    public void test02() {
        System.out.println("test4");
    }
}

interface Test {

    //四种抽象方法的写法
    public abstract void test();

    public void test03();

    abstract void test01();

    void test02();


}
