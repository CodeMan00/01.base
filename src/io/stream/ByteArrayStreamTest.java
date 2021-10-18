package io.stream;

import org.junit.Test;

import java.io.*;

/**
 *   ByteArrayInputStream 字节输入流    在构造的时候，需要传递字节数组
 *
 *   ByteArrayOutputStream  字节输出流     在构造时，不需要传入数据目的，底层封装了一个可变长度的字节数组
 *
 *       它们操作的是数组，而不是底层资源，所以不需要对流进行关闭，同时也不需要抛出IOException
 *
 *   它们的源和目的都是字节数组本身。
 */
public class ByteArrayStreamTest {

    @Test
    public void test() throws IOException {

        ByteArrayInputStream by = new ByteArrayInputStream("你好".getBytes());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int read ;

        while((read = by.read())!=-1){

            out.write(read);
        }
        //字节数组的长度
        System.out.println(out.size());
        //打印字节数组的内容  转换为字符串
        System.out.println(out.toString());


        //将数据写到流中  byte数组起到了缓冲数据的作用
        FileOutputStream stream = new FileOutputStream("d://byte.txt");
        //此方法就把输入写入到byte.txt文件中了
        out.writeTo(stream);

    }
}
