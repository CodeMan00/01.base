package file;

import org.junit.Test;

import java.io.File;

/**
 *  删除原理：
 *      删除目录从里面往外删除，需要用到递归。
 */
public class FileTest04 {

    @Test
    public void test(){

        File file = new File("d://aa");
        test1(file);

    }

    public static void test1(File file){

        //获取文件夹的内容
        File[] files = file.listFiles();
        //判断是否是空文件
        if(files.length == 0)
            //是，直接删除
            file.delete();

        //不是空文件夹  遍历该文件夹
        for(int i = 0 ;i < files.length;i++){
            //子文件夹
            if(files[i].isDirectory()&&files[i].isHidden()){
                System.out.println(files[i]);
                test1(files[i]);
            }else{
                System.out.println(files[i]+"----->文件已删除："+files[i].delete());
            }
        }
        file.delete();
    }
}
