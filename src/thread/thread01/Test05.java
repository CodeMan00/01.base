package thread.thread01;

public class Test05 {

    public static void main(String[] args) throws InterruptedException {

        //创建子线程对象
        ThreadTest05 test = new ThreadTest05();
        //设置线程名称
        test.setName("test");
        //启动线程
        test.start();

        //main线程睡眠500毫秒
        Thread.sleep(500);


        //Thread(Runnable) 构造方法形参是Runnable接口，Thread类就是实现了Runnable的类
        Thread thread =new Thread(test);
        thread.setName("thread");
        thread.start();


        /**
         * 执行结果：
         *
         * 构造方法中，Thread.currentThread().getName的返回结果：main
         * 构造方法中，this.getName的返回结果：Thread-0
         * run方法中，Thread.currentThread().getName的返回结果：test
         * run方法中，this.getName的返回结果：test
         * run方法中，Thread.currentThread().getName的返回结果：thread
         * run方法中，this.getName的返回结果：test
         *
         *
         * 执行结果分析：
         *
         *         第一个：main线程执行了new 操作，所以会调用线程的构造方法
         *         第二个：this.getName() ，this表示的是当前对象，当前创建出了新的对象，返回的是新对象的名称，这个对象其实也就是
         *                  线程test，因为此时给线程改名的代码还没有被执行。
         *         第三个: 执行了start方法，test线程调用了run方法，
         *         第四个：this.getName表示当前线程的名称，当前线程就是test线程
         *         第五个：thread执行了start方法，然后就去调用run方法，所以就是thread
         *         第六个：由于thread线程的参数是实现Runnable接口，而且我们传入的也就是test，所以它
         *                  执行的是test类中的run方法。Thread类是实现了Runnable接口的。
         */

    }
}
