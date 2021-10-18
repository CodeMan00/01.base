package map;

import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 *  properties 是hashtable的子类
 *
 *  具备map集合的特点，而且它里面存储的键值对都是字符串
 *
 *  可以用于键值对形式的配置文件
 *
 *  在加载数据时，需要数据有固定格式
 */
public class PropertiesTest {

    //设置和获取元素
    @Test
    public void test(){

        Properties properties = new Properties();
        properties.setProperty("zhangsan","12");
        properties.setProperty("lisi","123");
        System.out.println(properties);

        //根据键获取值
        System.out.println(properties.getProperty("zhangsan"));

        //获取所有的键
        Set<String> strings = properties.stringPropertyNames();
        for(String s : strings){
            System.out.println(s +"----->"+properties.getProperty(s));
            System.out.println(s + "----->"+properties.get(s));
        }
    }

    /**
     *  将一个文件中的数据存储到properteis中
     *
     *  步骤：
     *      1.将文件和流关联起来
     *      2.读取一行数据，然后用=进行切割
     *      3.等号左边是键，右边是值，存入到properties中
     */

    public void test11() throws IOException {

        Properties properties = new Properties();
        BufferedReader reader = new BufferedReader(new FileReader("d://info.txt"));

        String line = null;
        while((line=reader.readLine())!=null){
            String[] split = line.split("=");
            properties.setProperty(split[0],split[1]);
        }

        reader.close();
    }


    //通过加载流，把文件中的配置信息，存到properties中
    @Test
    public void test01() throws IOException {

        Properties properties = new Properties();
        //将流中的数据加载到集合中
        properties.load(new FileInputStream("d://info.txt"));
        System.out.println(properties);

        properties.list(System.out);
    }


    //将在propeties修改后的数据写入到文件中
    @Test
    public void test1() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("d://info.txt"));

        properties.setProperty("zhangsan","23");

        //第二个参数是注释信息
        properties.store(new FileOutputStream("d://info.txt"),"this is modified by gao");
    }
}
