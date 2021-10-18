package io.stream;


import org.junit.Test;
import java.io.*;
import java.util.Arrays;

/**
 *   编码：  字符串编程字节数组
 *
 *   解码：   字节数组变为字符串
 */
public class EncodeStreamTest {

    @Test
    public void test01() throws IOException {

        //采用gbk的编码方式存储数据
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");

        writer.write("你好".toCharArray());

        writer.flush();
        writer.close();
    }

    //采用gbk的编码方式进行读取数据
    @Test
    public void test() throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"gbk");

        char [] buf = new char[10];

        int len = isr.read(buf);

        System.out.println(new String(buf,0,len));
    }


    @Test
    public void test02() throws UnsupportedEncodingException {

        String s = "你好";

        // utf-8  默认编码方式是utf-8
        byte [] bytes = s.getBytes();
        byte [] bytes1 = s.getBytes("utf-8");
        byte [] bytes2 = s.getBytes("gbk");

        String string = new String (bytes,"utf-8");
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test03(){

        String s = "联通";

        s.getBytes();
    }
}
