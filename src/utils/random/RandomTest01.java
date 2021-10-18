package utils.random;

import org.junit.Test;

import java.util.Random;

/**
 * 用来生成随机数
 */
public class RandomTest01 {

    @Test
    public void test() {

        Random random = new Random();

        //nextInt方法所产生的随机数的范围是int类型的范围(有正有负)
        int num = random.nextInt();
        System.out.println("int类型的随机数：" + num);

        //产生的随机数小于100  范围是[0,99]
        int num2 = random.nextInt(100);
        System.out.println("小于100的整数：" + num2);
    }
}
