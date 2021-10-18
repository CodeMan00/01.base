package reflect;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *  使用反射机制比较灵活。
 *      我们可以从配置文件中读取我们要创建的对象的全类名，而且可以通过修改配置文件来获取任意对象的Class对象
 *
 */
public class ReflectTest03 {

    @Test
    public void test() throws IOException, ClassNotFoundException {

        Properties properties = new Properties();

        properties.load(new FileReader("src\\reflect\\properties.properties"));

        String className = properties.getProperty("className");


        Class<?> aClass = Class.forName(className);

        Method[] methods = aClass.getMethods();

        for(Method method:methods){
            System.out.println(method);
        }
    }
}
