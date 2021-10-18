package socket_.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:21:22
 */

//客户端
public class SocketClient {

    public static void main(String[] args) throws IOException {

        //1.连接服务器（ip，port）  连接本机的9999端口  如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.连接上后，生成Socket，通过socket.getOutputStream()，得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();


        //3.通过输出流，写入数据到 数据通道
        outputStream.write("hello server".getBytes());
        //设置写入结束标记
        socket.shutdownOutput();

        //4.读取服务端返回的数据
        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte [] bytes =new byte[1024];
        while((len=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        //关闭流和socket
        outputStream.close();
        socket.close();
        inputStream.close();
        System.out.println("客户端退出.....");
    }
}


