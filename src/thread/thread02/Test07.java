package thread.thread02;

public class Test07 {

    public static void main(String[] args) throws InterruptedException {

        ThreadTest07 test = new ThreadTest07(true);
        ThreadTest07 test2 = new ThreadTest07(false);

        Thread thread = new Thread(test);
        Thread thread1 = new Thread(test2);

        thread.setName("test");
        thread.start();
        thread1.start();
    }
}
