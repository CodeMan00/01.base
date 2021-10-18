package io.stream;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStreamTest {

    public static void main(String[] args) throws IOException {

        PipedInputStream pipedInputStream = new PipedInputStream();
        Read read = new Read(pipedInputStream);
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        Write write = new Write(pipedOutputStream);

        pipedInputStream.connect(pipedOutputStream);

        new Thread(read).start();;
        new Thread(write).start();


    }
}

class Read  implements Runnable{

    private PipedInputStream input;

    Read(PipedInputStream in){
        input =in ;
    }

    public void run(){

        try {


            byte [] bytes = new byte[1024];

            int len =  input.read(bytes);


            System.out.println(new String(bytes,0,len));

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Write implements Runnable{

    private PipedOutputStream out;
    Write(PipedOutputStream out){
        this.out= out;
    }


    public void run(){

        try {
            out.write("guan dao liu lai le".getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


