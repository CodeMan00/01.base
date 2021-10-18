package thread.thread01;

import java.util.Random;

public class ThreadTest02 extends Thread{

    @Override
    public void run() {

        for(int i = 0;i<10;i++){

            System.out.println("子线程：----->"+i);

            try {
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
