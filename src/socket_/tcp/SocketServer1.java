package socket_.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:27:47
 *
 *
 * 使用字符流进行传输
 */
public class SocketServer1 {

    public static void main(String[] args) throws IOException {

        //1.在本机的9999端口监听，等待连接   要求本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");

        //2.当没有客户端连接9999端口，程序会阻塞，等待连接； 如果有客户端连接，返回Socket对象
            //因为serverSocket 可以通过accept() 返回多个Socket，这就是并发，服务器不是为一个人服务的。
        Socket socket = serverSocket.accept();

        //3.通过socket.getInputStream() 读取客户端写入到数据通道的数据，
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //4.读取数据管道中的数据
        //读取结束标记
        String s = bufferedReader.readLine();
        System.out.println(s);


        //5.获得写入流，把数据写入到数据管道，发送到客户端
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("hi, data is accepted, bye, client");
        //设置写入结束标记
        bufferedWriter.newLine();
        //把缓冲区中的数据刷新到数据管道中
        bufferedWriter.flush();

        //5.关闭流和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
