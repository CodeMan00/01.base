package thread.thread02;

public class Test02 {

    public static void main(String[] args) {

        ThreadTest02 test = new ThreadTest02();

        test.start();

        long begin = System.currentTimeMillis();

        long sum =0;

        for(int i = 1;i<10000000;i++){
            sum +=i;
        }
        long end = System.currentTimeMillis();

        System.out.println("执行时间："+(end - begin));
    }
}
