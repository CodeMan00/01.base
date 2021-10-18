package utils.date;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Calendar;
import java.util.Date;

/***
 *  java.util.Calendar
 *
 *  Calendar是一个抽象类，不能直接创建对象，通过getInstance()方法获取一个对象
 *
 */
public class CalendarTest {

    @Test
    public void test() {

        //获取Calenar对象
        Calendar instance = Calendar.getInstance();

//       通过get()获取具体字段的值
        int year = instance.get(Calendar.YEAR);
//        西方 0 - 11   东方：1 - 12
        int month = instance.get(Calendar.MONTH) + 1;
        int minute = instance.get(Calendar.MINUTE);
        int secnod = instance.get(Calendar.SECOND);
        int hour = instance.get(Calendar.HOUR);

        System.out.println(instance);
    }

    @Test
    public void test01() {

        Calendar instance = Calendar.getInstance();

        //设置年
        instance.set(Calendar.YEAR, 1999);
//        设置月
        instance.set(Calendar.MONTH, 1);
//        设置日
        instance.set(Calendar.DATE, 19);
        //同时设置年月日
        instance.set(1999, 11, 14);

    }

    @Test
    public void test02() {

        Calendar instance = Calendar.getInstance();

        //可以把日历转换为日期
        Date time = instance.getTime();
        System.out.println(time);


//      给指定字段加上或减去一段时间
        instance.add(Calendar.YEAR, 2);
        instance.add(Calendar.MONTH, -2);

        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH) + 1);
    }
}