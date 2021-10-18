package polymorphism;

/**
 * 访问成员变量的两种方式：
 * 1.直接通过对象名称访问成员变量： 看等号左边是谁，优先用谁，没有则向上找
 * 2.间接通过成员方法访问成员变量：看该方法属于谁，优先用谁，没有则向上找
 * 3.如果子类覆盖了父类的方法，那么调用的覆盖过的方法执行的就是子类中的方法
 * 4.如果调用父类中的没被子类重写的方法，执行的是父类中的方法
 */
public class Test01 {

    public static void main(String[] args) {

        D d = new E();
        System.out.println(d.name);

        d.show();
    }
}


class D {

    String name = "fu";

    void show() {
        System.out.println("fu");
    }
}

class E extends D {
    String name = "zi";

    void show() {
        System.out.println("zi");
    }
}


