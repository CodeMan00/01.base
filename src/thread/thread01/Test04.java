package thread.thread01;

public class Test04 {

    public static void main(String[] args) {

        System.out.println("构造方法打印当前线程的名称："+Thread.currentThread().getName());

        //创建子线程，调用构造方法，在main线程调用了构造方法，所以在构造方法中的线程就是main线程
        ThreadTest04 test = new ThreadTest04();

        //启动子线程  子线程会调用run方法
        //test.start();

        //在main方法中，直接调用run方法，没有开启新的线程，所以在run方法中的当前线程就是main线程
        test.run();

    }
}
