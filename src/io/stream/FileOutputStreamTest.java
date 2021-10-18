package io.stream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 操作字符我们可以使用字符流
 * <p>
 * 操作图片、音频等文件我们需要使用字节流
 * <p>
 * 父类  OutputStream
 * <p>
 * 子类：
 * FileOutputStream  等
 */
public class FileOutputStreamTest {


    //Output
    @Test
    public void test() {

        FileOutputStream fileOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream("d://output.txt");


            /**
             * 注意：字节流不需要刷新数据到目标文件中
             */
            fileOutputStream.write("abcdefgh".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //Input
    @Test
    public void test02() {

        FileInputStream inputStream = null;

        try {

            inputStream = new FileInputStream("d://output.txt");

            /**
             *   read方法
             */
//           int i = 0;
//            while((i=inputStream.read())!=-1){
//                System.out.print((char)i);
//            }


            /**
             *   read(byte [] buf)
             */

//            byte [] buf = new byte[1024];
//
//            while(inputStream.read(buf)!=-1){
//                System.out.println(new String(buf,0,buf.length));
//            }


            /**
             *  available()  统计字符数，空格也算，  回车（\r\n）算两个字符
             *
             *  这样的话，我们可以再定义缓冲区时，定义一个刚刚好的缓冲区
             *
             *  byte [] buf = new byte [inputstream.avavilable()];
             */

            int result = inputStream.available();
            System.out.println("available <-----> " + result);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test03() {


    }
}
