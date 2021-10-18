package socket_.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author gjd
 * @create 2021/9/27  12:34:57
 *
 *  UDP:
 *      1.没有明确的服务端和客户端，只有一个DatagramSocket对象用来接收或发送
 *      2.接收数据和发送数据是通过DatagramSocket对象完成。
 *      3.将数据封装到DatagramPacket对象
 *      4.当接收到DatagramPacket对象，需要进行拆包，取出数据。
 *      5. DatagramSocket 可以指定在哪个端口接收数据。
 *      6. 一个数据包的大小限制在64k。
 */
public class UDPReceiver {

    public static void main(String[] args) throws IOException {

        //创建一个DatagramSocket对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);

        //创建一个DatagramPacket对象，用来存放接收到的数据  包最大为64k
        byte [] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);

        /**
         *  调用接收方法，将通过网络传输的DatagramPacket对象 存放在packet中，
         *  当有数据包发送到本机的9999端口，就会接收到数据，如果没有，就会阻塞等待。
         */
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);

        //把packet数据包 拆开，  getLength获取的是实际接收到的数据长度
        int length = packet.getLength();
        byte[] data = packet.getData();  //接收到的数据

        System.out.println("Receiver:"+new String(data,0,length));

        //返回已接收的确认信息
        byte [] bytes1 = "数据已接收!".getBytes();
        //packet = new DatagramPacket(bytes1,bytes1.length, InetAddress.getLocalHost(),9998);
        packet.setData(bytes1);
        packet.setAddress(InetAddress.getLocalHost());
        packet.setPort(9998);
        socket.send(packet);

        //关闭资源
        socket.close();
        System.out.println("接收端接收完毕！");
    }
}
