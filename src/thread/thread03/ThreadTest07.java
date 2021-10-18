package thread.thread03;

/**
 * @author gjd
 * @create 2021/9/27  08:28:16
 */
public class ThreadTest07 {

    public static void main(String[] args) throws InterruptedException {

        MyDaemon daemon = new MyDaemon();

        /**
         *  设置为守护线程
         */
        daemon.setDaemon(true);
        daemon.start();

        for(int i = 0;i<10;i++){
            System.out.println("我是主线程~~~~~~~~~~~~~~~~~");
            Thread.sleep(500);
        }

    }
}

class MyDaemon extends  Thread{

    @Override
    public void run() {

        //无限循环
        for(;;){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我被设置为了守护线程~~~~~~~~~~~~");
        }
    }
}