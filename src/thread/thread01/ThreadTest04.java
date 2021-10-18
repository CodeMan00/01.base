package thread.thread01;


public class ThreadTest04 extends Thread{

    //在构造方法中打印当前线程的名称
    ThreadTest04(){
        System.out.println("构造方法打印当前线程的名称："+Thread.currentThread().getName());
    }


    @Override
    public void run() {
        //currentThread是静态方法，返回的是正在执行当前程序的线程
        System.out.println("run 方法打印当前线程的名称："+ Thread.currentThread().getName());
    }
}
