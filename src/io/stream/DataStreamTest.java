package io.stream;

import org.junit.Test;

import java.io.*;

/**
 *   用来操作基本数据类型
 */
public class DataStreamTest {

    @Test
    public void test() throws IOException {


        DataOutputStream stream = new DataOutputStream(new FileOutputStream("d://demo.txt"));

        stream.writeInt(111);
        stream.writeBoolean(true);
        stream.writeDouble(12.22);

        /**
         *  writeUTF()   与机器无关的方式 modified UTF-8编码将数据写出去
         *
         *          读取的时候也只能通过对应的方法读取出来
         */
        stream.writeUTF("你好");


        stream.close();
    }

    /**
     * 读取数据
     */
    @Test
    public void test1() throws IOException {

        DataInputStream input = new DataInputStream(new FileInputStream("d://demo.txt"));

        System.out.println(input.readInt());
        System.out.println(input.readBoolean());
        System.out.println(input.readDouble());

        /**
         *  通过readUTF()读取 与机器无关的方式 modified UTF-8编码的数据
         *
         *  注意：它一个汉字对应4个字节
         */
        System.out.println(input.readUTF());

        input.close();
    }
}
