package file;

import org.junit.Test;

import java.io.File;

/**
 *   遍历指定目录下的文件或者文件夹，包含子目录中的文件内容
 *
 *    步骤：
 *      1.先遍历指定文件目录，输出内容，然后判断是否是文件夹
 *      2.如果是文件夹，那么继续遍历此文件夹中的内容，并判断是否是文件夹
 *      3.直到没有文件夹，退回上一级目录，遍历其他的文件或文件夹
 *      3. 递推内容就是判定是否为文件夹，然后遍历
 */
public class FileTest03 {


    public static void main(String[] args) {

        File file = new File("D:\\A2DH\\23.【灰灰考研】重庆邮电大学-22腾飞版");

        cha(file);
    }

    public static void cha(File dir){

        System.out.println(dir
        );
        File[] files = dir.listFiles();

        for(int i =0; i<files.length; i++){

            if (files[i].isDirectory()) {
                cha(files[i]);
            }else {
                System.out.println("---|--->"+files[i].getName());
            }
        }
    }
}
