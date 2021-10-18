package io.writer_reader;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 复制一个文件
 */
public class Task01 {

    @Test
    public void test() {

        FileWriter writer = null;
        FileReader reader = null;

        try {
            writer = new FileWriter("d://demo2.txt");
            reader = new FileReader("d://demo.txt");

            char[] buf = new char[1024];
            while (reader.read(buf) != -1) {
                String s = new String(buf, 0, buf.length);
                //System.out.println(s);
                writer.write(s);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
