package collection.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型的好处：
 * 1.类型安全。
 * 编译器通过定义的变量来检验变量的类型是否正确
 * <p>
 * 2.消除强制类型转换。
 * 代码可读性提高，避免了类型转换的麻烦。
 * <p>
 * 3. 把运行时异常(如类型转换)，提升到了编译时异常
 * <p>
 * 4. 集合内的元素类型统一了
 * <p>
 * <p>
 * 泛型的缺点：
 * 1.导致集合中的元素缺乏多样性
 */
public class GenericTest {

    public static void main(String[] args) {

    }

    @Test
    public void test() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("string");
        list.add("string1");
        list.add("string2");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next();
            System.out.println(string);
        }
    }

    @Test
    public void test01() {

        //该表达式成为钻石表达式   是java8版本推出的自动类型推断机制
        List<Animal> list = new ArrayList<>();

        list.add(new Animal());
//        可以添加Animal子类
        list.add(new Dog());
        list.add(new Bird());

        Iterator<Animal> it = list.iterator();
        while (it.hasNext()) {
            //如果想调用子类特有的方法还需要转型
            Dog dog = (Dog) it.next();
            System.out.println(dog);
        }
    }
}

class Animal {

    public void eat(){

    }
    private int eat(int a){
        return  1;
    }

}

class Dog extends Animal {



}

class Bird extends Animal {

}