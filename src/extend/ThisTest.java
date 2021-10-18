package extend;

/**
 * this关键字
 * <p>
 * 1.在本类的成员方法中，访问本类的成员变量
 * 2.在本类的成员方法中，访问本类的另一个成员方法
 * 3.在本类的构造方法中，访问本类的另一个构造方法
 */
public class ThisTest {

    int age = 10;

    ThisTest() {
        System.out.println("无参构造方法");
    }

    ThisTest(int a) {
        this();
        System.out.println("有参构造方法" + a);
    }

    public static void main(String[] args) {

    }

    public void learn() {
        int age = 100;
        //this.age 访问的是成员变量  而不是局部变量
        System.out.println("learning" + this.age);
    }

    public void sleep() {
        this.learn();
        System.out.println("sleeping");
    }
}

class Test {

    public static void main(String[] args) {

        ThisTest test = new ThisTest(10);
        test.sleep();
    }
}
