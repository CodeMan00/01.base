package io.stream;

import org.junit.Test;

import java.io.*;

/**
 *   底层是一个字符数组，和ByteArrayInputStream  和 ByteArrayOutputStream 相似
 *
 */
public class CharArrayRWTest {

    @Test
    public void test() throws IOException {

        CharArrayReader reader = new CharArrayReader("你好,Gao".toCharArray());

        CharArrayWriter writer = new CharArrayWriter();

        int len = 0;
        while ((len=reader.read())!=-1){

            writer.write(len);
        }

        System.out.println(writer.size());
        System.out.println(writer.toString());

        FileWriter writer1 = new FileWriter("d://char.txt");
        //将数据写入到指定的文件中
        writer.writeTo(writer1);

        /**
         *  这是和字节流不同的一点，字符流就是要刷新   养成字符流刷新的习惯，老是忘记刷新操作。
         *
         *    字节流可以不能刷新，就能存入到文件中
         */
        writer1.flush();
        writer1.close();
    }
}
