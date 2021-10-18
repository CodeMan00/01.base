package io.stream;

import org.junit.Test;

import java.io.*;

/**
 * 字节流缓冲区
 */
public class BufferedTest {

    @Test
    public void test() {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;


        try {
            outputStream = new BufferedOutputStream(new FileOutputStream("d://lala.jpg"));
            inputStream = new BufferedInputStream(new FileInputStream("d://image.jpg"));

            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {

                outputStream.write(bytes, 0, bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
