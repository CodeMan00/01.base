package staic;

/**
 * static 关键字的使用
 * <p>
 * 1.static 静态的
 * <p>
 * 2.static 可以用来修饰：属性、方法、代码块、内部类
 * <p>
 * 3.对于一个共享的数据 可以使用static 修饰，内存中只保留一份，凡是属于本类对象，共享一份  当类加载时，就会被初始化
 * static成员变量初始化顺序按照定义进行初始化。
 * <p>
 * 4.被static修饰的属性成为静态变量
 * 属性是否被static修饰，有分为静态变量和非静态变量(实例变量)
 * <p>
 * 非静态变量是对象所拥有的，在创建对象的时候被初始化。
 */
public class TestStatic {

    public static void main(String[] args) {

        Chinese chinese = new Chinese();
        chinese.name = "张三";
        chinese.age = 12;
        chinese.nation = "china";

        Chinese chinese1 = new Chinese();
        chinese1.name = "李四";
        chinese1.age = 23;
        chinese1.nation = "chn";

        System.out.println(Chinese.nation);
    }
}

//类 中国人
class Chinese {

    String name;
    int age;
    static String nation;

}
