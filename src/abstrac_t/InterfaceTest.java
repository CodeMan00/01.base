package abstrac_t;

abstract class Animal {

    //   抽象方法   没有具体的实现内容
    abstract void eat();

    //    普通的成员方法
    void sleep() {
        System.out.println("sleep");
    }
}

class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("子类实现了方法");
    }
}
