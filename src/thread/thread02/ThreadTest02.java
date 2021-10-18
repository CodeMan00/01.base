package thread.thread02;

public class ThreadTest02 extends Thread {

    @Override
    public void run() {

        long begin = System.currentTimeMillis();

        long sum =0;

        for(int i = 1;i<100000;i++){
            sum +=i;
            // 放弃cpu的执行权
            Thread.yield();
        }
        long end = System.currentTimeMillis();

        System.out.println("执行时间："+(end - begin));
    }
}
