package io.writer_reader;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流：
 * 用来操作字符
 * <p>
 * Writer字符流的父类
 * <p>
 * FileWriter  操作文件的
 * PipeWriter  管道流
 * OutputStreamWriter   转换流
 */
public class FileWriterTest01 {

    @Test
    public void test() {

        FileWriter writer = null;

        try {
            //创建一个FileWriter对象，该对象一旦被初始化就必须要明确要操作的文件，如果文件存在，那么复写，如果不存在，创建文件
            //writer = new FileWriter("d://demo.txt");


            //支持追加  而不是复写
            writer = new FileWriter("d://demo.txt", true);


            //把数据写入到了流中    \r\n表示换行  在现在的系统中\n也表示换行
            writer.write("jjjjjjjjjjjjabasf\nasdf");

//            把流中的数据刷新到文件中
            // writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (writer != null)
                    //流关闭之前，会把流中的数据刷到文件中
                    writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
