package io.stream;

import org.junit.Test;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *   切割文件
 *
 */
public class TaskTest01 {

    @Test
    public void test() throws IOException {

        BufferedInputStream input =  new BufferedInputStream(new FileInputStream("d://lala.jpg"));
        FileOutputStream out = null;
        //new BufferedOutputStream(new FileOutputStream("D://"))

        int count = 1;
        byte [] bytes = new byte[1024*1024];
        int length;
        while((length=input.read(bytes))!=-1){
            out = new FileOutputStream("d://"+(count++)+".part");
            out.write(bytes,0,length);
        }

        out.close();
        input.close();
    }


    @Test
    public  void test01() throws IOException {

        //问什么使用ArrayList存取呢，因为它的效率比Vector要高
        ArrayList<FileInputStream> arrayList = new ArrayList<>();
        arrayList.add(new FileInputStream("d://1.part"));
        arrayList.add(new FileInputStream("d://2.part"));
        arrayList.add(new FileInputStream("d://3.part"));

        Iterator<FileInputStream> iterator = arrayList.iterator();

        //为什么要重写枚举呢，因为SequenceInputStream仅支持枚举
        Enumeration<FileInputStream> enumeration =new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public FileInputStream nextElement() {
                return iterator.next();
            }
        };

        SequenceInputStream stream = new SequenceInputStream(enumeration);

        FileOutputStream out = new  FileOutputStream("d://123.jpg");

        int length;
        byte [] bytes = new byte[1024];

        while((length=stream.read(bytes))!=-1){
            out.write(bytes,0,length);
        }

        out.close();
        stream.close();
    }
}
