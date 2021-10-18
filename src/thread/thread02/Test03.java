package thread.thread02;

public class Test03 {

    public static void main(String[] args) {

        ThreadTest03 test = new ThreadTest03();
        test.setName("test");
        test.setPriority(1);
        test.start();

        ThreadTest test1 = new ThreadTest();
        test1.setName("test1");
        test1.setPriority(10);
        test1.start();
    }
}
