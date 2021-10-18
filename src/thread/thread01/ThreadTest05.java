package thread.thread01;

public class ThreadTest05 extends Thread{

    ThreadTest05(){
        System.out.println("构造方法中，Thread.currentThread().getName的返回结果："+Thread.currentThread().getName());
        System.out.println("构造方法中，this.getName的返回结果："+this.getName());
    }
    @Override
    public void run() {

        System.out.println("run方法中，Thread.currentThread().getName的返回结果："+Thread.currentThread().getName());
        System.out.println("run方法中，this.getName的返回结果："+this.getName());
    }
}
