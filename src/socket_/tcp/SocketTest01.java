package socket_.tcp;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author gjd
 * @create 2021/9/27  09:07:41
 *
 * InetAddress的使用
 */
public class SocketTest01 {

    @Test
    public void test() throws UnknownHostException {

        //1.获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        //返回设备名称和ip地址
        System.out.println(localHost);

        //2.通过主机名获取InetAddress对象
        InetAddress gjd = InetAddress.getByName("GJD");
        System.out.println(gjd);

        //3.根据域名返回InetAddress对象,比如www.baidu.com对应的InetAddress对象
        InetAddress byAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(byAddress);


        //4.根据 InetAddress 对象，获取对应的地址
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);

        //把地址转换为字节数组
        byte[] address = localHost.getAddress();
        System.out.println(Arrays.toString(address));


        //5.通过InetAddress对象获取对应的主机名/或者是域名
        String hostName = byAddress.getHostName();
        String hostName1 = localHost.getHostName();
        System.out.println(hostName1);
    }
}
