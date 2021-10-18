package thread.thread01;

import org.junit.Test;

public class Test01 {

    public static void main(String[] args) {

        System.out.println("JVM虚拟器启动main线程，main线程执行main方法");

        //创建子线程对象
        ThreadTest01 test = new ThreadTest01();
        /**
         *  启动线程
         *
         *      调用线程的start()方法来启动线程，启动线程的实质就是请求JVM运行相应的线程
         *      这个线程什么时候执行，由线程调度器(Scheduler)来决定
         *
         *      start方法被调用，并不意味着子线程开始运行了，而是处于就绪状态
         *      新开启的线程会执行run方法，如果开启了多个线程，start方法调用的顺序并不一定就是start方法书写的前后顺序
         *
         *      多线程运行结果与代码执行的顺序或者调用顺序无关
         */
        test.start();

        System.out.println("这是main线程其他的代码");
    }
}
