package socket_.tcp;

import scanner.ScannerTest01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author gjd
 * @create 2021/9/27  09:21:22
 */

//客户端
public class SocketClient3 {

    public static void main(String[] args) throws IOException {

        //1.连接服务器（ip，port）  连接本机的8888端口  如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //2. 把数据写入到 数据管道中
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题：");
        String info = scanner.nextLine();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(info);
        writer.newLine(); //写入内容结束标记
        writer.flush();
        socket.shutdownOutput();

        //3.创建读取流 来读取服务端的确认收到信息
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());
        reader.readLine(); //写入结束标记
        socket.shutdownInput();

        //关闭流和socket
        socket.close();
        System.out.println("客户端退出.....");
    }
}


