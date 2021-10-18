package socket_.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author gjd
 * @create 2021/9/27  12:49:40
 */
public class UDPSender {

    public static void main(String [] args) throws IOException {

        //创建DatagramSocket对象准备发送或接收数据，  在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        // 创建数据包对象
        byte [] bytes = "wo gei ni fa shu ju le o ~~~~~~~~~".getBytes();

        //第一参数：数据  第二个参数：字节数组长度  第三个参数：接收的ip  第四个：接收端主机的端口
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),9999);

        //通过socket 把数据包发送出去
        socket.send(packet);


        //接收接收端确认收到信息

        //byte [] byte1 = new byte[2048];
        //DatagramPacket packet1 = new DatagramPacket(byte1,byte1.length);
        socket.receive(packet);
        byte[] data = packet.getData();
        System.out.println("Sender:"+new String(data,0,packet.getLength()));

        //关闭资源
        socket.close();
        System.out.println("Sender 发送完毕！");
    }
}
