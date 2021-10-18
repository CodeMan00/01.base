package thread.thread02;

/**
 *  se
 *
 *  JAVA 线程优先级取值范围1-10，如果超出这个范围会抛出异常。在cpu运行中，一般优先级越高的线程，获得cpu资源的
 *  机会就越多，线程优先级本质就是给线程调度器一个提示信息，以便线程调度器决定先调度哪些线程，不能保证优先级高的
 *  线程先运行。
 *  java优先级设置不当，或者滥用可能导致某些线程永远无法得到运行，即产生了线程饥饿
 *
 *  线程优先级并不是设置的越高越好。
 *
 *
 *  线程优先级具有继承性，在A线程中创建了B线程，则B线程具有继承性。
 */
public class ThreadTest03 extends Thread{

    @Override
    public void run() {

        long begin = System.currentTimeMillis();

        long sum = 0;
        for(int i=0;i<1000000;i++){
            sum +=i;
        }

        long end = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName()+"执行时间：" +(end - begin));
    }
}

class ThreadTest extends Thread{

    @Override
    public void run() {

        long begin = System.currentTimeMillis();

        long sum = 0;
        for(int i=0;i<100000;i++){
            sum +=i;
        }

        long end = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName()+"执行时间：" +(end - begin));
    }
}
