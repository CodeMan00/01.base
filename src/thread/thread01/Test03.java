package thread.thread01;

public class Test03 {

    public static void main(String[] args) {

        //创建Runnable接口的实现对象
        ThreadTest03 test = new ThreadTest03();

        //创建线程对象
        Thread thread = new Thread(test);

        //开启线程
        thread.start();

        //当前是main线程
        for(int i = 0; i<1000;i++){
            System.out.println("main线程-------------->"+i);
        }


        //有时候调用Thread(Runnable)构造方法是，实参也会传递匿名内部类对象
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<=1000;i++){
                    System.out.println("thread2----------------------->"+i);
                }
            }
        });
        thread1.start();
    }
}
