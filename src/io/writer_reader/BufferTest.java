package io.writer_reader;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/***
 *     缓冲区的出现是为了提高流的操作效率
 */
public class BufferTest {

    @Test
    public void test() {

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter("d://buffer.txt");
            bufferedWriter = new BufferedWriter(writer);


            bufferedWriter.write("hahahahahtianqiasmmeishidongren1");
            bufferedWriter.newLine(); //写入换行符
            bufferedWriter.write("299292929");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
