package thread.thread03;

/**
 * 线程的thread.interrupt()方法是中断线程，将会设置该线程的中断状态位，即设置为true，
 * 中断的结果线程是死亡、还是等待新的任务或是继续运行至下一步，就取决于这个程序本身。线程会不时地检测这个中断标示位，
 * 以判断线程是否应该被中断（中断标示值是否为true）。它并不像stop方法那样会中断一个正在运行的线程。
 *
 *  注意：它并不是使线程结束，而是中断sleep，wait，join方法的执行，使其处于运行状态，而非阻塞状态，避免线程有可能一直处于
 *          阻塞的状态。
 *
 *   如果线程在调用 Object 类的 wait()、wait(long) 或 wait(long, int) 方法，或者该Thread类的 join()、join(long)、
 *   join(long, int)、sleep(long) 或 sleep(long, int) 方法过程中受阻，则其中断状态将被清除，它还将收到一个InterruptedException异常。
 *   这个时候，我们可以通过捕获InterruptedException异常来终止线程的执行，具体可以通过return等退出或改变共享变量的值使其退出
 */
public class ThreadTest05 implements Runnable {

    private Boolean flag = true;
    @Override
    public synchronized void run() {

        while(flag){

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"......Exception");
                flag = false;
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"....run");
        }
    }
    public  void changeFlag(){
        flag = false;
    }
}

class Test{

    public static void main(String[] args) {

        ThreadTest05 test = new ThreadTest05();

        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);

        //将线程标记为守护线程或者是用户线程   所有的非守护线程结束后，守护线程也会自动结束
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        int num = 0;

        while(true){
            if(num++ ==60){

                //中断t1线程的休眠
                t1.interrupt();
                t2.interrupt();
                //test.changeFlag();
                break;
            }
            System.out.println(Thread.currentThread().getName()+"........"+num);
        }
        System.out.println("over");
    }
}
