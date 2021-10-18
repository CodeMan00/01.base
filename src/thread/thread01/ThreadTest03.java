package thread.thread01;

/***
 *   当线程已经有父类了，就不能在继承Thread类，可以实现Runnable接口的形式
 */
public class ThreadTest03 implements Runnable{

    //重写Runnable接口的run方法  run方法就是子线程要执行的代码
    @Override
    public void run() {

        for(int i = 0 ;i<=1000;i++){
            System.out.println("子线程------>"+i);
        }
    }
}
