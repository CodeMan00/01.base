package polymorphism;


/**
 * 方法的重写
 * <p>
 * 父类和子类之间的多态性，对父类的函数进行重新定义。子类继承父类的方法，
 * 只能对方法内的代码进行重写，方法名和参数列表和返回值类型都是不能进行
 * 修改的。
 */


public class PolymorphismTest {


}

class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move() {
        System.out.println("animal move");
    }
}

class Cat extends Animal {


    public Cat(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("cat move");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}