package polymorphism;

/**
 * 方法的重写
 * <p>
 * 父类和子类之间的多态性，对父类的函数进行重新定义。子类继承父类的方法，
 * 只能对方法内的代码进行重写，方法名和参数列表和返回值类型都是不能进行
 * 修改的。
 * <p>
 * <p>
 * 多态格式：
 * 父类名  变量名  =  new 子类名();
 * 父接口名  变量名  = new 实现类名();
 */
public class OverridingTest {

    public static void main(String[] args) {

        //左边是父类的引用  右边是子类的对象
        A aa = new B();
        //优先调用子类中的方法，如果子类没有，则调用父类中的方法
        aa.a();
    }

}

class A {

    void a() {
        System.out.println("fu");
    }
}

class B extends A {

    void a() {
        System.out.println("zi");
    }
}
