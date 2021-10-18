package utils.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java.util.Arrays 是一个与数组相关的工具类，里面提供了大量的静态方法   用来实现数组常见的操作
 */
public class ArraysTest {

    @Test
    public void test() {
        int[] array = {10, 22, 12, 14};

        //将int数组按照数组的默认格式转换为字符串
        //String s = Arrays.toString(array);

        //对原数组直接排序  而不是返回一个新的数组   查看数组元素，可以通过toString方法，比较方便，不需要遍历了
        //Arrays.sort(array);
        //System.out.println(Arrays.toString(array));


        //按照字母的先后进行排序
        String[] strs = {"abc", "def", "aeg"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test02() {
        //转换为ArrayList

        String[] strs = {"abc", "def", "aeg"};
        List list = Arrays.asList(strs);
        System.out.println(list.size());

        /**
         * asList 方法的参数必须是对象或者对象数组，而原生数据类型不是对象——
         * 这也正是包装类出现的一个主要原因。当传入一个原生数据类型数组时，asList
         * 的真正得到的参数就不是数组中的元素，而是数组对象本身！此时List 的唯
         * 一元素就是这个数组。
         */
        int[] test = {1, 2, 3, 4};
        List list1 = Arrays.asList(test);
        //输出结果为什么是1 而不是4
        System.out.println(list1.size());

        Integer[] integers = {1, 2, 3, 4, 5};
        List list2 = Arrays.asList(integers);
        System.out.println(list2.size());
    }


    @Test
    public void test03() {
        //返回一个由指定数组生成的固定大小的 List  这也就意味着任何改变其大小的操
        // 作都是不允许的。

        /**
         * 按道理 List 本就支持动态扩容，那为什么偏偏 asList 方法产生的 List 就是固定大小的呢？
         *
         * 答案：asList 方法返回的确实是一个 ArrayList ,但这个 ArrayList 并不是
         * java.util.ArrayList ，而是 java.util.Arrays 的一个内部类。
         * 这个内部类用一个 final 数组来保存元素，因此用 asList 方法产生的 ArrayList 是不可修改大小的。
         *
         *
         *  解决办法：
         *          我们可以创建一个新的ArrayList类
         */

        Integer[] array = {1, 2, 3, 4, 5};
        List list = Arrays.asList(array);

        //解决不能改变返回的list容量大小的问题
        ArrayList arrayList = new ArrayList(Arrays.asList(array));
        arrayList.add(111);
        System.out.println(arrayList);

    }

    //用自己的方法实现数组到List的转换
    @Test
    public void test04() {

        Integer[] array = {1, 2, 3, 4, 5};
        ArrayList list = new ArrayList();
        for (Integer s : array) {
            list.add(s);
        }
        System.out.println(list);
    }
}
