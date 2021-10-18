package collection.set.treeset;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet
 * 无序，它会对存入的元素进行排序（如字母，则会按照字母顺序表排序；数字，则会按照大小排序）
 * <p>
 * 注意：
 * 1.TreeSet集合在存元素到集合中，会进行排序，当向集合中存入我们自定的实体对象时，我们并没有指定
 * 比较的方法，所以会发生异常。注意，只存入一个元素时，不会抛出异常，因为不用比较。
 * 解决办法：我们使自定义的实体对象具备可比较性，这样就可以实现排序，而不会抛出异常。
 * 使自定义对象具备可比较性，就需要自定义类实现Comparable接口
 * <p>
 * 2.当主要条件相同时，比较次要条件，并且按照次要条件进行排序
 * <p>
 * 3.TreeSet底层是二叉树，在排序过程中是应用的二叉排序树的思想
 * <p>
 * TreeSet第一种排序方式：
 * 让集合中的元素具有可比较性，元素需要实现Comparable接口，覆盖compareTo方法。
 * TreeSet的第二种排序方式（比较器）：
 * 当元素自身不具备比较性时，或者具备的比较性不是所需要的。 这时就需要让集合具有可比较性。
 * 在集合初始化时，就具备可比较性。
 * <p>
 * 当两种排序方式都存在时，以第二种方式（比较器）为主
 */
public class TreeSetTest {

    /**
     * 第一种排序方式
     */

    public static void main(String[] args) {

        //按照学生的年龄进行排序

        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student("zhangsan", 14));
        set.add(new Student("lisi", 12));
        set.add(new Student("wangwu", 13));
        set.add(new Student("zhangsan", 12));

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getName() + "--->" + student.getAge());
        }
    }

    /**
     * 第二种排序方式
     */
    @Test
    public void test01() {

        TreeSet<Teacher> set = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0)
                    return o1.getAge() - o2.getAge();
                return result;
            }
        });
        set.add(new Teacher("zhangsan", 14));
        set.add(new Teacher("lisi", 12));
        set.add(new Teacher("wangwu", 13));
        set.add(new Teacher("zhangsan", 12));

        Iterator<Teacher> iterator = set.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            System.out.println(teacher.getName() + "--->" + teacher.getAge());
        }
    }

    @Test
    public void test() {

        TreeSet<String> set = new TreeSet<>();
        set.add("abc");
        set.add("abe");
        set.add("abd");
        set.add("cac");
        set.add("bac");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}

/**
 * 第一种排序方式
 */
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

/**
 * 第二种排序方式
 */
class Teacher {
    private String name;
    private int age;

    public Teacher(String name, int age) {
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
}
