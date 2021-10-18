package extend;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 继承中的构造方法
 * <p>
 * 1.子类构造方法当中有一个默认隐含的 super() 调用，所以一定先调用父类构造，后执行子类构造
 * 2.子类可以在构造方法中可以通过super()关键字来调用父类的构造方法
 * 3.super的构造调用必须在父类的构造方法中的第一条，且子类的一个构造方法中只能调用一次super构造
 * <p>
 * <p>
 * super关键字的三种用法：
 * 1.在子类的成员方法中，访问父类的成员变量
 * 2.在子类的成员方法中，访问父类的成员方法
 * 3.在子类的构造方法中，访问父类的构造方法
 */
public class ExtendConstructorTest {

    public static void main(String[] args) {

        Student s = new Student();
        s.learn();
    }
}

class Person {

    Person() {
        System.out.println("Person方法执行了");
    }

    public void learn() {
        System.out.println("Person learning");
    }
}

class Student extends Person {

    Student() {
        System.out.println("student方法执行了");
    }

    public void learn() {
        super.learn();
        System.out.println("Student also learning");
    }
}
