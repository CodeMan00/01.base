package io.stream;

import org.junit.Test;

import java.io.*;

/**
 * 转换流：把字节流转换为字符流
 * InputStreamReader  把InputStream 流  转换为Reader流
 * <p>
 * OutputStreamWriter  把OutputStream流转换为 Writer流
 */
public class StreamWR {

    public static void main(String[] args) throws IOException {

        testt();

    }


    public static void testt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while ((line = reader.readLine()) != null) {

            if (line.equals("over"))
                break;
            writer.write(line.toUpperCase());
            writer.newLine();
            writer.flush();

        }
    }


    public static void test() throws IOException {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d://txt.txt")));

        writer.write("aaaa");

        writer.close();
    }
}
