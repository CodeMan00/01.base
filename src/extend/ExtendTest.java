package extend;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

/**
 * 面向对象的三大特征：
 * 封装性、继承性、多态性
 * 继承是多态的前提，如果没有继承，就没有多态
 * <p>
 * <p>
 * 继承主要解决问题的是：共性抽取
 * <p>
 * 继承特点：
 * 1.子类可以拥有父类的 ”内容“
 * 2.子类还可以拥有自己的 ”内容“
 * <p>
 * 关于重写：
 * 1.子类和父类的方法名必须相同，参数列表也相同
 * 2.子类方法的返回值必须小于等于父类方法的返回值范围
 * 3.子类方法的权限修饰符要大于父类方法的权限修饰符
 * public > protected > (default) > private
 * <p>
 * <p>
 * <p>
 * 继承只是单继承，如果继承只能继承一个类，但是可以多级继承，一个类既可以是
 * 子类，也可以是父类
 */
public class ExtendTest {

    public static void main(String[] args) {

        //虽然子类中没有方法，但是它继承了父类中的方法
        Teacher teacher = new Teacher();
        //teacher.method();

        Employee employee = new Employee();
        //System.out.println(employee.employee);

        //子类可以访问父类中的成员变量和成员方法
        //System.out.println(teacher.employee);
        //System.out.println(teacher.teacher);


        //当成员方法重名了  子类访问自己的成员变量  父类访问的也是自己的成员变量
//        如果子类中没有name属性，那么子类去父类中去找，如果有，就返回父类的值
        System.out.println(employee.name);
        System.out.println(teacher.name);


    }
}

//员工类
class Employee {

    int employee = 20;
    String name = "zhangsan";

    public void method() {
        System.out.println("Employee方法执行了");
    }

}

//老师类
class Teacher extends Employee {

    String name = "lisi";
    int teacher = 15;

    public void method() {
        //自己本类中有name属性，所以就使用的是本类的name值  如果没有，就去父类找
        System.out.println("name的值：" + name);
        //访问父类的name属性
        System.out.println(super.name);
    }
}

//助教 类
class Assistant extends Employee {

}
