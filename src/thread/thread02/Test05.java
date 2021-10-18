package thread.thread02;

public class Test05 {

    public static void main(String[] args) throws InterruptedException {


        ThreadTest05 runnable =new ThreadTest05();

        Thread thread =new Thread(runnable);
        Thread thread2 = new Thread(runnable);


        thread.setName("runnable thread");
        thread2.setName("runnable thread2");


        thread.start();
        Thread.sleep(20);
        runnable.flag = false;
        thread2.start();

    }
}
