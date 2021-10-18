package interfac_e;

/**
 * 接口中可以定义“成员变量”，但是必须使用public static final 三个关键字修饰
 * <p>
 * <p>
 * 接口中的常量遵循以下要求：
 * 1. public static final 可以省略
 * 2.接口的常量必须赋值
 * 3.接口中的常量名必须全部大写，单词之间使用下划线隔开
 * 4.通过 接口名 . 常量名来使用
 * <p>
 * <p>
 * 接口不能有静态代码块  和构造方法
 */
public class InterfaceTest05 {
}

interface Person {

    public static final int NUM = 10;
}

