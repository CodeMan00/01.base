package utils.math;

import org.junit.Test;

/**
 * java.util.Math 类是数学相关工具类，里面提供了大量的静态方法
 */
public class MathTest {

    @Test
    public void test() {

        //返回绝对值
        //System.out.println(Math.abs(-1));

        //立方根
        //System.out.println(Math.cbrt(2));

        //大于指定数的最小值  返回的是double类型
        //System.out.println(Math.ceil(1.2));

        //小于指定数的最大值  返回的是double类型
        // System.out.println(Math.floor(1.2));

        //返回与参数最接近的整数。返回类型为double
        //System.out.println(Math.rint(1.2));

        //返回一个最接近的int、long型值
        System.out.println(Math.round(1.2));

        System.out.println(Math.max(1.2, 3));

        System.out.println(Math.min(1, 3));

//        返回e的3次方
        System.out.println(Math.exp(3));

        //返回2的3次方
        System.out.println(Math.pow(2, 3));

        //返回一个随机数
        System.out.println(Math.random());

        //平方根
        System.out.println(Math.sqrt(4));
    }
}
