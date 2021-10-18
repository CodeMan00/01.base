package thread.thread02;

public class Test01 {

    public static void main(String[] args) {

        System.out.println("Thread name --->"+Thread.currentThread().getName()
                +", id====>"+Thread.currentThread().getId());

        for (int i =0;i<50;i++){
            //某个编号的线程运行结束后，该编号可能被后续创建的线程使用。
            new ThreadTest01().start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
