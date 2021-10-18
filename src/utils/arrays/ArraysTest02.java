package utils.arrays;

import org.junit.Test;

import java.util.Arrays;

public class ArraysTest02 {

    @Test
    public void test() {

        //检查数组中是否包含某个值
        Integer[] ints = {1, 2, 3, 4, 5, 6};
        boolean b = Arrays.asList(ints).contains(1);
        //System.out.println(b);


    }


    //使用二分法查找指定元素   当搜索元素是数组元素时，返回该元素的索引值  当搜索元素不是数组元素时，返回  -（索引值+1）
    @Test
    public void test02() {

        Integer[] integers = {1, 3, 345, 5};
        Arrays.sort(integers);
        int index = Arrays.binarySearch(integers, 5);
        //注意：这时候的位置会排序后的位置，不是元素所在原始数组的位置
        System.out.println(index);
    }


    //数组的拷贝
    @Test
    public void test03() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        //从下标0开始，如果超过原数组长度，就用null进行填充。
        //Integer [] arr2 = Arrays.copyOf(arr1,arr1.length+1);
        //System.out.println(Arrays.toString(arr2));


        //拷贝一部分
        Integer[] arr3 = Arrays.copyOfRange(arr1, 0, 3);
        System.out.println(Arrays.toString(arr3));
    }


    //数组的比较
    @Test
    public void test04() {
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"a", "b", "c"};
        String[] s3 = {"a", "b", "c", "d"};

        System.out.println(Arrays.equals(s1, s2));
        System.out.println(Arrays.equals(s1, s3));
    }


    //填充
    @Test
    public void test05() {

        int[] ints = {1, 2, 3, 4, 5};

        //整个数组进行填充
        //Arrays.fill(ints,12);

        //填充一部分元素  含头不含尾
        Arrays.fill(ints, 1, 3, 9);
        System.out.println(Arrays.toString(ints));
    }
}
