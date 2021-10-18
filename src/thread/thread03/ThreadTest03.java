package thread.thread03;


class Goods{

    private int count = 0;
    private boolean flag = false;

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


class Producer implements Runnable{

    private Goods goods;

    Producer(Goods goods){

        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){

            synchronized (goods){
                while(goods.isFlag()) {
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goods.setCount(1+(goods.getCount()));
                System.out.println(Thread.currentThread().getName()+"--------------->"+goods.getCount());
                goods.setFlag(true);
                goods.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable{

    private Goods goods;

    Consumer(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            synchronized (goods){
                while(!goods.isFlag()){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--------->"+goods.getCount());
                goods.setFlag(false);
                goods.notifyAll();
            }
        }
    }
}
public class ThreadTest03 {

    public static void main(String[] args) {

        Goods goods = new Goods();

        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

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
