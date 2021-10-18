package thread.thread03;

import com.sun.org.apache.regexp.internal.RE;

/**
 *  线程之间的通信
 */

class Resource{

    String name;
    String sex;
}

class Input implements Runnable{

    private Resource resource;

    Input(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        int x = 0;
        while(true){
            synchronized (resource){
                if(x == 0){
                    resource.name = "mike";
                    resource.sex = "man";
                }else{
                    resource.name = "丽丽";
                    resource.sex = "女女女女女女女女女女";
                }
                x = (x+1) % 2;
            }
        }
    }
}

class Output implements  Runnable{

    private Resource resource;
    Output(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while(true){

            //操作的资源是同一个，所以可用来作为锁
            synchronized (resource){
                System.out.println(resource.name + "---------------->"+resource.sex);
            }
        }
    }
}
public class ThreadTest01 {

    public static void main(String[] args) {

        Resource resource = new Resource();

        //资源要是同一个，通过构造的方式可以保证线程操作的资源是一致的
        Input input = new Input(resource);
        Output output = new Output(resource);

        Thread thread = new Thread(input);
        Thread thread1 = new Thread(output);

        thread.start();
        thread1.start();
    }
}
