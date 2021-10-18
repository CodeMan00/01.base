package thread.thread02;

//懒汉式 单例模式
public class ThreadTest06 {

    private static  ThreadTest06 s = null;

    private ThreadTest06(){

    }

    // 改代码块会出现多线程问题
//    public static ThreadTest06 getInstance(){
//
//        if( s == null)
//            s = new ThreadTest06();
//        return s;
//    }


    //加上同步   但是老是判断锁，所以效率稍低下
//    public static  ThreadTest06 getInstance(){
//
//        synchronized (ThreadTest05.class){
//            if( s == null)
//                s = new ThreadTest06();
//        }
//        return s;
//    }

    //最终版的懒汉式代码
    public static  ThreadTest06 getInstance(){

        if( s == null){
            synchronized (ThreadTest05.class){
                if( s == null)
                    s = new ThreadTest06();
            }
        }
        return s;
    }

}


////饿汉式
//class Single{
//
//    private static final Single s =new Single();
//    private Single(){
//
//    }
//
//    public static Single getInstance(){
//        return s;
//    }
//}
//
