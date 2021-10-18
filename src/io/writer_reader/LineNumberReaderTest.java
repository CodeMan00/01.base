package io.writer_reader;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 */
public class LineNumberReaderTest {

    @Test
    public void test() {
        LineNumberReader lineNumberReader = null;
        try {
            lineNumberReader = new
                    LineNumberReader(new FileReader("E:\\idea\\IDEA Program\\senior\\01.base\\src\\io\\writer_reader\\BufferTest02.java"));

            //设置开始的行数
            lineNumberReader.setLineNumber(100);

            String line = null;
            while ((line = lineNumberReader.readLine()) != null) {

                System.out.println(lineNumberReader.getLineNumber() + " " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (lineNumberReader != null)
                    lineNumberReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
