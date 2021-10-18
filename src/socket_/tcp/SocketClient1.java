package socket_.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:21:22
 *
 *
 *  使用字符流进行传输
 */

//客户端
public class SocketClient1 {

    public static void main(String[] args) throws IOException {

        //1.连接服务器（ip，port）  连接本机的9999端口  如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.连接上后，生成Socket，通过socket.getOutputStream()，得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        //3.通过输出流，写入数据到 数据通道
        writer.write("hello server");
        //设置写入结束标记，表示写入的内容结束，对面接收时，需要使用readLine方法，读到结束标记，表示内容已经结束了
        writer.newLine();
        //字符流在写入时，需要进行刷新，否则数据不会进入数据通道，而是在缓冲区中。
        writer.flush();


        //4.读取服务端返回的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //写入结束标记
        String s = reader.readLine();
        System.out.println(s);

        //关闭流和socket   关闭外层流就行了
        reader.close();
        writer.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}


