package utils.system;

import org.junit.Test;

import java.util.Arrays;

/**
 * java.lang.System
 * 提供了大量的静态类，获取系统相关信息
 */
public class SystemTest {

    @Test
    public void test() {

        //返回当前系统时间距离1970.1.1 00:00:00 的毫秒值
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    /**
     * 数组的拷贝
     * <p>
     * 应注意：
     * 1.要复制数组元素的个数(最后一个参数)不能大于目的数组的长度
     */

    @Test
    public void test01() {

        //定义原数组
        int[] from = {1, 2, 3, 4, 5, 6};
//        定义目标数组
        int[] to = {5, 6, 7, 8};

        //第一个参数是原数组 第二个是原数组开始复制的位置  第三个参数是目的数组  第四个参数是目标数组的起始位置
        //第五个参数是 要复制数组的长度
        System.arraycopy(from, 0, to, 0, 4);
        System.out.println(Arrays.toString(to));
    }
}
