package collection.list.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合中不能存储基本数据类型
 */
public class CollectionTest02 {

    public static void main(String[] args) {

        //多态
        Collection c = new ArrayList();

        //常用的方法

        //当存入的数据是基本数据类型时，会自动装箱    其次，它存放的是元素的地址
        c.add(100);
        c.add(true);
        c.add("haha");
        c.add(102.2);

        //元素的个数
        int size = c.size();

        //清空集合
        // c.clear();

        //删除集合中某个元素
        c.remove(100);

        //把集合转换为数组
        // Object[] objects =  c.toArray();

        /**
         *   Iterator
         *
         *   当创建完成指向某个集合或者容器的Iterator对象时，这时的指针其实指向的是第一个元素的上方
         * 当调用hasNext方法的时候，只是判断下一个元素的有无，并不移动指针
         *
         * 当调用next方法的时候，向下移动指针，并且返回指针指向的元素，如果指针指向的内存中没有元素，会报异 常。
         *
         * remove方法删除的元素是指针指向的元素。如果当前指针指向的内存中没有元素，那么会抛出异常。
         */


        Iterator iterator = c.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //System.out.println("是否包含100这个元素："+c.contains(100));
        //System.out.println("判断集合是否为空："+c.isEmpty());

        //System.out.println(c);

    }

    @Test
    public void test01() {

        ArrayList list = new ArrayList();
        ArrayList list1 = new ArrayList();

        list.add(100);
        list.add(500);
        list.add(300);

        list1.add(300);
        list1.add(200);
        list1.add(600);


        //该方法会把两个集合共有的元素存入到list集合中
        list.retainAll(list1);


        //把两个集合中相同的元素从list集合中删除
        list.removeAll(list1);

        System.out.println(list);
    }

    @Test
    public void test02() {


    }
}
