package collection.set.hashset;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Set:  元素无序(存入和取出的顺序不一致），元素不可重复
 * <p>
 * HashSet ：底层数据结构是哈希表
 * 1.不是线程同步的，集合中可以是null，但只能存入一个null
 * <p>
 * 2.存入元素时，HashSet会调用该对象的hashCode方法来得到该对象
 * 的hashCode值，根据该值决定该元素的存储位置
 * <p>
 * 3.HashSet判断两个元素是否相同的标准是通过两个对象的equals方法，并且
 * 两个对象的hashCode方法返回值要相等
 * <p>
 * 4.如果重新定义判断两对象是否相同的准则，不仅要重写equals方法，还要
 * 重写hashCode方法
 * <p>
 * <p>
 * 注意：判断两对象是否相同，进行了两次比较，第一次是计算哈希值，如果两对象的
 * 哈希值相同（哈希值相同代表着它们即将要存入的位置相同），再次调用
 * equals方法，判断对象是否相同，如果不同，存入集合，如果相同，不存入集合。
 * <p>
 * <p>
 * 注意2：集合判断某个元素是否存在或者删除一个元素时，依赖的方法是元素的hashCode() 和 equals()方法  《毕向东讲的》
 */
public class HashSetTest {

    public static void main(String[] args) {

        HashSet<Person> set = new HashSet<>();
        set.add(new Person("zhangsan", 12));
        set.add(new Person("lisi", 14));
        set.add(new Person("zhanwanggsan", 15));
        set.add(new Person("zhangsan", 12));

        Iterator<Person> it = set.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            System.out.println(person.getName() + "---" + person.getAge());
        }
    }


    @Test
    public void test() {
        HashSet<String> set = new HashSet<>();
        set.add("java01");
        set.add("java02");
        set.add("java03");
        set.add("java04");


        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;
        return this.age == person.age && this.name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}