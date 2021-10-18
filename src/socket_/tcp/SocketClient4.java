package socket_.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author gjd
 * @create 2021/9/27  15:17:40
 */
public class SocketClient4 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        System.out.println("今天，你想听什么？");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        OutputStream outputStream = socket.getOutputStream();
        //把数据写入
        outputStream.write(line.getBytes());
        socket.shutdownOutput();//关闭流



        //接收服务端传来的歌曲  并将歌曲写入本地磁盘
        BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
        PrintStream printStream = new PrintStream("d://"+line +".mp3");

        int len = 0;
        byte [] bytes = new byte[1024];
        while((inputStream.read(bytes))!=-1){
            printStream.write(bytes);
        }

        //关闭资源
        printStream.close();
        inputStream.close();
        socket.close();
    }
}
