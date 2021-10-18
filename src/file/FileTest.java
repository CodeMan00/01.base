package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileTest {

    @Test
    public void test() {

        /**
         *   构造方法
         */


        /**
         * 第一种方式
         */
        File file = new File("d://aaaa.txt");

        /**
         * 第二种方式
         */
        //这种方法更加灵活  第二个参数是文件名  可以通过变量来赋值
        String s = "a.txt";
        File file1 = new File("d://", "aaba.txt");
        File file2 = new File("D://", s);


        /**
         *  第三种方式
         */
        File file3 = new File("d://");
        File file4 = new File(file3, "bbb.txt");


        /**
         *  系统分割符
         *    由于不同的系统，分隔符可能不同，所以 我们可以使用 separator来应对不同的系统
         */
        File file5 = new File("d:" + File.separator + "dddd//dd.txt");

        //打印的结果就是File构造方法中的参数  如果有两个参数，那么结果就是两个参数的拼接
        System.out.println(file2);
    }


    /**
     * File的创建方法
     */
    @Test
    public void test01() throws IOException {

        File file = new File("d:" + File.separator + "at.txt");

        //如果文件已经存在，则不创建，返回false
        boolean b = file.createNewFile();
        //System.out.println(b);


        //只能创建一级目录  由于D盘下a文件夹不存在，所以无法在a文件夹中创建b文件夹 这就叫只创建一级目录
        File file1 = new File("d://a//b");

        //可以创建多级目录
        file1.mkdirs();
        System.out.println(file1.mkdir());
    }


    /**
     * 删除方法
     */
    @Test
    public void test02() {

        File file = new File("d:" + File.separator + "at.txt");

        //删除失败返回false
        System.out.println("delete:" + file.delete());

        //程序退出时 删除
        file.deleteOnExit();

        //boolean b = file.deleteOnExit();
        // System.out.println(b);
    }

    @Test
    public void test03() {

        File file = new File("output.txt");
        //文件是否可执行
        boolean b = file.canExecute();
        // System.out.println(b);

        //判断文件是否存在
        System.out.println(file.exists());

//        判断是否是目录 在判断是否是目录之前，先会通过exists方法判断该目录是否存在
        System.out.println(file.isDirectory());
//        判断是否是文件   在判断是否是文件之前，先会通过exists方法判断该文件是否存在
        System.out.println(file.isFile());

//        判断是否是绝对路径
        System.out.println(file.isAbsolute());
    }

    @Test
    public void test04() {

        File file = new File("d://output.txt");

        /**
         *   wenjain
         */
        //获取路径  也就是File构造方法中得参数路径  文件不存在也可以获取
        System.out.println(file.getPath());

        //获取绝对路径
        System.out.println(file.getAbsolutePath());

        //返回的是null   因为构造方法中是相对路径，所以返回null
        System.out.println(file.getParent());

        //最后一次文件被修改的时间  首先文件需要存在，如果不存在返回0
        long l = file.lastModified();
        Date date = new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //返回文件的大小  首先文件需要存在，如果不存在返回0
        long length = file.length();
        System.out.println(length);
    }


    @Test
    public void test05() {

        File file = new File("d://ddd3dt.txt");
        File file1 = new File("d://output.txt");


        //修改名称  把file1的名称修改为file的名称  无论文件是否存在  都能成功运行
        //file1.renameTo(file);
        //System.out.println(file.getName());

        //通过此方式 能实现文件的剪切(文件移动)效果
        File file2 = new File("d://txt.txt");
        File file3 = new File("e://haha.txt");

        //d盘的txt.txt 消失了  e盘中多了个haha.txt
        file2.renameTo(file3);

    }
}
