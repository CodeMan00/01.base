package map;

import org.junit.Test;

import java.util.*;

/**
 * map集合  用来存键值对   键要保证唯一性
 * <p>
 * 子类：
 * HashTable
 * 1.线程同步
 * 2.不能存入null键和null值
 * 3.底层是哈希表数据
 * HashMap
 * 1.线程不同步
 * 2.能存入null键和null值
 * 3.底层是哈希表
 * <p>
 * TreeMap
 * 1.可以实现元素的自然排序
 * 2.底层是二叉数，排序就是二叉树的排序，它是通过键进行排序
 * 3.线程不同步
 * <p>
 * <p>
 * LinkedHashMap
 * 1.底层是哈希表和链表，有序
 * 2.不允许重复 ，同一键，后面的值覆盖前面的值
 */
public class TreeMapTest {


    @Test
    public void test() {

        TreeMap<Student, String> map = new TreeMap<Student, String>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0)
                    return o1.getAge() - o2.getAge();
                return result;
            }
        });

        map.put(new Student("lisi", 12), "nanjing");
        map.put(new Student("zhangsan", 122), "biejign");
        map.put(new Student("wuwu", 32), "shanghai");
        map.put(new Student("haha", 125), "tianjin");

        for (Map.Entry<Student, String> entry : map.entrySet()) {
            Student key = entry.getKey();
            System.out.println(key.getName() + ",age=" + key.getAge() + "<----->" + entry.getValue());
        }
    }
}


class Student implements Comparable<Student> {

    private String name;
    private int age;

    public Student(String name, int age) {
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
    public int compareTo(Student o) {
        int result = this.age - o.age;

        //当两人的年龄相同时，比较它们的姓名
        if (result == 0)
            return this.name.compareTo(o.name);
        return result;
    }
}