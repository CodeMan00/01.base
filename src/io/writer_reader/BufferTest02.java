package io.writer_reader;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 其实BufferedWriter 和BufferedReader都是对原有流对象的装饰增强
 * 这里需要了解装饰设计模式：
 * 当想要对已有的对象进行功能增强时，可以定义类，将已有对象传入，基于已有的功能，并提供加强功能。
 * 那么自定义的该类称为装饰类。装饰类通常会通过构造方法接收被装饰的对象。 并基于被装饰的对象的功能，提供更强的功能。
 * <p>
 * <p>
 * 它与继承的区别？
 * 装饰模式比继承要灵活。避免了继承体系臃肿。而且降低了类于类之间的关系（即所谓的耦合性， 继承的一个缺点就是耦合性太强）。
 * <p>
 * 装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。 所以装饰类和被装饰类通常是都属于一个体系中的。
 */
public class BufferTest02 {

    @Test
    public void test() {

        BufferedReader br = null;
        FileReader reader = null;

        try {
            reader = new FileReader("d://buffer.txt");
            br = new BufferedReader(reader);

            String line = null;
            /**
             * readLine底层都是通过read方法一个一个字符的读取，当读到换行符时，就结束读取
             */
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
