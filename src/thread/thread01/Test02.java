package thread.thread01;

public class Test02 {

    public static void main(String[] args) {

        ThreadTest02 test = new ThreadTest02();
        test.start();

        //当前是main线程
        for(int i = 0;i<10;i++){

            System.out.println("main线程：----->"+i);

            try {
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
