package interfac_e;

/**
 * 注意： java9版本才能用
 * <p>
 * 接口中的私有方法
 * <p>
 * 为什么设置私有方法？
 * 当接口中有多个默认方法，且这几个默认方法中代码很大一部分都是重复的
 * 所以我们把重复的代码抽取出来，独自封装成新的方法，但是这个新的方法
 * 是该接口内部使用的，所以用私有方法来规定这个方法不能被重写，只能
 * 接口内部自己用。
 * <p>
 * <p>
 * 普通私有方法：
 * 解决多个默认方法之间重复代码问题
 * <p>
 * 静态私有方法：
 * 解决多个静态方法之间重复代码的问题
 */
public class InterfaceTest04 {
}


interface Animals {

    default void eat() {
        System.out.println("eat方法执行了");
    }

    default void sleep() {
        System.out.println("sleep方法执行了");
    }

    //注意：java9版本才能使用
//    private void common(){
//        System.out.println("这是private方法");
//    }


    static void look() {
        System.out.println("look方法执行了");
    }

    static void smell() {
        System.out.println("smell方法执行了");
    }

//    java9版本才能使用
//    private static void common1(){
//        System.out.println("这是private static");
//    }
}
