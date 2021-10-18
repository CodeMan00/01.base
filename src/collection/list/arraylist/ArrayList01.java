package collection.list.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 集合的基本特性：
 * <p>
 * 1.集合不能直接存储基本数据类型，需要转换为引用对象（集合只存储引用），注意：我们存储时，会出现自动装箱
 * 2.集合实际存储的是地址
 * 3.集合本身也是对象
 * 4.集合可以存储其他集合
 * <p>
 * 集合中不同的集合类型对应着不同的数据结构
 * ArrayList底层的数组     LinkedList底层对应的是链表      TreeSet对应的是二叉树
 * <p>
 * 集合都在java.util包下
 * <p>
 * <p>
 * 集合分为两种方式存储元素： 第一种：单个元素存储   第二种：键值对的方式进行存储
 * <p>
 * <p>
 * 集合的体系？
 * 第一层:(单个值)   超级父接口：Collection,它继承了Iterable(可迭代的，可遍历的)接口
 * 第二层：List(有序 存入的顺序和取出的顺序相同  可重复)
 * 第三层：LinkedList 底层链表  插入和删除  没有同步线程不安全
 * ArrayList 底层数组  随机访问  不同步线程不安全   初始容量为0  第一次添加时容量为10 1.5倍扩容
 * Vector  底层数组  同步 线程安全      初始容量为10  2倍扩容  已经淘汰  基本不用
 * Stack 是Vector的实现类
 * <p>
 * 第二层：Set（不可重复，并且无序）
 * 第三层：HashSet  使用hash表（数组）存储元素
 * LinkedHashSet 链表维护元素的插入次序
 * TreeSet 底层实现为二叉树  元素排好序
 * <p>
 * <p>
 * 第一层:(键值对)   超级父接口：Map
 * HashTable   同步 线程不安全
 * HashMap   没有同步 线程不安全  但效率比同步的高
 * LinkedHashMap   双项链表和哈希表实现
 * WeakHashMap
 * TreeMap   红黑树对所有的key排序
 * IdentifyHashMap
 */
public class ArrayList01 {

    public static void main(String[] args) {


    }

    ArrayList list = new ArrayList();

    //  list集合的添加元素方法
    @Test
    public void test01() {
        //1.直接在元素的最后添加元素
        list.add(100);
        list.add(300);
        //2.在指定位置上添加元素
        list.add(1, 200);

    }

    //删除元素
    @Test
    public void test02() {

        ArrayList list1 = new ArrayList();
        list1.add(100);
        list1.add(100);
        list1.add(20);
        //删除指定位置上的元素
        //list1.remove(1);

        //根据值删除  删除第一次出现的   注意：如果我们删除100这个元素，要自己进行封装，如果不封装会认为查询下标为100的元素，
        //如果集合中没有这么多元素就会报错，如果有那么多元素，删除的也不是我们要删除的元素。
        list1.remove(new Integer(100));

        System.out.println(list1);
    }


    //修改元素
    @Test
    public void test03() {
        //修改指定位置上的元素的值
        list.set(2, "haha");
    }

    //查找元素
    @Test
    public void test() {

        //通过下标获取元素
        System.out.println(list.get(1));

        //获取指定元素首次出现的下标，如果集合中没有该元素，则返回-1
        System.out.println(list.indexOf(100));
        //获取指定元素最后一次出现的位置
        System.out.println(list.lastIndexOf(100));

    }


    @Test
    public void test04() {

        list.add(100);
        list.add(20);
        //在进行迭代的过程中，如果对集合进行操作，不能使用集合的方法进行操作，而是使用迭代器中的方法
        //对其操作，但iterator对象中的方法有限，我们可以通过ListIterator(Iterator的子类)进行操作。
        ListIterator before = list.listIterator();

        //while(before.hasNext()) {
        //
        //    Object object = before.next();
        //    if (object.equals(100)){
        //       // before.add("10000");
        //        before.set(40);
        //    }
        //}


        //参数是表示开始遍历的元素的下标 (不带参数的listIterator方法默认的下标地址是-1)  它指向最后一个元素的后面的一个位置
        ListIterator after = list.listIterator(list.size());
        while (after.hasPrevious()) {
            System.out.println(after.previous() + "前一个元素的下标：" + after.previousIndex());
        }
    }


    @Test
    public void test05() {

        list.add(100);
        list.add(200);
        list.add(300);
        //截取一段list
        List list1 = list.subList(0, 1);

        //判断是否为空
        System.out.println(list.isEmpty());

        //判断是否包含指定元素
        System.out.println(list.contains("100"));

        System.out.println(list1);
    }
}
