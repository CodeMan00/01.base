package io.stream;

import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 这个流是连接不同的流   就是把东西粘在一起   把几个分支流合成了一个整体流
 */
public class SequenceInputStreamTest {

    @Test
    public void test() throws IOException {

        Vector<FileInputStream> vector = new Vector<>();

        vector.add(new FileInputStream("d://1.txt"));
        vector.add(new FileInputStream("d://2.txt"));
        vector.add(new FileInputStream("d://3.txt"));

        Enumeration<FileInputStream> elements = vector.elements();

        //两个构造方法，一个是将两个流合并   另一个是将多个流合并，多个流需要装入vector容器中，因为他能返回枚举类型
        SequenceInputStream seq = new SequenceInputStream(elements);

        FileOutputStream fileOutputStream = new FileOutputStream("d://4.txt");

        byte[] bytes =new byte[1024];
        while(seq.read(bytes)!=-1){
            fileOutputStream.write(bytes,0,bytes.length);
            fileOutputStream.flush();
        }

        seq.close();
        fileOutputStream.close();
    }
}
