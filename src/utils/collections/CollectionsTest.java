package utils.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 工具类Collections  它是专门用来对集合进行操作的。  都是静态方法， 没有构造方法
 */
public class CollectionsTest {

    @Test
    public void test() {

        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("dddd");
        list.add("deaaaaadfaa");
        list.add("gagaaaa");
        list.add("aaa1111aa");

        //System.out.println(list);

        //自然排序
        // Collections.sort(list);

        //  自定义排序规则
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
    }


    @Test
    public void test02() {

        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("dddd");
        list.add("deaaaaadfaa");
        list.add("gagaaaa");
        list.add("aaa1111aa");

        Collections.sort(list);

        System.out.println(list);
        //最大值就是排序后最后一个元素
        String max = Collections.max(list);

        //自定义最大值的比较规则
        String max1 = Collections.max(list, new Comparator<String>() {
            //定义谁长谁就是最大值
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(max1);
    }


    @Test
    public void test03() {

        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("dddd");
        list.add("deaaaaadfaa");
        list.add("gagaaaa");
        list.add("aaa1111aa");

        Collections.sort(list);

        System.out.println(list);
        //注意：进行二分查找  集合必须有序   如果查找的元素不在集合中，那么就返回该数据应该在该集合中的位置-1，也就是(插入点-1)
        int index = Collections.binarySearch(list, "aaaa");
        System.out.println(index);
    }


    @Test
    public void test04() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("dddd");
        list.add("deaaaaadfaa");
        list.add("gagaaaa");

        System.out.println(list);
        //把集合中的元素全换为abc
//        Collections.fill(list,"abc");
//        System.out.println(list);


        //把集合中的指定元素的全体  换成新的值
//        Collections.replaceAll(list,"aaaa","ababa");
//        System.out.println(list);


        //集合的反转
        Collections.reverse(list);
        System.out.println(list);
    }


    //reverseOrder方法  重点
    @Test
    public void test05() {

        //Collections.reverseOrder()  返回的是比较器，实现与自然顺序相反的比较器
        //Collections.reverseOrder(Comparator c) 它也可以带一个比较器参数
        //总结： reverseOrder方法就是实现反转
        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        set.add("abc");
        set.add("deg");
        set.add("bde");
        set.add("bad");

        //由于TreeSet会排序成自然顺序，我们可以通过Collections.reverseOrder()方法 ，将自然顺序颠倒
        System.out.println(set);
    }


    @Test
    public void test06() {

        teste(1, 2, 2, 3, 4);
    }

    //可变参数    实际上就是数组，隐形的把参数封装成了数组  也可以可以不传参数
    //  方法总的参数列表如果有可变参数和确定的参数，那么可变参数只能放在最后面
    public void teste(int... arr) {
        System.out.println(arr.length);
    }
}
