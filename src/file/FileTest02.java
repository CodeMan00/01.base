package file;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

public class FileTest02 {

    @Test
    public void test() {

        //获取所有的盘符
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println(file);
        }
    }

    @Test
    public void test1() {

        File file = new File("d://");
        //获取当前目录下的下一级目录及文件包含隐藏文件
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }


    @Test
    public void test2() {
        File file = new File("E:\\idea\\IDEA Program\\senior\\01.base\\src\\innerclass");

        /**
         *   自定义过滤条件
         */
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return name.endsWith(".java");
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * listFiles()   返回的是File对象数组，我们可以通过File对文件进行其他的操作
     */
    @Test
    public void test04() {

        File file = new File("d://");
        File[] files = file.listFiles();
        for(File file1 : files){
            System.out.println(file1.getName()+"<----->"+file1.length());
        }
    }
}
