package io.stream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemTest03 {

    @Test
    public void test() throws FileNotFoundException {

        //获取系统配置信息
        Properties properties = System.getProperties();


        properties.list(new PrintStream("d:system.txt"));
    }
}
