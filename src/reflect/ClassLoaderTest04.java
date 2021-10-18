package reflect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

/**
 * 自定义网络类加载器
 *
 *  1.继承ClassLoader
 *  2.重写findClass方法
 */
public class ClassLoaderTest04 extends ClassLoader{

    private String url;
    public ClassLoaderTest04(String url){
        this.url = url;
    }

    public ClassLoaderTest04(String url,ClassLoader loader){
        super(loader);
        this.url =url;
    }


    @Override
    protected Class<?> findClass(String name)  {

        try {
            String path = url + "/"+name.replace(".","/")+".class";
            URL url = new URL(path);
            InputStream inputStream = url.openStream();

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int len = 0;
            byte [] bytes = new byte[1024];

            while((len=inputStream.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
            inputStream.close();
            out.close();
            byte[] bytes1 = out.toByteArray();

            return defineClass(name,bytes1,0,bytes1.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
