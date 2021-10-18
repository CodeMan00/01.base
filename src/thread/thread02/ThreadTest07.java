package thread.thread02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

/**
 *   死锁.
 *
 *    如果同步块之间进行嵌套，并且它们所持有的锁不同，那么就会造成死锁。
 */
public class ThreadTest07 implements Runnable{

    private boolean flag;
    ThreadTest07(boolean flag){
        this.flag = flag;
    }

    //注意：必须使用static修饰，如果没有static修饰，不会发生死锁现象
     static Object object =new Object();
     static Object object2 =new Object();


    @Override
    public void run() {

            if(flag){
                synchronized (object2){
                    System.out.println(Thread.currentThread().getName()+"------->if 语句 object2:"+object2);
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"------->if 语句 object:"+object);

                    }
                }
            }else{
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"--------------->else 语句 object"+object);
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName()+"--------------->else 语句 object2" +object2);
                    }
                }
            }
    }
}
