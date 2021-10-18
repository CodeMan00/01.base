package socket_.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:27:47
 */
public class SocketServer2 {

    public static void main(String[] args) throws IOException {

        //1.在本机的8888端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端，在8888端口监听，等待连接...");

        Socket socket = serverSocket.accept();

        //2.接收照片
        InputStream inputStream = socket.getInputStream();
        PrintStream printStream = new PrintStream(new File("src\\image.jpg"));
        int len = 0;
        byte [] bytes = new byte[1024];
        while((len= inputStream.read(bytes))!=-1){
            printStream.write(bytes);
        }
        socket.shutdownInput();


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到照片".getBytes());
        //设置写入结束标记
        socket.shutdownOutput();

        //5.关闭流和socket
        outputStream.close();
        printStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
