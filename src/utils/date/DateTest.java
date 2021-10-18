package utils.date;

import com.sun.org.apache.bcel.internal.generic.DASTORE;
import org.junit.Test;

import java.util.Date;

/**
 * Date
 * <p>
 * 中国属于东八区，会把时间增加8个小时
 * 1970年1月1日 08:00:00
 */
public class DateTest {

    public static void main(String[] args) {

        //获取当前系统时间到1970年1月1日 00:00:00 经历了多少秒
        //System.out.println(System.currentTimeMillis());

        //获取当前系统时间  返回的是：Tue Sep 21 20:22:32 CST 2021    cst表示中国标准时间
        //System.out.println(new Date());

        //参数是传递毫秒值  把毫秒值转换为Date日期
        Date date = new Date(0L);
        System.out.println(date);

    }

    @Test
    public void test() {

        Date date = new Date();
        //把日期转换为毫秒值
        long l = date.getTime();
        System.out.println(l);
    }
}
