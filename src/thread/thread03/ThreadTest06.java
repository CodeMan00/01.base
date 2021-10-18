package thread.thread03;

import org.junit.Test;

/**
 * @author gjd
 * @create 2021/9/27  07:30:57
 *
 * join方法  调用join方法的线程会获取执行权，当该线程的所有任务都执行完毕后，才释放执行权。该方法执行后进入阻塞状态，
 *     注意：执行join方法的线程在调用join方法的执行完毕之前，不会和调用join方法的线程抢资源，但是其他的线程会和调用join方法的线程抢资源。
 *
 *     yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的
 *     线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 *
 *     结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
 *
 *
 *  yield方法：线程的礼让，只是让出这一次的cpu执行权，在让出之后，继续会和其他线程抢资源，如果抢到资源，仍会继续执行。
 *              该方法执行后，进入了就绪状态。
 */
public class ThreadTest06 {

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();

        Thread thread = new Thread(thread1);
        Thread thread2 = new Thread(thread1);

        thread.start();
        thread2.start();

        for(int i = 0;i<20;i++){
            Thread.sleep(1000);
            //当i为5时，让出cpu
            if(i == 5)
                Thread.yield();

            //当i为10时，让子线程插队
            if(i==10)
                thread.join();
            System.out.println("hi-------->"+i);
        }
    }

}

class Thread1 implements Runnable{

    @Override
    public void run() {

        for(int i = 0;i<20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"hello--------------->"+i);
        }
    }
}
