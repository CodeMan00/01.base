package socket_.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  09:27:47
 */
public class SocketServer3 {

    public static void main(String[] args) throws IOException {

        //1.在本机的8888端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端，在8888端口监听，等待连接...");

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String response ;
        String s = reader.readLine();
        if("name".equals(s)){
            response = "我是 server";
        } else if("hobby".equals(s)){
            response = "编写java程序";
        } else
            response = "你说啥呢";

        //把返回结果写会回去
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write(response);
        writer.newLine(); //写入结束标记
        writer.flush();


        //5.关闭流和socket
        socket.close();
        serverSocket.close();
    }
}
