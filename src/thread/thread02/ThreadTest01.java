package thread.thread02;

public class ThreadTest01 extends Thread{

    @Override
    public void run() {

        System.out.println("Thread name --->"+Thread.currentThread().getName()
            +", id====>"+Thread.currentThread().getId());
    }
}
