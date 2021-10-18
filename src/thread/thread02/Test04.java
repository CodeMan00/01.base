package thread.thread02;

public class Test04 {

    public static void main(String[] args) throws InterruptedException {

//        ThreadTest04 test = new ThreadTest04();
//        ThreadTest04 test2 = new ThreadTest04();
//        ThreadTest04 test3= new ThreadTest04();
//        ThreadTest04 test4 = new ThreadTest04();
//
//        test.setName("test");
//        test2.setName("test2------->");
//        test3.setName("test3------------------>");
//        test4.setName("test4------------------------------>");

//        test.start();
//        test2.start();
//        test3.start();
//        test4.start();


        MyRunnable runnable =new MyRunnable();

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
//        Thread thread3 = new Thread(runnable);
//        Thread thread4 = new Thread(runnable);

        thread.setName("runnable thread");
        thread2.setName("runnable thread2");
//        thread3.setName("runnable thread3");
//        thread4.setName("runnable thread4");

        thread.start();
        Thread.sleep(20);
        runnable.flag = false;
        thread2.start();
//        thread3.start();
//        thread4.start();

    }
}
