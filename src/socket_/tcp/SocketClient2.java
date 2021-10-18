package socket_.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:21:22
 */

//客户端
public class SocketClient2 {

    public static void main(String[] args) throws IOException {

        //1.连接服务器（ip，port）  连接本机的8888端口  如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);


        //1.读出照片
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d://lala.jpg"));

        //2. 将照片写入到 数据管道中
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

        int len = 0;
        byte [] bytes = new byte[1024];
        while((len = bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes);
        }
        //写入内容结束标记
        socket.shutdownOutput();

        //3.创建读取流 来读取服务端的确认收到信息
        InputStream inputStream = socket.getInputStream();

        int leng = 0;
        byte [] bytes1 = new byte[1024];
        while((leng=inputStream.read(bytes1))!=-1){
            System.out.println(new String(bytes1,0,leng));
        }
        socket.shutdownInput();

        //关闭流和socket
        inputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}


