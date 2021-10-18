package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gjd
 * @create 2021/9/27  18:10:18
 *
 * 反射虽然灵活，但是它的执行效率要远小于直接使用new关键字创建对象
 *
 * Class类不是new出来的，而是系统创建的
 *
 *Class对象，在堆内存中只有一个，每个类的实例都知道自己是由哪个Class实例造出来的。
 *
 *  静态加载：
 *      编译时加载相关的类，如果我们没有定义该类，则会报错，依赖性太强。
 *  动态加载：
 *      运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性。 反射就是动态加载类，当编译时，如果我们获取Person类，
 *      即使Person不存在，也不会在编译时报错，当运行时，发现没有Person才报错。
 *      好处：
 *          1.灵活，需要该类时，才加载，不必占用内存空间。
 */
public class ReflectTest10 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        method();
        meth();
        meth_2();
    }

    public static void method(){

        long begin = System.currentTimeMillis();
        Cat cat = new Cat();
        for(int i = 0;i<999999999;i++){
            cat.sleep();
        }

        long end = System.currentTimeMillis();
        System.out.println("直接new对象所消耗的时间："+(end-begin));
    }

    public static void meth() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        long begin = System.currentTimeMillis();
        Class<?> aClass = Class.forName("reflect.Cat");
        Cat cat =(Cat) aClass.newInstance();
        Method sleep = aClass.getMethod("sleep");
        for(int i = 0;i<999999999;i++){
            sleep.invoke(cat);
        }
        long en = System.currentTimeMillis();
        System.out.println("通过反射消耗的时间："+(en-begin));
    }

    //因为凡是执行效率太低，对反射进行优化，但是效果不是特别大
    public static void meth_2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        long begin = System.currentTimeMillis();
        Class<?> aClass = Class.forName("reflect.Cat");
        Cat cat =(Cat) aClass.newInstance();
        Method sleep = aClass.getMethod("sleep");
        /**
         *  setAccessible 启用和禁用访问安全检查的开关，值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查
         *   在通过放射调用方式时，取消访问检查，这样可以提高效率
         */
        sleep.setAccessible(true);
        for(int i = 0;i<999999999;i++){
            sleep.invoke(cat);
        }
        long en = System.currentTimeMillis();
        System.out.println("通过反射消耗的时间："+(en-begin));
    }
}

class Cat{

    String name;
    int age ;

    public void sleep(){
       //System.out.println("I'm sleeping");
    }

    public void eat(){
        System.out.println("I'm eating");
    }
}