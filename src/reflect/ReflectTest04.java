package reflect;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *    文件路径问题：
 *
 */
public class ReflectTest04 {

    @Test
    public void test() throws IOException, ClassNotFoundException {

        /**
         *  这种路径缺点：
         *      直接写死路径，是不合适的，这是路径idea可以正确读出内容，而代码运行到其他的编译器，未必就能
         *      正确的取出内容，所以不建议这样写。
         */

      //  FileReader reader = new FileReader("reflect\\properties.properties");

        /**
         *     一种通用的路径写法；
         *          使用这种方式还有一个前提，就是所使用的文件需要在类路径下。
         *          什么是类路径下呢？凡是在src下的文件都属于在类路径下。src是类的根路径。
         *
         *   该方式获取到文件的绝对路径,起点是从类的根路径下进行加载。
         *
         *   如果文件在src的下一级，那么直接写文件名即可，如果在其他的包内，那么需要带上包名。
         */


        /**
         *  获取文件路径  然后根据路径创建流对象
         */
//        String path = Thread.currentThread().getContextClassLoader().getResource("reflect/properties.properties").getPath();
//
//        System.out.println(path);
//        FileReader reader = new FileReader(path);

        /**
         *      直接根据路径返回流对象
         */
        InputStream resourceAsStream = Thread.currentThread().
                getContextClassLoader().getResourceAsStream("reflect/properties.properties");



        Properties properties = new Properties();

        //properties.load(reader);

        properties.load(resourceAsStream);

        String className = properties.getProperty("className");

        Class<?> aClass = Class.forName(className);

        Method[] methods = aClass.getMethods();

        for(Method method:methods){
            System.out.println(method);
        }
    }


    /**
     * java.util 包提供了一种资源绑定器，便于获取属性配置文件中的内容。
     *  使用这种方式，属性配置文件必须在类路径下。
     */
    @Test
    public void test01(){

        /**
         *  资源绑定器，只能绑定properties文件，并且这个文件必须在类路径下。文件扩展名不用写。
         */
        ResourceBundle bundle = ResourceBundle.getBundle("reflect/properties");

        //直接获取className对应的值了，太方便了。
        String className = bundle.getString("className");

        System.out.println(className);

    }
}
