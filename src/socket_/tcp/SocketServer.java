package socket_.tcp;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:27:47
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {

        //1.在本机的9999端口监听，等待连接   要求本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");

        //2.当没有客户端连接9999端口，程序会阻塞，等待连接； 如果有客户端连接，返回Socket对象
            //因为serverSocket 可以通过accept() 返回多个Socket，这就是并发，服务器不是为一个人服务的。
        Socket socket = serverSocket.accept();

        //3.通过socket.getInputStream() 读取客户端写入到数据通道的数据，
        InputStream inputStream = socket.getInputStream();


        //4.读取数据管道中的数据
        int len = 0;
        byte [] bytes = new byte[1024];
        while((len= inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        //5.获得写入流，把数据写入到数据管道，发送到客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hi, data is accepted, bye, client".getBytes());
        //设置写入结束标记
        socket.shutdownOutput();

        //5.关闭流和socket
        socket.close();
        inputStream.close();
        outputStream.close();
        serverSocket.close();
    }
}
