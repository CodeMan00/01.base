package reflect;

import org.junit.Test;

import java.lang.reflect.Method;
import java.net.InetAddress;

/***
 *  反射：
 *      （1）Java反射机制的核心是在程序运行时动态加载类并获取类的详细信息，从而操作类或对象的属性和方法。本质是JVM得到class对象之后，
 *      再通过class对象进行反编译，从而获取对象的各种信息。
 *
 *      （2）Java属于先编译再运行的语言，程序中对象的类型在编译期就确定下来了，而当程序在运行时可能需要动态加载某些类，
 *      这些类因为之前用不到，所以没有被加载到JVM。通过反射，可以在运行时动态地创建对象并调用其属性，不需要提前在编译期知道运行的对象是谁。
 *
 *
 *      要操作一个类的字节码，首先需要获取该类的字节码文件。有三种方式获取字节码文件。
 */
public class ReflectTest01 {

    @Test
    public void test() throws ClassNotFoundException {

        /**
         *  获取Class对象的第一种方式：
         *
         *  1.静态方法
         *  2.方法的参数是一个字符串类型，参数是完整的类名(必须带有全包名)
         */
        Class c = Class.forName("java.lang.String");
        Class c1 = Class.forName("java.util.Date");
        Class c2 = Class.forName("java.lang.Integer");
        Class c3 = Class.forName("java.lang.System");


        Method[] methods = c.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        System.out.println(methods.length);
    }


    /**
     *
     *   java中的任何对象都有一个方法 getClass();
     *
     *     实例对象.getClass();
     */
    @Test
    public void test1(){

        String s = "aaa";
        String s1 = "bbb";
        Class c = s.getClass();
        Class c1 = s1.getClass();
        /**
         *   无论一个类有多少实例对象，在JVM种只有一个Class对象
         */
        System.out.println(c == c1);
    }

    /**
     * 第三种获取方式
     *
     *      类名.class   应用场景：用于参数的传递
     */
    @Test
    public void test2(){

        Class<String> cl = String.class;
    }


    /**
     * 演示三种获取Class对象的区别
     */
    @Test
    public void superTest() throws ClassNotFoundException {

       // Apple apple = new Apple();
//        对类进行静态初始化、非静态初始化（由于首先使用new得到类的实例对象，实际上是这一步对类进行了初始化）
      //  Class<? extends Apple> aClass = apple.getClass();

//        不做类的初始化工作，返回类的Class对象。
      //  Class<Apple> appleClass = Apple.class;


//        做类的静态初始化，返回类的Class对象。forName这句话就是装载类用的,当类被装载到jvm时，就会执行该类的静态代码段。
       Class<?> aClass1 = Class.forName("reflect.Apple");

    }


    /**
     *   通过类加载器 来获取到类的Class对象
     */
    @Test
    public void test4() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.先获取类加载器
        Apple apple = new Apple();
        ClassLoader loader = apple.getClass().getClassLoader();
        //通过类加载器得到Class对象
        Class<?> aClass = loader.loadClass("reflect.Apple");

        Apple app  =(Apple) aClass.newInstance();
        System.out.println(app);
    }


    /**
     *   基本数据类型(byte short int long float double char boolean) 按照如下方式获取Class对象
     */
    @Test
    public void test5(){
        Class<Integer> integerClass = int.class; //自动装箱
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//输出结果为int，自动拆箱
    }


    /**
     *  基本数据类型对应的包装类 可以通过 .TYPE  获取Class类对象
     */
    @Test
    public void test6(){
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);  //自动拆箱  结果为int
    }

}

class Apple{
    int a = 10;
    Apple(){
        System.out.println("Apple Constructor");
    }

    {
        System.out.println("这是一个非静态代码块");

    }
    static {
        System.out.println("这是静态代码块");
    }
}
