package innerclass;

/**
 * 如果接口的实现类(或者是父类的子类)只需要使用唯一的一次，那么这种情况下就可以省略掉
 * 该类的定义，而改为使用【匿名内部类】
 * <p>
 * <p>
 * 匿名内部类：
 * new 接口名称(){...} 进行解析：
 * 1.new 代表创建对象的动作
 * 2.接口名称就是匿名内部类需要实现哪个接口
 * 3.{...}就是匿名内部类的内容
 * <p>
 * <p>
 * 匿名内部类的使用：
 * 匿名内部类只能使用一次
 */
public class InnerClassTest03 {

    public static void main(String[] args) {

        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("我是匿名内部类");
            }
        };

        animal.eat();
    }
}

interface Animal {

    void eat();
}
