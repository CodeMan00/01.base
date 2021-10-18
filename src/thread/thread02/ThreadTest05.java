package thread.thread02;

/**
 *  静态进内存中，内存中没有本类对象，但有该类对应的字节码文件对象  类名.class  该对象的类型是Class
 *
 *  静态同步方法，使用的锁是该方法所在类的字节码文件对象。类名.class
 *
 */
public class ThreadTest05 implements  Runnable{

    private static int tick = 100;
    Object object = new Object();

    boolean flag = true;

    @Override
    public void run() {
        if(flag){
            while(true){
                synchronized (ThreadTest05.class){
                    if(tick>0){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"-------code------->"+(tick--));
                    }else{
                        break;
                    }
                }

            }
        }else{
            while(true){
                show();
            }
        }
    }


    public static synchronized void show(){
        if(tick>0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"------show------->"+(tick--));
        }
    }
}
