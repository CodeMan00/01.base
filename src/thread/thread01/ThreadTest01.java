package thread.thread01;

/**
 * 定义一个类，让它继承Thread
 */
public class ThreadTest01  extends Thread {

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        System.out.println("这是子线程打印的内容！！！");
    }
}
