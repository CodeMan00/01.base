package thread.thread03;

/**
 *    等待唤醒机制：
 *          wait  notify  notifyAll
 *
 *        当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。
 *         当执行notify/notifyAll方法时，会唤醒一个处于等待【该对象锁】 的线程，然后继续往下执行，
 *         直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁。
 *
 *
 *     使用要点：
 *          1.wait() 与 notify/notifyAll 方法必须在同步代码块中使用
 *          2.wait() 与 notify/notifyAll() 是Object类的方法，在执行两个方法时，要先获得锁。通过锁对象进行调用这两个方法
 *          3.notify 通知的顺序不能错。
 *              假设在线程A中执行wait()，在线程B中执行notify()。但如果线程B先执行了notify()然后结束了，线程A才去执行wait()，那此时，线程A将无法被正常唤醒了
 *          4.wait和notify 等待和唤醒的是拥有同一把锁的线程。
 *          5.为社么wait和notify方法定义在Object中呢？ 因为任意对象都可以当作锁，所以需要定义在Object中。
 */

class Resource1{

    private String name;
    private String sex;
    private boolean flag = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Input1 implements Runnable{

    private Resource1 resource;

    Input1(Resource1 resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        int x = 0;
        while(true){
                synchronized (resource){
                    //如果有资源 则等待取出后在写入
                    if(resource.isFlag()) {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(x == 0){
                        resource.setName("mike");
                        resource.setSex("man");
                    }else{
                        resource.setName("丽丽") ;
                        resource.setSex("女女女女女女女女女女");
                    }
                    x = (x+1) % 2;
                    resource.setFlag(true);
                    resource.notify();
                }
        }
    }
}

class Output1 implements  Runnable{

    private Resource1 resource;
    Output1(Resource1 resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while(true){

            //操作的资源是同一个，所以可用来作为锁
            synchronized (resource){

                //如果没有资源 就等待
                if(!resource.isFlag()) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(resource.getName() + "---------------->"+resource.getSex());

                resource.setFlag(false);
                resource.notify();
            }
        }
    }
}

public class ThreadTest02 {

    public static void main(String[] args) {

        Resource1 resource = new Resource1();

        //资源要是同一个，通过构造的方式可以保证线程操作的资源是一致的
        Input1 input = new Input1(resource);
        Output1 output = new Output1(resource);

        Thread thread = new Thread(input);
        Thread thread1 = new Thread(output);

        thread.start();
        thread1.start();
    }
}
