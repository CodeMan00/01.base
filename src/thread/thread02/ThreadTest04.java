package thread.thread02;

/**
 *    问题：
 *      票出现了重复售出的现象。
 *
 *   问题的原因：
 *      当多条语句是多个线程的共享数据时，一个线程对多条语句只执行了一部分，还没有执行完，另一个线程
 *      参与执行，导致共享数据的错误。
 *
 *    解决办法：
 *      对多条语句操作共享数据的语句，只能让一个线程都执行完。在执行过程中，其他线程不可以参与执行。
 *
 *
 *     同步代码块可以解决整个问题。
 *
 *
 *     同步代码块加到什么地方合适？
 *          1.明确哪些代码是多线程运行代码
 *          2.明确共享数据
 *          3.明确多线程运行代码中哪些语句是操作共享数据的。
 *
 *       注意：一定要明确哪些代码需要同步，不需要同步的代码尽量不要同步，因为可能会引发一些其他的错误。
 *
 *
 *     如果使用synchronized关键字修饰函数，那么函数就具备了同步的功能。
 *
 *     同步函数不像同步代码块那样，需要定义一个对象作为锁，那么它的锁是什么呢？
 *          函数需要被对象调用，函数都有一个所属对象的引用t，就是his。所以它的锁就是this
 *
 *      如果多个同步代码使用的不是一把锁，那么就不能实现同步。这是重点。一定要实现的是一把锁。
 */
public class ThreadTest04 extends Thread{

    private static int tick = 100;
    @Override
    public void run() {

        while(true){
            //参数是一个对象，任何对象都可以
            synchronized (new Object()){
                if(tick>0){
                    System.out.println(Thread.currentThread().getName()+"------->"+(tick--));
                }else {
                    break;
                }
            }
        }
    }
}

class MyRunnable implements  Runnable{

    private int tick = 100;
    Object object = new Object();

    boolean flag = true;

    @Override
    public void run() {
        if(flag){
            while(true){
                /**
                 * 注意：不能在小括号内直接new对象，直接new对象，每次执行同步代码块就是new出新的对象，就不能保证是同一个对象了。
                 *       同步代码块也就不能见效了。
                 */
                //synchronized (object){ //它和下面的同步方法不同同一把锁，所以不能实现同步。同步方法是this锁，该同步块使用的是object
                synchronized (this){
                    if(tick>0){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"-------code------->"+(tick--));
                    }else{
                        break;
                    }
                }

            }
        }else{
            while(true){
                show();
            }
        }
    }


    public synchronized void show(){
        if(tick>0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"------show------->"+(tick--));
        }
    }
}
