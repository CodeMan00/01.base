package reflect;

import java.io.*;

/**
 * 自定义类加载器
 *
 * 两步：
 *    1.继承ClassLoader
 *    2.重写findClass方法
 */
public class ClassLoaderTest02 extends ClassLoader {

    //指定被加载类的目录
    private String direction ;

    public ClassLoaderTest02(String direction){
        this.direction = direction;
    }

    public ClassLoaderTest02(String direction,ClassLoader parent){
        super(parent);
        this.direction = direction;
    }
    @Override
    protected Class<?> findClass(String name) {

        //direction就是文件所在目录， name表示是文件的全类名，把 . 转换为文件分隔符  然后加上 .class
        String file = direction + File.separator + name.replace(".",File.separator)+".class";

        FileInputStream in = null;
        //构建输入流
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //构建字节输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        byte [] bytes = new byte[1024];
        while(true){
            try {
                if (!((len=in.read(bytes))!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.write(bytes,0,len);
        }

        byte [] byte1 = out.toByteArray();
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return defineClass(name,byte1,0,byte1.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoaderTest02 test = new ClassLoaderTest02("d:/");
        //不用写.java后缀
        test.loadClass("demo.Demo").newInstance();
    }
}
