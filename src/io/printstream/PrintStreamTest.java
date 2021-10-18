package io.printstream;

import org.junit.Test;

import java.io.*;

/**
 *  该流提供了打印方式，可以将各种数据类型的数据都原样打印
 *
 *  字节打印流：
 *     PrintStream
 *     构造方法：
 *          1.file对象    2.字符串路径     3.字节输出流
 *
 *    字符打印流：
 *        PrintWriter
 *        构造方法：
 *          1.file对象    2.字符串路径     3.字节输出流     4.字符输出流
 */
public class PrintStreamTest {


    public static void main(String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //第二个参数表示是否自动刷新
        PrintWriter writer = new PrintWriter(System.out,true);
        //不支持自动刷新，需要手写刷新语句
        PrintWriter writer1 = new PrintWriter(System.out);

        //此时没有流，不能进行刷新。只能在结束时才能把数据写入到文件中  如果我们刷新，可以把文件用流封装一下
        PrintWriter writer2 = new PrintWriter("a.txt");

        String line = null;
        while((line=reader.readLine())!=null){

            if("over".equals(line)){
                break;
            }
            writer.println(line.toUpperCase());
        }
        reader.close();
        writer.close();
    }
}
