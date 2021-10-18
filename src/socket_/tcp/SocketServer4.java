package socket_.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gjd
 * @create 2021/9/27  15:17:57
 */
public class SocketServer4 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        int len = 0;
        byte [] bytes = new byte[1024];
        inputStream.read(bytes);
        socket.shutdownInput();

        //获取歌名
        String musicName = new String(bytes,0,len);

        String resFileName = "";
        if("image.mp4".equals(musicName)){
            resFileName = "src\\image.mp4";
        }else{
            resFileName = "src\\image.mp4";
        }

        //写数据
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int leng = 0;
        byte [] bytes1 = new byte[1024];
        while((leng=bis.read(bytes1))!=-1){
            bos.write(leng);
        }

        socket.shutdownOutput();

        //关闭资源
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
