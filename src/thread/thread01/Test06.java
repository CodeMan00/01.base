package thread.thread01;

public class Test06 {

    public static void main(String[] args) throws InterruptedException {

        ThreadTest06 test = new ThreadTest06();

        //在启动之前，线程不存在
        System.out.println("begin-------->"+test.isAlive());

        test.start();


        // 此时无法判断是否存活，如果线程还没结束，就返回true，如果线程已经结束，返回false
        //Thread.sleep(1000);
        System.out.println("end-------------->"+test.isAlive());
    }
}
