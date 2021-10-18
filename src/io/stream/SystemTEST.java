package io.stream;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/***
 *    读取键盘录入
 */
public class SystemTEST {


    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;

        //回车也算一个字符  \r 的ASCII 是10
//        int a = inputStream.read();
//        int b = inputStream.read();
//        int c = inputStream.read();
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);


        test();
    }

    public static void test() throws IOException {

        InputStream inputStream = System.in;

        StringBuilder builder = new StringBuilder();

        while (true) {

            int ch = inputStream.read();

            if (ch == '\n') {
                String s = builder.toString();
                if (s.equals("over"))
                    break;
                System.out.println(s.toUpperCase());
                //这样会是内存中的对象太多，浪费存储空间
                // builder = new StringBuilder();
                builder.delete(0, builder.length());
            } else {
                builder.append((char) ch);
            }
        }
    }
}
