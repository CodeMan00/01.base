package io;


import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {


    @Test
    public void test() throws IOException {

        /**
         * rw 表示既能读又能写   r表示只能读不能写
         *
         * 在rw模式下，如果目标文件不存在，会自动创建文件，如果已经存在 ，不会覆盖。
         *
         * 在r模式下，如果目标文件不存在，会抛出异常。
         */

        RandomAccessFile accessFile = new RandomAccessFile("d://ran.txt","rw");

        accessFile.write("李四".getBytes());
        accessFile.writeInt(97);

        accessFile.write("王五".getBytes());
        /**
         *   直接写入4个字节   write方法只写入数字字节的后8位，这样会导致数据不完整
         */
        accessFile.writeInt(99);

        accessFile.close();
    }

    @Test
    public void test1() throws  IOException{


        RandomAccessFile file = new RandomAccessFile("d://ran.txt","r");

        //utf-8 一个汉字3个字节  定义6个字节的byte数组取出名字
        byte [] bytes = new byte[6];
        for(int i = 0;i<=1;i++){

            /**
             * 调节对象中的指针，对于一些有规律的数据，可以通过此方法取出数据
             *
             * 我们可以通过这个方法进行定位，在任意位置上写入数据，或者在已经有数据的地方，重新写入数据，即修改原有数据
             */
            file.seek(10*i); //李四两个字6个字节，  int类型数据4个字节  一共10个字节
            file.read(bytes);

            /**
              * 跳过指定的字节数
             */
            //file.skipBytes(8);


            System.out.println("name=" +new String(bytes));
            //readInt() 读取4个字节的int数据
            System.out.println("age="+file.readInt());
        }
    }
}
