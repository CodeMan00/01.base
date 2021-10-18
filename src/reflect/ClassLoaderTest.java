package reflect;

import org.junit.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

public class ClassLoaderTest {

    @Test
    public void test(){

        /**
         *   根类加载器  只加载一下java、javax、sun开头的类
         *
         *   该加载器没有父加载器
         */
        ClassLoader classLoader = Object.class.getClassLoader();
        /**
         *  显示的为null，实际上不是null，出于安全，没有显示
         */
        System.out.println("Object 的类加载器："+classLoader);


        /**
         * 扩展类加载器
         *   加载jre\lib\ext目录下的类库或者系统变量"java.ext.dirs"指定目录下的类库。
         *
         *   DNSNameService类是ext目录下的类库中的一个类
         *
         *   该加载器的父加载器是根类加载器
         */

        ClassLoader classLoader2 = DNSNameService.class.getClassLoader();
        System.out.println("ext目录下DNSNameService类的类加载器："+classLoader2);


        /**
         *  系统类加载器，也叫做应用类加载器。加载我们写的程序
         *
         *  该加载器的父加载器是拓展类加载器
         */

        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println("我们写的程序的类加载器："+classLoader1);
    }


    /**
     *  验证 父类加载器
     */
    @Test
    public void test01(){


        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();

        while(classLoader1!=null){

            System.out.println(classLoader1);
            //获取该加载器的父加载器
            classLoader1 = classLoader1.getParent();
        }
    }
}
