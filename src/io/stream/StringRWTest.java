package io.stream;


import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringRWTest {

    @Test
    public void test() throws IOException {

        StringReader reader = new StringReader("Hello, Gao!");

        StringWriter writer = new StringWriter();

        int c;
        while((c=reader.read())!=-1){
            writer.write(c);
        }

        //返回字符串缓冲区本身
        System.out.println(writer.toString());
    }
}
