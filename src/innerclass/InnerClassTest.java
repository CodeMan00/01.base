package innerclass;

/**
 * 内部类分类：
 * 成员内部类
 * 内部类用外部类的成员，都可以
 * 外部类使用内部类的成员，需要内部类对象
 * 局部内部类（包含匿名内部类）
 * <p>
 * <p>
 * 如何使用内部类？
 *  1.间接方式：在外部类的方法中，通过创建内部类的对象，可以使用内部类。
 *  2.直接创建内部类对象   Outer.Inner inner = new Outer().new Inner();
 * <p>
 * <p>
 * 内部类和外部类同名变量的访问？
 * 对于内部类和外部类的同名变量，内部类访问的内部类的局部变量，内部类可以通过this.属性名 来访问内部类的成员变量
 * 内部类可以通过Outer.this.num访问到外部类的成员变量
 * <p>
 * <p>
 * <p>
 * 内部类在编译时会生成对应的class文件  下面的Outer类编译后会生成两个class文件
 * 一个是Outer.class  另一个是Outer$Inner.class文件
 */
public class InnerClassTest {

    public static void main(String[] args) {

        Outer outer = new Outer();
        outer.eat();
        System.out.println(outer.age);

        Outer.Inner inner = new Outer().new Inner();
        inner.eat();

    }
}


class Outer {

    private String name = "zhangsan";
    protected int age = 12;

    void eat() {
        System.out.println("eat方法 外部类");

    }


    class Inner {

        private String name = "lisi";
        protected int age = 22;

        void eat() {
            String name = "wangwu";

            System.out.println("name:" + name);
            System.out.println(this.name);
            System.out.println(Outer.this.name);
        }
    }
}
