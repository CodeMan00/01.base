package socket_.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author gjd
 * @create 2021/9/27  14:36:11
 */
public class UPDReceiver2 {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8888);

        //定义接收包
        byte [] bytes = new byte[2048*10];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);

        System.out.println("Receiver 正在等在接收数据包....");
        //接收数据包
        socket.receive(packet);

        //拆包拿数据
        byte[] data = packet.getData();

        //检查数据并设置返回的数据
        String s = new String(data, 0, packet.getLength());
        if("四大名著是哪些".equals(s)){
            bytes = "四大名著是(《红楼梦》、《水浒传》、《西游记》、《三国演义》)".getBytes();
        } else{
            bytes = "what?".getBytes();
        }

        //定义发送的包
        packet = new DatagramPacket(bytes,0,bytes.length,InetAddress.getLocalHost(),6666);

        //发送数据
        socket.send(packet);

        //关闭资源
        socket.close();
    }
}
