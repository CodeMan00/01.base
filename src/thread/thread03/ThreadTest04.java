package thread.thread03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods1{

    private int count = 0;
    private boolean flag = false;
    private final Lock lock = new ReentrantLock();

    /**
     *    Lock可以创建多个多个Condition来操作锁。对于这些Condition，可以配合起来使用。
     *
     *    创建一个生产者的Condition ， 当消费者的消费完商品后，更改了标记，同时通过生产者的Condition唤醒了生产者， 然后消费者再次判断完标记，
     *    就会被阻塞， 这时已经唤醒生产者线程，生产者线程开始进行生产，生产完后，更改标记，同时通过消费者的Condition唤醒了消费者，然后生产者
     *    判断标记，为true，就进行阻塞，消费者此时已经被唤醒，开始消费。这就这一直循环。
     */
    private final Condition condition_con = lock.newCondition();
    //把lock和wait、notify、notify分开了，使用这些方法需要从Condidtion类中调用
    private final Condition condition_pro = lock.newCondition();


    public void produce(){
        try{
            while(true){
                //获取锁
                lock.lock();
                while(flag) {
                    //等待方法
                    try {
                        condition_pro.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                setCount(1+(getCount()));
                System.out.println(Thread.currentThread().getName()+"--------------->"+getCount());
                flag=true;
                //唤醒使用同一个锁的其他线程
                condition_con.signal();
            }
        }finally {
            //释放锁
            lock.unlock();
        }
    }


    /**
     *  消费者
     */
    public void consume(){

        try{
            while(true){
                //获取锁
                lock.lock();
                while(!flag){
                    try {
                        condition_con.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+"--------->"+getCount());
                setFlag(false);
                condition_pro.signal();
            }
        }finally{
            //释放锁
            lock.unlock();
        }
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


class Producer1 implements Runnable{

    private Goods1 goods;

    Producer1(Goods1 goods){

        this.goods = goods;
    }




    @Override
    public void run() {
        goods.produce();
    }
}

class Consumer1 implements Runnable{

    private Goods1 goods;


    Consumer1(Goods1 goods){
        this.goods = goods;

    }

    @Override
    public void run() {
        goods.consume();
    }
}
public class ThreadTest04 {

    public static void main(String[] args) {

        Goods1 goods = new Goods1();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Producer1 producer = new Producer1(goods);
        Consumer1 consumer = new Consumer1(goods);

        Thread thread = new Thread(producer);
        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(producer);
        Thread thread3 = new Thread(consumer);

        thread.setName("producer0");
        thread1.setName("consumer0");
        thread2.setName("producer1");
        thread3.setName("consumer1");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
