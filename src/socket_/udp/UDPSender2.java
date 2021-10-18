package socket_.udp;

import scanner.ScannerTest01;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author gjd
 * @create 2021/9/27  14:36:21
 */
public class UDPSender2 {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(6666);

        System.out.println("输入你的数据：");
        //获取数据
        Scanner scanner = new Scanner(System.in);
        byte [] first = scanner.next().getBytes();
        //封装数据
        DatagramPacket packet = new DatagramPacket(first,0,first.length, InetAddress.getLoopbackAddress(),8888);

        //发送数据
        socket.send(packet);

        byte[] bytes = new byte [1024];
        packet = new DatagramPacket(bytes,0,bytes.length);
        //获取返回的数据包
        socket.receive(packet);
        //拆包拿数据
        byte[] data = packet.getData();
        System.out.println(new String(data,0,packet.getLength()));

        //关闭资源
        socket.close();
    }
}
