package thread.thread01;

public class Test07 {

    public static void main(String[] args) {

        ThreadTest07 test = new ThreadTest07();
        System.out.println("main begin = "+System.currentTimeMillis());

        //开启新的线程
      // test.start();

        //在main线程中调用run方法，没有开启新的线程
        test.run();

        System.out.println("main end = "+ System.currentTimeMillis());
    }
}
