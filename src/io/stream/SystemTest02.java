package io.stream;

import org.junit.Test;

import java.io.*;

public class SystemTest02 {

    @Test
    public void test() throws IOException {

        //修改System的源，从键盘输入 改成从文件中读取   setIn() 参数是一个字节输入流
        System.setIn(new FileInputStream("E:\\idea\\IDEA Program\\senior\\01.base\\src\\io\\stream\\FileOutputStreamTest.java"));

        //修改System的目的，从控制台输出，改为输入到指定文件中或者其他地方。
        System.setOut(new PrintStream("d://print.txt"));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = reader.readLine()) != null) {

            writer.write(line);
            writer.newLine();
            writer.flush();
        }
    }
}
