package file;

import org.junit.Test;

import java.io.*;

/**
 * 将一个指定目录下的java文件的绝对路径，存储到一个文本文件中
 *
 *  建立一个java文件列表文件
 *
 *
 *  步骤：
 *      1.遍历当前目录的所有java文件的目录 而非文件夹
 *      2.通过流写入到文本中
 *      3.对于子目录，递归即可
 */
public class FileTest05 {

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\idea\\IDEA Program\\senior\\01.base\\src");

        BufferedWriter writer = new BufferedWriter(new FileWriter("d://txt.txt"));

        test(writer,file);

        writer.close();

    }


    public static void test(BufferedWriter writer, File file) throws IOException {

        File[] files = file.listFiles();
        writer.write(file.getName());
        writer.newLine();
        for(int i = 0; i< files.length;i++){

            if(!files[i].isHidden() && files[i].isDirectory()){
               writer.write("----------------------");
               test(writer,files[i]);
            }else{
                if(files[i].getName().endsWith(".java")){
                    String path = files[i].getAbsolutePath();
                    writer.write(path);
                    writer.newLine();
                }
            }
        }
    }
}
