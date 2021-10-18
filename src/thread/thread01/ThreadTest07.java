package thread.thread01;

public class ThreadTest07 extends Thread{

    @Override
    public void run() {

        System.out.println("run，threadName="+Thread.currentThread().getName()+"------>begin time==="+System.currentTimeMillis());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //在子线程的run方法中，如果编译时异常，只能捕获处理，不能抛异常，因为在父类或者父接口中，对run进行的就是捕获处理。
            e.printStackTrace();
        }

        System.out.println("run，threadName="+Thread.currentThread().getName()+"------>begin time==="+System.currentTimeMillis());
    }
}

