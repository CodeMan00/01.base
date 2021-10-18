package interfac_e;

/**
 * 接口与接口之间可以继承，而且支持多继承
 * <p>
 * <p>
 * <p>
 * 多个父接口当中的抽象方法如果重复，没有关系
 * <p>
 * <p>
 * 多个父接口当中的默认方法如果重复，那么子接口就必须对默认方法
 * 覆盖重写，而且重写的方法还要带上default关键字
 */
public class InterfaceTest07 implements C {
    @Override
    public void a() {

    }

    @Override
    public void ab() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}

interface A {

    void a();

    void ab();

    default void aa() {
        System.out.println("aa");
    }
}

interface B {

    void b();

    void ab();

    default void aa() {
        System.out.println("bb");
    }
}

interface C extends A, B {

    void c();

    @Override
    default void aa() {

    }
}


