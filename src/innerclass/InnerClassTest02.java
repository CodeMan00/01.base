package innerclass;

/**
 * 局部内部类：
 * 一个类定义到方法内部，那么这就是一个局部内部类。只有当前所属方法才能使用，除了这个方法就不能使用了。
 * <p>
 * 局部内部类可以访问所在方法中的局部变量，那么这个局部变量必须是【final修饰的】，这个
 * final也可以省去不写，但是必须要保证这个局部成员变量不被重新赋值，一般建议写上。
 * 原因：
 * 1.new出来的对象在堆内存当中
 * 2.局部变量是跟着方法走的，在栈内存当中
 * 3.方法运行结束之后，立刻出栈，局部变量就会立刻消失
 * 4.但是new出来的对象会在堆当中持续存在，直到垃圾回收消失。
 * <p>
 * 根据以上原因，可能内部类需要使用局部变量时，局部变量可能已经不存在了，所以
 * 我们可以拷贝一份，在需要时可以使用，但是防止变量被修改，所以用关键字final修饰
 * <p>
 * <p>
 * 权限修饰符的使用：
 * 外部类： public  和 default   只有两种
 * 成员内部类： 四种都可以
 * 局部内部类： 什么都不写  并不是default，它们又区别
 */
public class InnerClassTest02 {

    public static void main(String[] args) {
        Out out = new Out();
        out.test();
    }
}

class Out {

    String name = "zhagnsan";

    void test() {

        String name = "lisi";

        class In {

            String name = "wangwu";

            void test() {
                System.out.println("局部内部类");
            }
        }

        In in = new In();
        in.test();
    }
}