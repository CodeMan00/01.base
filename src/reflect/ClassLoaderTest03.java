package reflect;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest03 {

    /**
     * 这是通过URLLoader加载本地上的类，同时还可以加载网络上的类。
     */
    @Test
    public void test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        File file = new File("d:/");

        URI uri = file.toURI();

        URL url = uri.toURL();

        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        System.out.println("父类加载器："+classLoader.getParent());
        Class<?> aClass = classLoader.loadClass("demo.Demo");
        Object o = aClass.newInstance();

    }
}
