package thread.thread01;

public class ThreadTest06 extends Thread{

    @Override
    public void run() {

        //只要能执行run方法，那么线程肯定是存活着的
        System.out.println("run方法 isAlive-------->"+this.isAlive());
    }
}
