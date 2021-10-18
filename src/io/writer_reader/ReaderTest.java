package io.writer_reader;


import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {

    @Test
    public void test() {

        FileReader reader = null;

        try {
            reader = new FileReader("d://demo.txt");


//          第一种读取方式：  读取方式为一次读一个字符 读一个输出一个
//            while(reader.read()!=-1){
//                int read = reader.read();
//                System.out.print((char)read);
//            }


//            第二种读取方式   读字符到字节数组中  读完数组再输出
            char[] buf = new char[1024];
            while (reader.read(buf) != -1) {
                System.out.println(new String(buf, 0, buf.length));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //读数据到字符数组中
    @Test
    public void test01() {


    }
}
