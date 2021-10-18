package staic;

/**
 * final的使用要求：
 * 1.可以用来修饰一个类
 * 修饰的类不能被继承，没有子类
 * <p>
 * 2.可以用来修饰一个方法
 * 修饰的方法不能被子类覆盖重写
 * <p>
 * 3.可以用来修饰一个局部变量
 * 修饰的变量不能进行更改，相当于常量
 * <p>
 * 对于引用型：变量中保存的地址不可变，但是变量中的内容可以改变。
 * 如果Student类，变量指向的学生这个人不会变，但是学生对象中的内容（名字，年龄）可以变
 * 对于基本数据类型：变量中保存的值不可变
 * <p>
 * 4.可以用来修饰一个成员变量
 * 1）由于成员变量具有默认值，所以用了final关键字之后，必须手动赋值，
 * 不会再给默认值，
 * 2) 对于final的成员变量，要么使用直接赋值，要么通过构造方法赋值，只能用其一。
 * 用了直接赋值，就不能再构造方法赋值
 * <p>
 * 3) 如果使用构造方法进行赋值，必须保证类当中所有重载的构造方法，都最终对会final的成员变量进行赋值
 * <p>
 * 5.final修饰类和方法时，不能和abstract一起使用，因为矛盾
 * 被abstract修饰的类能被继承 方法能被重写， 而final限定它们不能继承或修改
 * <p>
 * <p>
 * <p>
 * 四种权限修饰符：
 * public      protected      (default)      private
 * <p>
 * 同一个类下          yes          yes             yes         yes
 * <p>
 * 同一个包下          yes          yes            yes          no
 * <p>
 * 不同包子类          yes          yes            no            no
 * <p>
 * 不同包非子类         yes          no             no           no
 */
public class FinalTest {

    public static void main(String[] args) {

        A a = new A();
        a.test();
        ;
    }
}


final class A extends B {

    public void test() {

        final int a;
        a = 3;

        System.out.println("被final修饰的类不能被继承");
    }
}

class B extends C {

    public final void learn() {
        System.out.println("final 修饰的方法不能被重写");
    }

}

abstract class C {

    public final void eat() {
        System.out.println("final 修饰的方法不能被重写");
    }
}
